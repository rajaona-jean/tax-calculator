package com.test.taxcalculator.routes.adapter;

import com.test.taxcalculator.calculators.SasTax;
import com.test.taxcalculator.calculators.port.CompanyTax;
import com.test.taxcalculator.routes.model.CompanyForm;
import com.test.taxcalculator.routes.model.CompanyType;
import com.test.taxcalculator.routes.model.CompanyWithComputedTax;

import java.util.HashMap;
import java.util.Map;

public class CompanyWithComputedTaxBuilder {

    Map<CompanyType, CompanyTax> companyTaxMap = new HashMap<>();
    private final CompanyType companyType;

    public CompanyWithComputedTaxBuilder(CompanyForm companyForm) {
        this.companyType = companyForm.companyType;
        this.companyTaxMap.put(CompanyType.SAS, new SasTax(companyForm.name, companyForm.siretNumber, companyForm.revenue, companyForm.headOfficeAddress));
    }

    public CompanyWithComputedTax build() {
        CompanyTax companyTax = companyTaxMap.get(this.companyType);
        return new CompanyWithComputedTax(companyTax.getName(), companyTax.getSiretNumber(), companyTax.getRevenue(), companyTax.computeTaxe());
    }
}
