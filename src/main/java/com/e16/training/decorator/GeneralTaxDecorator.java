package com.e16.training.decorator;

public class GeneralTaxDecorator extends AbstractTaxDecorator {

    public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
        super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
        return Taxes.generalTax(salary);
    }
}
