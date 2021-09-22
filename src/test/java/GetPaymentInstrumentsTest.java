import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetPaymentInstrumentsTest extends BaseTest {



    @Test
    public void getNonExistingId() throws IOException {


        String body = readJsonFile("getpaymentinstruments/nonExistingId.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/get")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void getExistingId() throws IOException {
        String body = readJsonFile("getpaymentinstruments/existingId.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/get")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/getPaymentInstrumentsResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void getStringOfHundred() throws IOException {
        String body = readJsonFile("getpaymentinstruments/stringOfHundred.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/get")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertEquals(response.jsonPath().getString("error.code"),"VALIDATION_FAILED");
        softAssert.assertAll();

    }

    @Test
    @Description("Get payment instruments empty ID")
    public void emptyString() throws IOException {

        String body = readJsonFile("getpaymentinstruments/emptyString.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/get")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertEquals(response.jsonPath().getString("error.code"),"VALIDATION_FAILED");
        softAssert.assertAll();
    }
}
