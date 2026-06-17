package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class getTrainee {
  @Test
  public void f() 
  
  {
	  
	baseURI = "http://localhost:3000";
	
	Response res = when().patch("/trainees");
	
	res.prettyPrint();
	
	Assert.assertEquals(res.getStatusCode(), 200);
	
	
  }
}
