package com.test;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getAllCourse extends BaseTest {
  @Test
  public void getALLcourse() 
  
  
  {
		AdminLogin login = new AdminLogin();
		login.validLogin();
		
		baseURI = baseURL;

		Response res = given()
                .header("Authorization", "Bearer " + token)
        .when()
                .get("/courses-structure/getAll");

		res.then().statusCode(200).body("message[0].key", equalTo("success"));
  }
  
  @Test
  public void getAllcourseWithoutToken()
  {
	  AdminLogin login = new AdminLogin();
		login.validLogin();
		
		baseURI = baseURL;

		Response res = given().when()
              .get("/courses-structure/getAll");

		res.then().statusCode(401).body("message[0].key", equalTo("error"));
  }
}
