import org.example.Pojo_postRequest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class DifferentWaysOfCreatingPostReq {

    @Test
    public void postDIff() {


        HashMap<String,String> newMaps = new HashMap<>();
        newMaps.put("name","madss");
        newMaps.put("email","seenn@gmail.com");
        newMaps.put("gender","male");
        newMaps.put("status","active");

        given()
                .header("Authorization","Bearer ae162694e9f2bf259805a03f9c9d47a42f9b5a58f14415e02b4c8f4335c41ffc")
                .contentType("application/json")
                .body(newMaps)


                .when()
                  .post("https://gorest.co.in/public/v2/users")
                .then()
                 .statusCode(201)
                .body("name",equalTo("madss"))
                .body("email",equalTo("seenn@gmail.com"))
                .body("gender",equalTo("male"))
                .body("status",equalTo("active"))
                .header("content-type",
                        "application/json; charset=utf-8")
                .log().all();








    }

 @Test
    public void pojo() {

        Pojo_postRequest pojoPostRequest = new Pojo_postRequest();
        pojoPostRequest.setName("man");
        pojoPostRequest.setEmail("redd@gmail.com");
      //  pojoPostRequest.setEmail("man@mas.com");
        pojoPostRequest.setGender("female");
        pojoPostRequest.setStatus("inactive");

        given()
                .header("Authorization","Bearer ae162694e9f2bf259805a03f9c9d47a42f9b5a58f14415e02b4c8f4335c41ffc")
                .contentType("application/json")
                .body(pojoPostRequest)

                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("man"))
                .body("email",equalTo("redd@gmail.com"))
                .body("gender",equalTo("female"))
                .body("status",equalTo("inactive"))
                .header("content-type",
                        "application/json; charset=utf-8")
                .log().all();
    }

    @Test
    public void jsonExternal() throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir") + "/body.json");
        FileReader fi = new FileReader(file);
        JSONTokener jt = new JSONTokener(fi);
        JSONObject data = new JSONObject(jt);


        given()
                .header("Authorization","Bearer ae162694e9f2bf259805a03f9c9d47a42f9b5a58f14415e02b4c8f4335c41ffc")
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("maddu"))
                .body("email",equalTo("maddu@mail.com"))
                .body("gender",equalTo("male"))
                .body("status",equalTo("active"))
                .header("content-type",
                        "application/json; charset=utf-8")
                .log().all();
    }


    }


