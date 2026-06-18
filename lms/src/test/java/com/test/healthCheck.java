package com.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class healthCheck extends BaseTest  {

    @Test
    public void Check() {

        baseURI = baseURL;

        Response res = given()
                .when()
                .get("/");

        res.prettyPrint();

        res.then()
            .statusCode(200);
    }
}