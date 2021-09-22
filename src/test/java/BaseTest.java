import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    Header authHeader = new Header("Authorization", "Bearer sk_test_zhK2tbTw9rsuyG3jKm7dpW5bPkrNF1ne");
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://api.sandbox.prysym.com/v1").build();
    AllureRestAssured allureRestAssured = new AllureRestAssured().setRequestTemplate("http-request.ftl");


    public String readJsonFile(String filename) throws IOException {
        byte[] bytesFromJson = Files.readAllBytes(Paths.get("src/test/resources/testdata/"+filename));
        return new String(bytesFromJson);
    }

}
