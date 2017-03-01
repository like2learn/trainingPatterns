package com.e16.training.decorator;

/**
 * Apply multiple decorators
 */
public class CalculateSalary {
    private final double annualGross;

    public CalculateSalary(double annualGross) {
        this.annualGross = annualGross;
    }

    public double getSalary() {
        return new HealthInsuranceDecorator(new RegionalTaxDecorator(
                new GeneralTaxDecorator(new DefaultSalaryCalculator()))).calculate(annualGross);
    }
}
