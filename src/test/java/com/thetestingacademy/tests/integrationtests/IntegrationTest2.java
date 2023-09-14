package com.thetestingacademy.tests.integrationtests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.module.PayloadManager;
import com.thetestingacademy.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest2 { //extends BaseTest

    String token;
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse vresponse;
    public AssertActions assertActions = new AssertActions();
    public PayloadManager payloadManager = new PayloadManager();;
    public JsonPath jsonpath;

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

    @Test(groups = {"integration"})
    @Owner("Sanjay Kumar | The Testing Academy")
    @Description("Verify the booking is created or not")
    public void testCreateBooking(ITestContext context) throws JsonProcessingException {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification).when()
                .body(payloadManager.createPayload()).post();
        //System.out.println(response.asString());
        vresponse = response.then().log().all();
        vresponse.statusCode(200);

        jsonpath = JsonPath.from(response.asString());
        String booking_id = jsonpath.getString("bookingid");
        //System.out.println("Booking Id: "+booking_id);
        context.setAttribute("bookingid",booking_id);
        assertThat(booking_id).isNotNull().isNotBlank();

    }

    @Test(groups = {"integration"}, dependsOnMethods = "testCreateBooking")
    @Owner("Sanjay Kumar | The Testing Academy")
    @Description("Verify update of previously created Booking is working Correctly")
    public void testUpdateBooking(ITestContext context) throws JsonProcessingException {
        token = getToken();
        String bookingid = (String) context.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+bookingid);
        response = RestAssured.given().spec(requestSpecification).cookie("token", token)
                .when().body(payloadManager.updatePayload()).put();
        vresponse = response.then().log().all();
        vresponse.statusCode(200);
        vresponse.body("firstname", Matchers.is("Darsh"));

//        jsonpath = JsonPath.from(response.asString());
//        System.out.println(jsonpath);
//        String first_name = jsonpath.getString("firstname");
//        System.out.println("First Name Updated: "+first_name);
//        //context.setAttribute("bookingid",booking_id);
//        assertThat(first_name).isNotNull().isNotBlank().isEqualTo("Darsh");
    }

    @Test(groups = {"integration"}, dependsOnMethods = "testUpdateBooking")
    @Owner("Sanjay Kumar | The Testing Academy")
    @Description("Verify previously created booking is deleted successfully")
    public void testDeleteBooking(ITestContext context){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+(String) context.getAttribute("bookingid"));
        vresponse = RestAssured.given().spec(requestSpecification).auth().preemptive().basic("admin","password123")
                .when().delete().then().log().all();
        vresponse.statusCode(201);

    }
}
