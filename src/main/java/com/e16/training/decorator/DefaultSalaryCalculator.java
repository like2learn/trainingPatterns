package com.e16.training.decorator;

public class DefaultSalaryCalculator implements SalaryCalculator{
    private static final int MONTHS_IN_YEAR = 12;

    public static int getMonthsInYear() {
        return MONTHS_IN_YEAR;
    }

    @Override
    public double calculate(double grossAnnual) {
        return grossAnnual / MONTHS_IN_YEAR;
    }
}
