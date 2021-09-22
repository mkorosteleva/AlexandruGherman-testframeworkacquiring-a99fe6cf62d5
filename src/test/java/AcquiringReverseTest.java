import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AcquiringReverseTest extends BaseTest {
//Tests ignored since reverse functionality is automated

    @Test
    @Ignore
    public void validMandatoryFields() throws IOException {

        String body = readJsonFile("acquiringreverse/validMandatoryFields.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/reverse")
                .then()
                .extract().response();
        response.print();
        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 200, "Response code should be 200");
        softAssert.assertAll();
    }

    @Test
    @Ignore
    public void emptyMandatoryFields() throws IOException {

        String body = readJsonFile("acquiringreverse/emptyMandatoryFields.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/reverse")
                .then()
                .extract().response();
        response.print();
        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }

    @Test
    @Ignore
    public void amountIsNull() throws IOException {

        String body = readJsonFile("acquiringreverse/amountIsNull.json");

        Response response = RestAssured.given(requestSpecification)
                .filter(allureRestAssured)
                .header(authHeader)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/acquiring/reverse")
                .then()
                .extract().response();
        response.print();
        int responseCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseCode, 400, "Response code should be 400");
        softAssert.assertAll();
    }
}
