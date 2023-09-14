package step.definitions;

import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.tests.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

public class GetListAllBookingStepDef extends BaseTest {

    @Given("Get the {string}")
    public void getThe(String basePath) {
        requestSpecification.given().baseUri(APIConstants.BASE_URL).basePath(basePath)
                .contentType(ContentType.JSON);
    }

    @When("I make a GET request")
    public void iMakeAGETRequest() {
        response = requestSpecification.when().get();
    }

    @Then("Response Code {string} should be verified")
    public void responseCodeShouldBeVerified(String responseCode) {
        vresponse = response.then().log().all();
        vresponse.statusCode(Integer.parseInt(responseCode));
        vresponse.body("token", Matchers.notNullValue());
        vresponse.body("token.length()",Matchers.is(15));

    }

}
