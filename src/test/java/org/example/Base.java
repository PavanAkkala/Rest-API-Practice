package org.example;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Base {

    int id;

    @Test(priority = 1)
    public void getAPI() {

        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all(); // To print the response in the console

    }
    @Test(priority = 2)
    public void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "reddy");
        data.put("job", "QA Faang");

      id = given()// returing the response i.e id
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//                .then()
//                .statusCode(201)
//                .log().all();
    }
    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {

        HashMap<String,String> newMap = new HashMap<>();
        newMap.put("name", "naidu");
        newMap.put("job", "QA Faang");

        given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(newMap)

                .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();


    }
    @Test(priority = 4)
    public void deleteUser() {

        given()
                .header("x-api-key","reqres-free-v1")

                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();
    }
}
