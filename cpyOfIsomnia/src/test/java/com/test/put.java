package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class put {
  @Test
  public void f() 
  {
	          baseURI = "http://localhost:3000";
	          
	          String update = """
	          		 {
				      "name": "rams",
				      "email": "rama123@gmail.com",
				      "company": "waveinit2",
				      "id": "3"
	          		  }
	          		""";
	          Response res = given().contentType("application/json").body(update).when().put("/trainees/2");
	          
	          res.prettyPrint();
	          
	          Assert.assertEquals(res.getStatusCode(), 200);
	          
	          Assert.assertEquals(res.jsonPath().getString("name"), "rams");
	          
	          
	          
	          
  }
}
