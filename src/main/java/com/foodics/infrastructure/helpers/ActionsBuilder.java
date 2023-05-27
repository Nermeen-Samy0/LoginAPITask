package com.foodics.infrastructure.helpers;

import com.foodics.domain.enums.RequestTypes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ActionsBuilder {

    public static Response sendRequest(RequestTypes requestType, String request, RequestSpecification specs) {
        switch (requestType) {
            case POST:
                return given().spec(specs).when().post(request).andReturn();
            case PUT:
                return given().spec(specs).when().put(request).andReturn();
            case GET:
                return given().spec(specs).when().get(request).andReturn();
            case DELETE:
                return given().spec(specs).when().delete(request).andReturn();
            default:
                break;
        }
        return null;
    }

    private static RequestSpecBuilder initializeBuilder(String baseUri) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUri).setContentType(ContentType.JSON);
        return builder;
    }

    public static RequestSpecification prepareRequestSpecs(String baseUri, Map<String, String> queryParam, String body, Map<String, String> header) {
        RequestSpecBuilder builder = initializeBuilder(baseUri);
        if (queryParam != null)
            builder.addQueryParams(queryParam);
        if (body != null)
            builder.setBody(body);
        if(header != null)
            builder.addHeaders(header);
        return builder.build();
    }
}