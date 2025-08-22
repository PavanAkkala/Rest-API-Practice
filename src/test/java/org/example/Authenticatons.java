package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Authenticatons {

    @Test
    public void testBasicAuthentication() {

        Response response =
                given()
               .auth().basic("postman","password")
               .when()
               .get("https://postman-echo.com/basic-auth")
               .then()
               .statusCode(200)
               .body("authenticated",equalTo(true))
               .log().all()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("authenticated"));


    }

    @Test
    public void testDigestAuth() {

        Response res =

                     given()
                             .auth().digest("postman","password")
                             .when()
                             .get("https://postman-echo.com/basic-auth");
                        Assert.assertEquals(res.getStatusCode(),200);
                        Assert.assertTrue(res.jsonPath().getBoolean("authenticated"));


    }
}


