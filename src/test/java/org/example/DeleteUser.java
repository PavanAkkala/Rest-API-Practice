package org.example;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUser {

    @Test
    public void deleteUser(ITestContext context) {


        int id = (int) context.getAttribute("user_id");

         given()
                 .header("x-api-key","reqres-free-v1")
                 //.queryParam("x-api-key","reqres-free-v1")
                 .contentType("application/json")
                 .pathParam("id",id)
                 .when()
                 .delete("https://reqres.in/api/users/{id}")
                 .then()
                 .statusCode(204)
                 .log().all();


    }
}
