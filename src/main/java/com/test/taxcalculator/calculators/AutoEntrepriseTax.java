package com.test.taxcalculator.calculators;

import com.test.taxcalculator.calculators.port.CompanyTax;

public class AutoEntrepriseTax extends CompanyTax {

    private final Double tax = 0.25D;

    public AutoEntrepriseTax(String name, Long siretNumber, Double revenue) {
        super(name, siretNumber, revenue);
    }

    @Override
    public Double computeTaxe() {
        return this.getRevenue() * this.tax;
    }
}
