package com.test.taxcalculator.calculators.port;

abstract public class CompanyTax {
    private final String name;
    private final Long siretNumber;
    private final Double revenue;

    public CompanyTax(String name, Long siretNumber, Double revenue){
        this.name = name;
        this.siretNumber = siretNumber;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public Long getSiretNumber() {
        return siretNumber;
    }

    public Double getRevenue() {
        return revenue;
    }

    public abstract Double computeTaxe();
}
