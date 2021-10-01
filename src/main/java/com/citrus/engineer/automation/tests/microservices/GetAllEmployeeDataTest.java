package com.citrus.engineer.automation.tests.microservices;

import com.citrus.engineer.automation.webservices.employee.EmployeeApi;
import com.citrus.engineer.automation.webservices.employee.pojos.GetAllEmployeeDataResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetAllEmployeeDataTest {

    private static final EmployeeApi EMPLOYEE_API = new EmployeeApi();

    @Test
    void testResponseSanity(){
        GetAllEmployeeDataResponse allEmployeeData = EMPLOYEE_API.getAllEmployeeData();

        Assertions.assertThat(allEmployeeData.response().getStatusCode()).isEqualTo(200);
        Assertions.assertThat(allEmployeeData).isNotNull().hasNoNullFieldsOrProperties();
    }

    @Test
    void testResponseDataType(){
        GetAllEmployeeDataResponse allEmployeeData = EMPLOYEE_API.getAllEmployeeData();

        Assertions.assertThat(allEmployeeData.getStatus()).isNotBlank().isNotEmpty().doesNotContainOnlyWhitespaces();
        Assertions.assertThat(allEmployeeData.getData()).isNotEmpty();
        for (GetAllEmployeeDataResponse.Data data : allEmployeeData.getData()){
            Assertions.assertThat(data.getEmployee_name()).isNotEmpty().doesNotContainOnlyWhitespaces();
            Assertions.assertThat(data.getEmployee_age()).containsOnlyDigits();
            Assertions.assertThat(data.getEmployee_salary()).containsOnlyDigits();
            Assertions.assertThat(data.getId()).containsOnlyDigits();
            Assertions.assertThat(data.getProfile_image()).isEmpty();
        }
    }
}
