package com.citrus.engineer.automation.webservices.employee;

import com.citrus.engineer.automation.utils.EnvironmentUtils;
import com.citrus.engineer.automation.webservices.core.Api;
import com.citrus.engineer.automation.webservices.core.ResponseObject;
import com.citrus.engineer.automation.webservices.employee.enums.EmployeeEndpoints;
import com.citrus.engineer.automation.webservices.employee.pojos.CreateNewEmployeeRequest;
import com.citrus.engineer.automation.webservices.employee.pojos.CreateNewEmployeeResponse;
import com.citrus.engineer.automation.webservices.employee.pojos.GetAllEmployeeDataResponse;
import io.restassured.response.Response;

public class EmployeeApi implements Api {

    public GetAllEmployeeDataResponse getAllEmployeeData(){
        Response response = init().get(EmployeeEndpoints.GET_ALL_EMPLOYEE_DATA);

        return ResponseObject.as(GetAllEmployeeDataResponse.class, response);
    }

    public CreateNewEmployeeResponse createNewEmployee(CreateNewEmployeeRequest requestBody){
        Response response = init().body(requestBody).post(EmployeeEndpoints.CREATE_NEW_EMPLOYEE);

        return ResponseObject.as(CreateNewEmployeeResponse.class, response);
    }

    @Override
    public String getDomain() {
        return EnvironmentUtils.get().getDomains().getEmployeeApi();
    }
}
