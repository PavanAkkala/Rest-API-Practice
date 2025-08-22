package org.example;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {

    @Test
    public void createUser(ITestContext context) {

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",faker.name());
        jsonObject.put("gender","male");
        jsonObject.put("email",faker.internet().emailAddress());
        jsonObject.put("status","inactive");

       int id =  given()
               // .queryParam("x-api-key","reqres-free-v1")
               .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post("https://reqres.in/api/users")
               .jsonPath().getInt("id");

        System.out.println(id);

        context.setAttribute("user_id",id);







    }
}
