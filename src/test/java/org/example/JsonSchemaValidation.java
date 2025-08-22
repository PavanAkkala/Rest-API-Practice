package org.example;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation() {

        given()

                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));


    }
}
