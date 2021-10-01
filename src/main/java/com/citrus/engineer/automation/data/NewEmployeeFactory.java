package com.citrus.engineer.automation.data;

import com.citrus.engineer.automation.webservices.employee.pojos.CreateNewEmployeeRequest;
import org.apache.commons.lang3.RandomStringUtils;

public class NewEmployeeFactory {

    private NewEmployeeFactory(){}

    public static CreateNewEmployeeRequest getNewEmployeeData() {
        CreateNewEmployeeRequest requestData = new CreateNewEmployeeRequest();
        requestData.setName(RandomStringUtils.randomAlphabetic(7));
        requestData.setAge(RandomStringUtils.randomNumeric(2));
        requestData.setSalary(RandomStringUtils.randomNumeric(6));

        return requestData;
    }
}
