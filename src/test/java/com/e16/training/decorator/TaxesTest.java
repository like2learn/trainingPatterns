package com.e16.training.decorator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaxesTest {
    private static final double SALARY = 10000;

    @Test
    public void whenCallGeneralTaxThanApplyGeneralTax() throws Exception {
        double expected = SALARY * Taxes.getGeneralTaxValue();
        double actual = Taxes.generalTax(SALARY);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallRegionalTaxThanApplyRegionalTax() throws Exception {
        double expected = SALARY * Taxes.getRegionalTaxValue();
        double actual = Taxes.regionalTax(SALARY);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenCallHealthInsuranceThanApplyHealthInsurance() throws Exception {
        double expected = SALARY - Taxes.getHealthInsuranceValue();
        double actual = Taxes.healthInsurance(SALARY);

        assertThat(actual, is(expected));
    }

}