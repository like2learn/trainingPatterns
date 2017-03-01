package com.e16.training.decorator;


/**
 * Apply taxes
 */
public class Taxes {
    private static final double GENERAL_TAX_VALUE = 0.8;
    private static final double REGIONAL_TAX_VALUE = 0.95;
    private static final double HEALTH_INSURANCE_VALUE = 200;


    public static double generalTax(double salary) {
        return salary * GENERAL_TAX_VALUE;
    }

    public static double regionalTax(double salary) {
        return salary * REGIONAL_TAX_VALUE;
    }

    public static double healthInsurance(double salary) {
        return salary - HEALTH_INSURANCE_VALUE;
    }

    public static double getGeneralTaxValue() {
        return GENERAL_TAX_VALUE;
    }

    public static double getRegionalTaxValue() {
        return REGIONAL_TAX_VALUE;
    }

    public static double getHealthInsuranceValue() {
        return HEALTH_INSURANCE_VALUE;
    }
}
