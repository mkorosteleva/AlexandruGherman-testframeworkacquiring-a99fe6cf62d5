import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AcquiringVoidTest extends BaseTest{

    @Test
    public void validMandatoryFields() throws IOException {

        String body = readJsonFile("acquiringvoid/validMandatoryFields.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/void")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/acquiringVoidMandatoryFieldsResponseValidation.json"))
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void emptyMandatoryFields() throws IOException {

        String body = readJsonFile("acquiringvoid/emptyMandatoryFields.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/void")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void typeIsNull() throws IOException {

        String body = readJsonFile("acquiringvoid/typeIsNull.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/void")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void programIdHundredCharacters() throws IOException {

        String body = readJsonFile("acquiringvoid/programIdHundredCharacters.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/void")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }
}
