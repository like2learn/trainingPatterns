package com.e16.training.decoratorfunc;

import com.e16.training.decorator.Taxes;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DecoratorFuncTest {
    private static final double GROSS_ANNUAL = 60000.00;
    private static final double GROSS_MONTH = GROSS_ANNUAL / CalculateSalary.DefaultSalaryCalculator.getMonthsInYear();
    private static final double RESULT_OF_APPLY_MULTIPLE_TAXES = GROSS_MONTH * Taxes.getGeneralTaxValue()
            * Taxes.getRegionalTaxValue() - Taxes.getHealthInsuranceValue();

    @Test
    public void whenCallDefaultSalaryCalculatorThenReturnSalary() {
        double actual = new CalculateSalary.DefaultSalaryCalculator().applyAsDouble(GROSS_ANNUAL);

        assertThat(actual, is(GROSS_MONTH));
    }

    @Test
    public void whenCallGetSalaryThenApplyMultipleTaxes() {
        double actual = new CalculateSalary(GROSS_ANNUAL).getSalary();

        assertThat(actual, is(RESULT_OF_APPLY_MULTIPLE_TAXES));
    }

    @Test
    public void whenCallGetSalaryAdvanceThenApplyMultipleTaxes() {
        double actual = new CalculateSalary(GROSS_ANNUAL).getSalaryAdvance();

        assertThat(actual, is(RESULT_OF_APPLY_MULTIPLE_TAXES));
    }
}