package com.test.taxcalculator.calculators;

import com.test.taxcalculator.calculators.port.CompanyTax;

public class SasTax extends CompanyTax {
    private final String headOfficeAddress;
    private final Double tax = 0.33D;

    public SasTax(String name, Long siretNumber, Double revenue, String headOfficeAddress){
        super(name,siretNumber,revenue);
        this.headOfficeAddress = headOfficeAddress;
    }

    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    @Override
    public Double computeTaxe() {
        return this.getRevenue() * this.tax;
    }
}
