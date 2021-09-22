import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreatePaymentInstrumentsTest extends BaseTest {

    @Test
    public void mandatoryFieldsValidData() throws IOException {

        String body = readJsonFile("createpaymentinstrument/mandatoryFieldsValidData.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/createPaymentMandatoryFieldsResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void allFieldsValidData() throws IOException {

        String body = readJsonFile("createpaymentinstrument/allFieldsValidDetails.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/createPaymentAllFieldsResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void invalidCardNumber() throws IOException {

        String body = readJsonFile("createpaymentinstrument/invalidCardNumber.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void withoutType() throws IOException {

        String body = readJsonFile("createpaymentinstrument/withoutType.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void withInvalidType() throws IOException {

        String body = readJsonFile("createpaymentinstrument/withInvalidType.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void missingHolderName() throws IOException {

        String body = readJsonFile("createpaymentinstrument/missingHolderName.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void holderNameHyphen() throws IOException {

        String body = readJsonFile("createpaymentinstrument/holderNameHyphen.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }


    @Test
    public void holderNameHundredCharacters() throws IOException {

        String body = readJsonFile("createpaymentinstrument/holderNameHundredCharacters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();

    }


    @Test
    public void countryCodeWithNumbers() throws IOException {

        String body = readJsonFile("createpaymentinstrument/countryCodeWithNumber.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void countryCodeWithOneLetter() throws IOException {

        String body = readJsonFile("createpaymentinstrument/countryCodeWithOneLetter.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void countryCodeWithThreeLetters() throws IOException {

        String body = readJsonFile("createpaymentinstrument/countryCodeWithThreeLetters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }


    @Test
    public void addressLineHundredCharacters() throws IOException {

        String body = readJsonFile("createpaymentinstrument/addressLineHundredCharacters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void postalCodeSpecialCharacters() throws IOException {

        String body = readJsonFile("createpaymentinstrument/postalCodeSpecialCharacters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/payment_instruments/create")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

@Test
    public void cardNumberWithSpaces() throws IOException {

    String body = readJsonFile("createpaymentinstrument/cardNUmberWithSpaces.json");

    Response response = RestAssured.given(requestSpecification)
            .filter(allureRestAssured)
            .header(authHeader)
            .contentType(ContentType.JSON)
            .body(body)
            .post("/payment_instruments/create")
            .then()
            .extract().response();

    int responseCode = response.getStatusCode();
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(responseCode, 200, "Response code should be 200");
    softAssert.assertAll();
}

}
