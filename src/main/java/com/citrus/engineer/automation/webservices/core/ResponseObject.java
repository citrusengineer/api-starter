package com.citrus.engineer.automation.webservices.core;

import io.restassured.response.Response;

public class ResponseObject {

    private Response response;

    public Response response(){
        return response;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public static <T extends ResponseObject> T as (Class<T> type, Response response){
        response.prettyPrint();
        T obj = response.as(type);
        obj.setResponse(response);
        return obj;
    }
}
