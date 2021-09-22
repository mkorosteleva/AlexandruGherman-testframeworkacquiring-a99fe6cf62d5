import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AcquiringProcessTest extends BaseTest {

    @Test
    public void mandatoryFieldsValidData() throws IOException {

        String body = readJsonFile("acquiringprocess/mandatoryFieldsValidData.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/acquiringProcessResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void missingProgramId() throws IOException {

        String body = readJsonFile("acquiringprocess/missingProgramId.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();

    }


    @Test
    public void amountIsNull() throws IOException {

        String body = readJsonFile("acquiringprocess/amountIsNull.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void amountIsInteger() throws IOException {

        String body = readJsonFile("acquiringprocess/amountIsInteger.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void currencyCodeLowerCase() throws IOException {

        String body = readJsonFile("acquiringprocess/currencyCodeIsLowerCase.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/acquiringProcessResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void currencyCodeFourCharacters() throws IOException {

        String body = readJsonFile("acquiringprocess/currencyCodeFourCharacters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void amountIsZero() throws IOException {

        String body = readJsonFile("acquiringprocess/amountIsZero.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void transactionTypeIsInvalid() throws IOException {

        String body = readJsonFile("acquiringprocess/transactionTypeInvalid.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();

    }

    @Test
    public void referenceNumberOverStringLimit() throws IOException {

        String body = readJsonFile("acquiringprocess/referenceNumberOverStringLimit.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void expirationDateInvalidFormat() throws IOException {

        String body = readJsonFile("acquiringprocess/expirationDateInvalidFormat.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void withoutPaymentInstrument() throws IOException {

        String body = readJsonFile("acquiringprocess/withoutPaymentInstrument.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void withStoredPaymentAndPaymentInstrument() throws IOException {

        String body = readJsonFile("acquiringprocess/withStoredPaymentAndPaymentInstrument.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void validStoredInstrumentId() throws IOException {

        String body = readJsonFile("acquiringprocess/validStoredInstrumentId.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void invalidStoredInstrument() throws IOException {

        String body = readJsonFile("acquiringprocess/invalidStoredInstrumentId.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/process")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }
}
