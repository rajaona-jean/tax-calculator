package com.test.taxcalculator.routes.model;

import java.util.Objects;

public class CompanyForm {
    public final String name;
    public final Long siretNumber;
    public final String headOfficeAddress;
    public final Double revenue;
    public final CompanyType companyType;

    public CompanyForm(String name, Long siretNumber, String headOfficeAddress, Double revenue, CompanyType companyType) {
        this.name = name;
        this.siretNumber = siretNumber;
        this.headOfficeAddress = headOfficeAddress;
        this.revenue = revenue;
        this.companyType = companyType;
    }

    public Boolean isFormValid(){
        return !this.isNullForm() && !this.name.isEmpty() && this.siretNumber.toString().length() == 14 && this.revenue >= 0;
    }

    private Boolean isNullForm(){
        return Objects.isNull(this.name) || Objects.isNull(this.siretNumber) || Objects.isNull(this.revenue);
    }
}
