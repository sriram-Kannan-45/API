package com.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AdminLogin extends BaseTest {

    

    @Test
    public void validLogin() {

        baseURI = baseURL;

        Map<String, String> map = new HashMap<>();

        map.put("email", "sam@gmail.com");
        map.put("password", "123");

        Response res = given()
                .contentType(ContentType.JSON)
                .body(map)
        .when()
                .post("/user/login");

        token = res.jsonPath().getString("token");

        res.then()
            .statusCode(201)  
            .body("user.email", equalTo("sam@gmail.com"));
    }
    
    
    @Test(dataProvider = "invalidEmail", dataProviderClass = com.utilAndData.excelReader.class)
    public void invalEmail(String email, String password) 
    {
		baseURI = baseURL;

		Map<String, String> map = new HashMap<>();

		map.put("email", email);
		map.put("password", password);

		Response res = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/user/login");

		res.then().statusCode(400).body("message[0].key", equalTo("error"));
    }
    
    @Test(dataProvider = "invalidPassword", dataProviderClass = com.utilAndData.excelReader.class)
    public void invalPassword(String email, String password) 
    {
    	baseURI = baseURL;
    	
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("email", email);
    	map.put("password", password);
    	
		Response res = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/user/login");
		
		res.then()
			.statusCode(400)
			.body("message[0].key", equalTo("error"));
		
    }
    
    @Test(dataProvider = "withoutdata", dataProviderClass = com.utilAndData.excelReader.class)
    
    public void withoutdata(String email, String password) 
    {
    	baseURI = baseURL;
    	
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("email", email);
    	map.put("password", password);
    	
        Response res = given()
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("/user/login");
        
        res.then().statusCode(400).body("message[0].key", equalTo("error"));
    }
}