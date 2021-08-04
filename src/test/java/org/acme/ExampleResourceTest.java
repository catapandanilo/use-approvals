package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ExampleResourceTest {

    @Test
    @DisplayName("Should verify the json that return in the /hello endpoint")
    void testHelloEndpoint() {
        String result = given()
          .when().get("/hello")
          .then().extract().asString();

        Approvals.verifyJson(result);
    }

    @Test
    @DisplayName("Should verify the object that return in the /hello/object endpoint")
    void testHelloObjectEndpoint() {
        String result = given()
                .when().get("/hello/object")
                .then().extract().asString();

        Approvals.verify(result);
    }

    @Test
    @DisplayName("Should verify the status code and object that return in the /hello/object endpoint")
    void testHelloObjectAndStatusEndpoint() {
        Response response = given()
                .when().get("/hello/object");

        Approvals.verifyAll("", Arrays.asList(response.getStatusCode(), response.getBody().asString()));
    }

}