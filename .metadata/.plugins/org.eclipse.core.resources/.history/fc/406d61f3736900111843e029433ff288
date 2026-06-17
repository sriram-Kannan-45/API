package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class patch {
  @Test
  public void f() 
  
  {
	baseURI = "http://localhost:3000";
	String update="""
         {
          "name": "tioo"}""";
	
	Response res = given().contentType(ContentType.JSON).body(update).when().patch("/trainees/2");
	
	res.prettyPrint();
	
	Assert.assertEquals(res.getStatusCode(), 200);
	
	Assert.assertEquals(res.jsonPath().getString("name"), "tioo");
  }
}
