package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class delete {
	@Test
	public void deletePost() {
		Response res = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1");
		res.prettyPrint();
	    Response rest = RestAssured.given().when().delete("https://jsonplaceholder.typicode.com/posts/1");
	    
	    rest.prettyPrint();
	}
}