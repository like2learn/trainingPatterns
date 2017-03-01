package com.e16.training.decorator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DecoratorTest {
    private static final double GROSS_ANNUAL = 30000.00;
    private static final double GROSS_MONTH = GROSS_ANNUAL / DefaultSalaryCalculator.getMonthsInYear();
    private static final DefaultSalaryCalculator defaultSalaryCalculator = new DefaultSalaryCalculator();

    @Test
    public void whenCallDefaultSalaryCalculatorThenReturnSalary() {
        double actual = defaultSalaryCalculator.calculate(GROSS_ANNUAL);

        assertThat(actual, is(GROSS_MONTH));
    }

    @Test
    public void whenCallGeneralTaxDecoratorThenApplyGeneralTax() {
        double expected = GROSS_MONTH * Taxes.getGeneralTaxValue();
        double actual = new GeneralTaxDecorator(defaultSalaryCalculator).calculate(GROSS_ANNUAL);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallRegionalTaxDecoratorThenApplyRegionalTax() {
        double expected = GROSS_MONTH * Taxes.getRegionalTaxValue();
        double actual = new RegionalTaxDecorator(defaultSalaryCalculator).calculate(GROSS_ANNUAL);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallHealthInsuranceDecoratorThenApplyHealthInsurance() {
        double expected = GROSS_MONTH - Taxes.getHealthInsuranceValue();
        double actual = new HealthInsuranceDecorator(defaultSalaryCalculator).calculate(GROSS_ANNUAL);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallMultipleDecoratorsThenApplyMultipleTaxes() {
        double expected = GROSS_MONTH * Taxes.getGeneralTaxValue()
                * Taxes.getRegionalTaxValue() - Taxes.getHealthInsuranceValue();
        double actual = new HealthInsuranceDecorator(new RegionalTaxDecorator(
                new GeneralTaxDecorator(new DefaultSalaryCalculator()))).calculate(GROSS_ANNUAL);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallCalculateSalaryThenApplyMultipleTaxes() {
        double expected = GROSS_MONTH * Taxes.getGeneralTaxValue()
                * Taxes.getRegionalTaxValue() - Taxes.getHealthInsuranceValue();
        double actual = new CalculateSalary(GROSS_ANNUAL).getSalary();

        assertThat(actual, is(expected));
    }
}