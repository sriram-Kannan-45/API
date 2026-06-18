package com.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
public class getAllInstitutions extends BaseTest {
  @Test
  public void getALl() 
  {
	  baseURI = baseURL;
	  
		Response res = given().when().get("/getAll/institution");
		
		
		res.then().statusCode(200).body("message[0].key", equalTo("success"));
	  
  }
}
