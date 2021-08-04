package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ExampleResourceTest {

    @Test
    void testHelloEndpoint() {
        String result = given()
          .when().get("/hello")
          .then().extract().asString();

        Approvals.verifyJson(result);
    }

    @Test
    void testHelloObjectEndpoint() {
        String result = given()
                .when().get("/hello/object")
                .then().extract().asString();

        Approvals.verify(result);
    }

    @Test
    void testHelloObjectAndStatusEndpoint() {
        Response response = given()
                .when().get("/hello/object");

        Approvals.verifyAll("", Arrays.asList(response.getStatusCode(), response.getBody().asString()));
    }

}