package org.example;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Headers {

    @Test
    public void headers() {

        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .header("Server", "gws");
    }

    @Test
    public void eaderMul() {

      Response res = given()

                .when()
                .get("https://www.google.com/");

            // To print only headers
            String red = res.getHeader("Content-Type");
            System.out.println(red);

        // io.restassured.http.Headers myHeaders = res.getHeaders();
        //To print header and values of all
         io.restassured.http.Headers myHeaders = res.getHeaders();

         for(Header hd: myHeaders) {

             System.out.println(hd.getName()+" "+hd.getValue());
         }



    }
}
