package com.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilAndData.excelReader;

import io.restassured.response.Response;

public class getAllNotes extends BaseTest {

    @Test
    public void validWithoutPara() {

        AdminLogin login = new AdminLogin();
        login.validLogin();

        baseURI = baseURL;

        Response res = given()
                .header("Authorization", "Bearer " + token)

        .when()
                .get("/getAll/notes");

        res.prettyPrint();

        res.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data.size()", greaterThan(0))
                .body("pagination.currentPage", equalTo(1))
                .body("pagination.totalNotes", greaterThan(0));
    }

    @Test(
            dataProvider = "getAllNotes",
            dataProviderClass = excelReader.class
    )
    public void getAllNotesWithAllParams(

            String page,
            String limit,
            String search,
            String tags,
            String isPinned,
            String sortBy,
            String sortOrder) {

        AdminLogin login = new AdminLogin();
        login.validLogin();

        baseURI = baseURL;

        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("page", Integer.parseInt(page));
        queryParams.put("limit", Integer.parseInt(limit));
        queryParams.put("search", search);
        queryParams.put("tags", tags);
        queryParams.put("isPinned", Boolean.parseBoolean(isPinned));
        queryParams.put("sortBy", sortBy);
        queryParams.put("sortOrder", sortOrder);

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParams(queryParams)

        .when()
                .get("/getAll/notes");

        res.prettyPrint();

        int dataSize =
                res.jsonPath()
                        .getList("data")
                        .size();

        
        res.then()

                .statusCode(200)

                .body("success",
                        equalTo(true))

                .body("pagination.currentPage",
                        equalTo(Integer.parseInt(page)));

       
        if (dataSize > 0) {

            res.then()

                    .body("data[0]._id",
                            notNullValue())

                    .body("data[0].title",
                            not(isEmptyOrNullString()))

                    .body("data[0].createdAt",
                            notNullValue())

                    .body("data[0].updatedAt",
                            notNullValue())

                    .body("data[0].lastEdited",
                            notNullValue())

                    .body("data[0].color",
                            startsWith("#"))

                    .body("data[0].isPinned",
                            anyOf(
                                    equalTo(true),
                                    equalTo(false)));

            System.out.println(
                    "Records Found : "
                            + dataSize);
        }

        
        else {

            Assert.assertEquals(
                    dataSize,
                    0,
                    "No records found");

            System.out.println(
                    "No records found for : "
                            + search);
        }
    }
    
    @Test(
            dataProvider = "blankOptions",
            dataProviderClass = excelReader.class
    )
    public void getAllNotesWithBlankOptions(

            String page,
            String limit,
            String search,
            String tags,
            String isPinned,
            String sortBy,
            String sortOrder) {

        AdminLogin login = new AdminLogin();
        login.validLogin();

        baseURI = baseURL;

        Map<String, Object> queryParams =
                new HashMap<>();

        if (!page.isBlank())
            queryParams.put(
                    "page",
                    Integer.parseInt(page));

        if (!limit.isBlank())
            queryParams.put(
                    "limit",
                    Integer.parseInt(limit));

        if (!search.isBlank())
            queryParams.put(
                    "search",
                    search);

        if (!tags.isBlank())
            queryParams.put(
                    "tags",
                    tags);

        if (!isPinned.isBlank())
            queryParams.put(
                    "isPinned",
                    Boolean.parseBoolean(isPinned));

        if (!sortBy.isBlank())
            queryParams.put(
                    "sortBy",
                    sortBy);

        if (!sortOrder.isBlank())
            queryParams.put(
                    "sortOrder",
                    sortOrder);

        Response res =
                given()

                        .header(
                                "Authorization",
                                "Bearer " + token)

                        .queryParams(queryParams)

                .when()

                        .get("/getAll/notes");

//        res.prettyPrint();

        int dataSize =
                res.jsonPath()
                        .getList("data")
                        .size();

        
        res.then()

                .statusCode(200)

                .body(
                        "success",
                        equalTo(true));

        
        if (dataSize > 0) {

            res.then()

                    .body(
                            "data[0]._id",
                            notNullValue())

                    .body(
                            "data[0].title",
                            not(
                                    isEmptyOrNullString()))

                    .body(
                            "data[0].createdAt",
                            notNullValue())

                    .body(
                            "data[0].updatedAt",
                            notNullValue())

                    .body(
                            "data[0].lastEdited",
                            notNullValue())

                    .body(
                            "data[0].color",
                            startsWith("#"));

            System.out.println(
                    "Records Found : "
                            + dataSize);
        }

        
        else {

            Assert.assertEquals(
                    dataSize,
                    0);

            System.out.println(
                    "No Records Found");
        }
    }
}