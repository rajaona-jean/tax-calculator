package com.test.taxcalculator;

import com.test.taxcalculator.routes.model.CompanyForm;
import com.test.taxcalculator.routes.model.CompanyType;

public class CompanyFormFakeBuilder {
    private String name = "company test";
    private Long siretNumber = 12334568912345L;
    private String headOfficeAddress = "23 rue des tests";
    private Double revenue = 100000D;
    private CompanyType companyType = CompanyType.SAS;

    public CompanyFormFakeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyFormFakeBuilder setSiretNumber(Long siretNumber) {
        this.siretNumber = siretNumber;
        return this;
    }

    public CompanyFormFakeBuilder setHeadOfficeAddress(String headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress;
        return this;
    }

    public CompanyFormFakeBuilder setRevenue(Double revenue) {
        this.revenue = revenue;
        return this;
    }

    public CompanyFormFakeBuilder setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
        return this;
    }

    public CompanyForm build(){
        return new CompanyForm(this.name, this.siretNumber, this.headOfficeAddress, this.revenue, this.companyType);
    }
}
