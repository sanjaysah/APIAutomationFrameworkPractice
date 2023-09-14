package com.thetestingacademy.tests.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.module.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    //Reusability
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse vresponse;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonpath;

    @BeforeMethod
    public void setupConfig(){
        //Base URI, Headers
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = (RequestSpecification) new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json").build().log().all();
//        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
//                .contentType("application/json").log().all();
    }

    public String getToken() throws JsonProcessingException {
        //payloadManager = new PayloadManager();
//        String payload = "{\n" +
//                "    \"username\" : \"admin\",\n" +
//                "    \"password\" : \"password123\"\n" +
//                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.CREATE_TOKEN_AUTH_URL);
       // requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadManager.createAuth());

        response = requestSpecification.when().post();
        //String token = response.then().extract().path("token");
        jsonpath = JsonPath.from(response.asString());
        String token = jsonpath.getString("token");
        return token;
    }

    @AfterMethod
    public void tearDownConfig(){
        System.out.println("END!!");
    }
}
