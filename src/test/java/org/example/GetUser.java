package org.example;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetUser {

    @Test
    public void GetUpdatedUser(ITestContext context) {

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",faker.name());
        jsonObject.put("gender","female");
        jsonObject.put("email",faker.internet().emailAddress());
        jsonObject.put("status","active");

        int id = (int) context.getAttribute("user_id");

        given()
                .header("x-api-key","reqres-free-v1")
               // .queryParam("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .pathParam("id",id)
                .body(jsonObject.toString())
                .when()
                .put("https://reqres.in/api/users/{id}")
                .then()
                .statusCode(200)
                .log().all();



    }
}
