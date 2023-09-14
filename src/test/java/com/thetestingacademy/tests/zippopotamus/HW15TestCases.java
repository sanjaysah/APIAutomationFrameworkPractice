package com.thetestingacademy.tests.zippopotamus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.module.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW15TestCases {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse vresponse;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonpath;
    public String countryCode;
    public String pincode;

    @BeforeMethod
    public void setupConfig(){
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.ZIPPOPOTAMUS_BASE_URL).contentType(ContentType.JSON);

    }

    @Test(priority=1,groups = {"hw1"})
    public void test1() throws JsonProcessingException {
        requestSpecification.basePath("/IN/110001");
        response = requestSpecification.when().get();
        vresponse = response.then().log().all();
        vresponse.statusCode(200);
        jsonpath = JsonPath.from(response.asString());
        pincode = jsonpath.getString("$.post code");
        System.out.println(pincode);
        response.equals(payloadManager.createZippoPayload());
    }
/*
    @Test(priority=2,groups = {"hw1"})
    public void test2(){

    }

    @Test(priority=3,groups = {"hw1"})
    public void test3(){

    }

    @Test(priority=4,groups = {"hw1"})
    public void test4(){

    }

    @Test(priority=5,groups = {"hw1"})
    public void test5(){

    }

    @Test(priority=6,groups = {"hw1"})
    public void test6(){

    }

    @Test(priority=7,groups = {"hw1"})
    public void test7(){

    }


    @Test(priority=8,groups = {"hw1"})
    public void test8(){

    }

    @Test(priority=9,groups = {"hw1"})
    public void test9(){

    }

    @Test(priority=10,groups = {"hw1"})
    public void test10(){

    }

    @Test(priority=11,groups = {"hw1"})
    public void test11(){

    }


    @Test(priority=12,groups = {"hw1"})
    public void test12(){

    }


    @Test(priority=13,groups = {"hw1"})
    public void test13(){

    }

    @Test(priority=14,groups = {"hw1"})
    public void test14(){

    }

    @Test(priority=15,groups = {"hw1"})
    public void test15(){

    }
*/
    @AfterMethod
    public void tearDown(){
        System.out.println("End!!");
    }
}
