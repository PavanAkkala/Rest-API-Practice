package org.example;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PathAndQueryParam {

    @Test
    public void pathAndQuery() {

        given()
                .pathParam("myName","users")
                .queryParam("page",2)
                .when()
                .get("https://reqres.in/api/{myName}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
