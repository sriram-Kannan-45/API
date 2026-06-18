package com.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
public class getAllRole extends BaseTest {

    @Test
    public void allRoles() {

        
        AdminLogin login = new AdminLogin();
        login.validLogin();

        baseURI = baseURL;

        Response res = given()
                .header("Authorization", "Bearer " + token)
        .when()
                .get("/roles/getAll");

        

        res.then().statusCode(200).body("message[0].key", equalTo("success"));
    }
    
    @Test
	public void allRolesWithoutToken() {

		baseURI = baseURL;

		Response res = given().when().get("/roles/getAll");

		res.then().statusCode(401).body("message[0].key", equalTo("error"));
	}
}