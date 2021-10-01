package com.citrus.engineer.automation.webservices.core;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public interface Api {

    String getDomain();

    default RequestSpecification init(){
        return RestAssured.given().baseUri(getDomain()).contentType("application/json").log().all();
    }
}
