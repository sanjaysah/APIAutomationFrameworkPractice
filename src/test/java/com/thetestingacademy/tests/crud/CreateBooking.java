package com.thetestingacademy.tests.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.module.PayloadManager;
import com.thetestingacademy.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class CreateBooking extends BaseTest {

    @Owner("Sanjay Kumar")
    @Description("Verify that Create Booking is working fine")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"P0","Sanity"})
    public void testCreateBooking() throws JsonProcessingException {
        requestSpecification.baseUri(APIConstants.CREATE_UPDATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                //.header("Content-Type","application/json")
                .when().body(payloadManager.createPayload()).post();

        vresponse = response.then().log().all();
        vresponse.statusCode(200);

        jsonpath = JsonPath.from(response.asString());
        System.out.println(jsonpath.getString("bookindid"));

    }
}
