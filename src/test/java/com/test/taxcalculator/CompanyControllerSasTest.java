package com.test.taxcalculator;

import com.test.taxcalculator.routes.CompanyController;
import com.test.taxcalculator.routes.model.CompanyForm;
import com.test.taxcalculator.routes.model.CompanyType;
import com.test.taxcalculator.routes.model.CompanyWithComputedTax;
import com.test.taxcalculator.routes.model.exception.NotValidCompanyForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyControllerSasTest {

    @Test
    void shouldComputeDueTaxe() {
        // Expected
        double SasTaxRate = 0.33D;
        CompanyWithComputedTax expectedCompanyWithComputedTax = new CompanyWithComputedTax("company test", 12334568912345L, 100000D, 100000D * SasTaxRate);

        // Given
        CompanyForm companyForm = new CompanyForm("company test", 12334568912345L, "23 rue des tests", 100000D, CompanyType.SAS);

        // When
        CompanyWithComputedTax companyWithComputedTax = new CompanyController().getDueTaxe(companyForm);

        // Then
        Assertions.assertEquals(expectedCompanyWithComputedTax, companyWithComputedTax);
    }

}
