package com.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


@Test
public class putDemo {
  public void f() {
	  
	  String payload = {
              "id": 1,
              "title": "My first post",
              "body": "This is the body of my first post",
              "userId": 1
            }
	 
  }
}
