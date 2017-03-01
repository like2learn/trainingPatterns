package com.e16.training.decoratorfunc;


import com.e16.training.decorator.Taxes;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

public class CalculateSalary {
    private final double annualGross;

    public CalculateSalary(double annualGross) {
        this.annualGross = annualGross;
    }

    public double getSalary() {
        return new DefaultSalaryCalculator()
                .andThen(Taxes::generalTax)
                .andThen(Taxes::regionalTax)
                .andThen(Taxes::healthInsurance)
                .applyAsDouble(annualGross);
    }

    public double getSalaryAdvance() {
        return getSalaryAdvanceHelper(new DefaultSalaryCalculator(),
                Taxes::generalTax, Taxes::regionalTax, Taxes::healthInsurance);
    }

    private double getSalaryAdvanceHelper(DoubleUnaryOperator... taxes) {
        return Stream.of(taxes).reduce(DoubleUnaryOperator.identity(),
                DoubleUnaryOperator::andThen)
                .applyAsDouble(annualGross);
    }

    public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
        private static final int MONTHS_IN_YEAR = 12;

        @Override
        public double applyAsDouble(double grossAnnual) {
            return grossAnnual / MONTHS_IN_YEAR;
        }

        public static int getMonthsInYear() {
            return MONTHS_IN_YEAR;
        }
    }
}
