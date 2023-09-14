package com.thetestingacademy.actions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {
    public void verifyStatusCode(Response response){
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"),true,
                "Value of Status Code is: "+response.getStatusCode());
    }

    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }
}
