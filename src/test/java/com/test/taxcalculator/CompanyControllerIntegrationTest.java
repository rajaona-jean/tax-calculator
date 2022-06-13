package com.test.taxcalculator;

import com.test.taxcalculator.routes.model.exception.ApiErrorCode;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldHandleNotValidCompanyFormError() throws Exception {
        // Given
        JSONObject requestBody = new JSONObject();
        requestBody
                .put("name", "test")
                .put("siretNumber", 12345678912345L)
                .put("revenue", null)
                .put("companyType", "SAS");

        var mockRequestBuilder = post("/company/dueTax")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody.toString());

        // When
        this.mockMvc.perform(mockRequestBuilder)
                // Then
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(ApiErrorCode.NOT_VALID_COMPANY_FORM.toString()))
                .andExpect(jsonPath("$.technicalMessage").value("Name, Siret Number and Revenue are mandatory"));
    }

    @Test
    public void shouldReturnCompanyWithComputedTax() throws Exception {
        // Given
        JSONObject requestBody = new JSONObject();
        requestBody
                .put("name", "test")
                .put("siretNumber", 12345678912345L)
                .put("revenue", 10)
                .put("companyType", "SAS");

        var mockRequestBuilder = post("/company/dueTax")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody.toString());

        // When
        this.mockMvc.perform(mockRequestBuilder)
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.siretNumber").value(12345678912345L))
                .andExpect(jsonPath("$.revenue").value(10))
                .andExpect(jsonPath("$.tax").value(10 * 0.33));
    }
}
