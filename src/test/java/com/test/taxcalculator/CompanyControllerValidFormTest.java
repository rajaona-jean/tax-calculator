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
class CompanyControllerValidFormTest {

    @Test
    void shouldThrowErrorIfNullRevenueSet() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setRevenue(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNullNameSet() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setName(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNullSiretSet() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(null).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfNoNameSet() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setName("").setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfRevenueIsLessThan0() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setRevenue(-3D).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfSiretNumberLengthIsLessThan14() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(1223121L).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

    @Test
    void shouldThrowErrorIfSiretNumberLengthIsHigherThan14() {
        // Given
        CompanyForm companyForm = new CompanyFormFakeBuilder().setSiretNumber(122312112312311L).setCompanyType(CompanyType.SAS).build();

        // When
        Assertions.assertThrows(NotValidCompanyForm.class, () -> new CompanyController().getDueTaxe(companyForm));
    }

}
