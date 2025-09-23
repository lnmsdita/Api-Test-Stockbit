package com.testapisb;


import com.testapisb.model.ApiResponse;
import com.testapisb.model.Company;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



/**
 * Unit test for simple App.
 */
public class Client 
{
    
    
    public ApiResponse<Company> getResponseCompanies(int quantity) {
        return RestAssured.given()
        .baseUri("https://fakerapi.it")
            .basePath("/api/v1")          // version 2
            .queryParam("_quantity", quantity)
            .queryParam("_locale", "en_US")
        .when()
            .get("/companies")
        .then()
            .statusCode(200)
                .extract()
                .as(new TypeRef<ApiResponse<Company>>() {});
    }

    public void getResponseToSchema(int quantity, String schemaPath) {
        RestAssured.given()
        .baseUri("https://fakerapi.it")
            .basePath("/api/v1")          // version 2
            .queryParam("_quantity", quantity)
            .queryParam("_locale", "en_US")
        .when()
            .get("/companies")
        .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath(schemaPath));
    }
}
