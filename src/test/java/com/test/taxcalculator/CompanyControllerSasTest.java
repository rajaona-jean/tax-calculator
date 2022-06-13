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
    void shouldComputeDueTaxeForSas() {
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

    @Test
    void shouldThrowErrorIfNullRevenueSetForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setRevenue(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNullNameSetForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setName(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNullSiretSetForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNoNameSetForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setName("").setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfRevenueIsLessThan0ForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setRevenue(-3D).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfSiretNumberLengthIsLessThan14ForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(1223121L).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfSiretNumberLengthIsHigherThan14ForSas() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(122312112312311L).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

}
