package com.ecommerce.automation.tests.API;
import com.ecommerce.automation.utils.ConfigReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class APITest {

    @Test
    public void getUserTest() {

        Response response = given()
                .baseUri(ConfigReader.getProperty("api.url"))
                .when()
                .get("/students");
        System.out.println("Status Code: " + response.getStatusCode());
    }
}