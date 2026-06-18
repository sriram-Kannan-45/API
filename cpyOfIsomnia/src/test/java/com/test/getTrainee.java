package com.test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getTrainee {

    @Test
    public void f() {

        baseURI = "http://localhost:3000";

        Response res = given()
                .when()
                .get("/trainees");

        res.prettyPrint();

        Assert.assertEquals(res.getStatusCode(), 200);
    }
}
