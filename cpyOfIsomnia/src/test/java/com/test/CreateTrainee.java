package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;
public class CreateTrainee {
	
  
  @Test
  public void f() 
  
  {
	  
	   baseURI = "http://localhost:3000";
	   
	   Map<String, String> traineePayload = new HashMap<>();
	   
	   traineePayload.put("name","raksha");
	   traineePayload.put("email","raksha@gmail.com");
	   traineePayload.put("company","wavene2");
	   
	   Response res = given().contentType("application/json").body(traineePayload).when().post("/trainees");
		
		Assert.assertEquals(res.getStatusCode(), 201);
		Assert.assertEquals(res.jsonPath().getString("name"), "raksha");
  }
}
