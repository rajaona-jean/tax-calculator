package com.test.taxcalculator.routes;

import com.test.taxcalculator.routes.adapter.CompanyWithComputedTaxBuilder;
import com.test.taxcalculator.routes.model.CompanyForm;
import com.test.taxcalculator.routes.model.CompanyWithComputedTax;
import com.test.taxcalculator.routes.model.exception.ApiError;
import com.test.taxcalculator.routes.model.exception.ApiErrorCode;
import com.test.taxcalculator.routes.model.exception.NotValidCompanyForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    public CompanyController() {
    }

    @PostMapping("/dueTax")
    public CompanyWithComputedTax getDueTaxe(@RequestBody CompanyForm companyForm) {
        if(!companyForm.isFormValid()){
            throw new NotValidCompanyForm();
        }
        return new CompanyWithComputedTaxBuilder(companyForm).build();
    }

    @ExceptionHandler(NotValidCompanyForm.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleNotValidCompanyFormError() {
        ApiError apiError = new ApiError("Name, Siret Number and Revenue are mandatory", ApiErrorCode.NOT_VALID_COMPANY_FORM);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
