import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AcquiringCaptureTest extends BaseTest{

    @Test
    public void invalidData() throws IOException {

        String body = readJsonFile("acquiringcapture/invalidData.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/capture")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void validData() throws IOException {

        String body = readJsonFile("acquiringcapture/validData.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/capture")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("validationschemas/acquiringCaptureResponseValidation.json"))
                .extract().response();
        response.print();
        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    public void wrongType() throws IOException {

        String body = readJsonFile("acquiringcapture/wrongType.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/capture")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    public void invalidSchema() throws IOException {

        String body = readJsonFile("acquiringcapture/invalidSchema.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/capture")
                .then()
                .extract().response();

        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }
}
