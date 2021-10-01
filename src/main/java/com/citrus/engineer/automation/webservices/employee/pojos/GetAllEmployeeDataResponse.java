package com.citrus.engineer.automation.webservices.employee.pojos;

import com.citrus.engineer.automation.webservices.core.ResponseObject;

public class GetAllEmployeeDataResponse extends ResponseObject {
    private String status;
    private Data[] data;

    public static class Data{
        private String id;
        private String employee_name;
        private String employee_salary;
        private String employee_age;
        private String profile_image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public String getEmployee_salary() {
            return employee_salary;
        }

        public void setEmployee_salary(String employee_salary) {
            this.employee_salary = employee_salary;
        }

        public String getEmployee_age() {
            return employee_age;
        }

        public void setEmployee_age(String employee_age) {
            this.employee_age = employee_age;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
