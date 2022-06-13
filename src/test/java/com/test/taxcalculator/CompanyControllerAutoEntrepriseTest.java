package com.test.taxcalculator;

import com.test.taxcalculator.routes.CompanyController;
import com.test.taxcalculator.routes.model.CompanyForm;
import com.test.taxcalculator.routes.model.CompanyType;
import com.test.taxcalculator.routes.model.CompanyWithComputedTax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyControllerAutoEntrepriseTest {

    @Test
    void shouldComputeDueTaxe() {
        // Expected
        double AutoEntrepriseTaxRate = 0.25D;
        CompanyWithComputedTax expectedCompanyWithComputedTax = new CompanyWithComputedTax("company test", 12334568912345L, 100000D, 100000D * AutoEntrepriseTaxRate);

        // Given
        CompanyForm companyForm = new CompanyForm("company test", 12334568912345L, null, 100000D, CompanyType.AUTO_ENTREPRISE);

        // When
        CompanyWithComputedTax companyWithComputedTax = new CompanyController().getDueTaxe(companyForm);

        // Then
        Assertions.assertEquals(expectedCompanyWithComputedTax, companyWithComputedTax);
    }
}
