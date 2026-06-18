package com.test;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNote extends BaseTest {

    @Test
    public void createNote() {

        
        AdminLogin login = new AdminLogin();
        login.validLogin();

        baseURI = baseURL;

        Map<String, Object> body = new HashMap<>();

        body.put("title", "demoTestNote");
        body.put("content", "Created by sriram");
        body.put("tags", Arrays.asList("qa", "demo"));
        body.put("color", "#ffeb3b");
        body.put("isPinned", false);

        Response res =
                given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(body)
                .when()
                    .post("/create/notes");

        res.prettyPrint();

        res.then()
                .statusCode(201);
    }
}