package com.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class postDmeo {
  @Test
  public void f() 
  
{    String payload = """
		  {
		  "title": "My First Post",
		  "body": "This is a REST Assured POST request",
		  "userId": 1
		}
		""";
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post("https://jsonplaceholder.typicode.com/posts/1");

	 System.out.println(response.getStatusCode());
	  
  }
}
