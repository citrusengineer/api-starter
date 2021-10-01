package com.citrus.engineer.automation.tests.microservices;

import com.citrus.engineer.automation.data.NewEmployeeFactory;
import com.citrus.engineer.automation.webservices.employee.EmployeeApi;
import com.citrus.engineer.automation.webservices.employee.pojos.CreateNewEmployeeRequest;
import com.citrus.engineer.automation.webservices.employee.pojos.CreateNewEmployeeResponse;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CreateNewEmployeeTest {

    private static final EmployeeApi EMPLOYEE_API = new EmployeeApi();

    @Test
    void testResponseSanity(){
        CreateNewEmployeeRequest requestBody = NewEmployeeFactory.getNewEmployeeData();

        CreateNewEmployeeResponse newEmployeeData = EMPLOYEE_API.createNewEmployee(requestBody);

        Assertions.assertThat(newEmployeeData.response().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        Assertions.assertThat(newEmployeeData).isNotNull().hasNoNullFieldsOrProperties();
    }

    @Test
    void testResponseData(){
        CreateNewEmployeeRequest requestBody = NewEmployeeFactory.getNewEmployeeData();

        CreateNewEmployeeResponse newEmployeeData = EMPLOYEE_API.createNewEmployee(requestBody);

        Assertions.assertThat(newEmployeeData.getData().getName()).isEqualTo(requestBody.getName());
        Assertions.assertThat(newEmployeeData.getData().getAge()).isEqualTo(requestBody.getAge());
        Assertions.assertThat(newEmployeeData.getData().getSalary()).isEqualTo(requestBody.getSalary());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"176", "@#$*()&*%"})
    void testNameField(String invalidValue){
        CreateNewEmployeeRequest requestBody = NewEmployeeFactory.getNewEmployeeData();
        requestBody.setName(invalidValue);

        CreateNewEmployeeResponse newEmployeeData = EMPLOYEE_API.createNewEmployee(requestBody);

        Assertions.assertThat(newEmployeeData.response().getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abc", "@#$*()&*%"})
    void testAgeField(String invalidValue){
        CreateNewEmployeeRequest requestBody = NewEmployeeFactory.getNewEmployeeData();
        requestBody.setAge(invalidValue);

        CreateNewEmployeeResponse newEmployeeData = EMPLOYEE_API.createNewEmployee(requestBody);

        Assertions.assertThat(newEmployeeData.response().getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }
}
