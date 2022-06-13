package com.test.taxcalculator.routes.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CompanyWithComputedTax {
    public final String name;
    public final Long siretNumber;
    public final Double revenue;
    public final Double tax;

    public CompanyWithComputedTax(String name, Long siretNumber, Double revenue, Double tax) {
        this.name = name;
        this.siretNumber = siretNumber;
        this.revenue = revenue;
        this.tax = tax;
    }
}
