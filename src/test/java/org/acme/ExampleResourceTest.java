package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

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

}