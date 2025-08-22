package org.example;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Cookie {

    @Test
    public void cook() {

       Response res = given()
                .when()
                .get("https://www.google.com/");
                // To get single cookie i.e value
                String ro = res.getCookie("AEC");
                System.out.println(ro);
                //To get only keys of cookies
                Map<String,String> cookies = res.getCookies();
             //   System.out.println(cookies.keySet());

                //To get key and value of cookies
                for(String k: cookies.keySet()) {

                    String cookie = res.getCookie(k);
                    System.out.println(cookie);
                }


    }
}
