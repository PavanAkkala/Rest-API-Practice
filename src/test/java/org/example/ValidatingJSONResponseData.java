package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ValidatingJSONResponseData {

    private static final Logger log = LoggerFactory.getLogger(ValidatingJSONResponseData.class);

    @Test
    public void Json() {

        given()
                .contentType("application/json")

                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .header("content-type","application/json; charset=utf-8")
                .body("[3].email",equalTo("goswamee_deshpande@homenick.test"))
                .log().body();




    }

    @Test
    public void usingVaraibleAndAssertion() {

        Response res = given()
                .contentType("application/json")
                .when()
                .get("https://gorest.co.in/public/v2/users");
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getContentType(),
                "application/json; charset=utf-8");
        String email = res.jsonPath().get("[2].name").toString(); //this will in the form of object we need to covert object to string
        Assert.assertEquals(email,"Dr. Brahmabrata Ganaka");


    }

    @Test
    public void getAllByLoop() {

        Response res =
                given()
                .when()
                .get("https://gorest.co.in/public/v2/users"); // Example URL

        // Extract list of names
        List<String> names = res.jsonPath().getList("name");

        // Print all names
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
   @Test
   public void testJsonResponseBodyData() {
        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("https://reqres.in/api/users?page=2");

        // Convert JSON response string to JSONObject
        JSONObject jo = new JSONObject(res.asString()); //coverting from response to string format then pass it to json

        // Iterate through the "book" array and print titles
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String bookTitle = jo.getJSONArray("data").getJSONObject(i).get("avatar").toString();
            System.out.println(bookTitle);
        }
    }

    @Test
    public void testGetParticularBook() {

        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("https://reqres.in/api/users?page=2");

        // Convert JSON response string to JSONObject
        JSONObject jo = new JSONObject(res.asString()); //coverting from response to string format then pass it to json

        boolean status = false;

        for(int i=0; i<jo.getJSONArray("data").length();i++) {

            String title = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
            System.out.println("Name found: " + title);
            if(title.equals("george.edwards@reqres.in")) {

                status = true;
                break;
            }
        }

        Assert.assertTrue(status);
    }
}
