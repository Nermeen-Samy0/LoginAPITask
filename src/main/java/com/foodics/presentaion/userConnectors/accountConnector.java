package com.foodics.presentaion.userConnectors;

import com.foodics.domain.dtos.UserDTO;
import com.foodics.domain.enums.RequestTypes;
import com.foodics.infrastructure.configurations.BaseConfiguration;
import com.foodics.infrastructure.helpers.ActionsBuilder;
import com.foodics.infrastructure.helpers.Mapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class accountConnector {

    private BaseConfiguration baseConfObj;
    private String baseURL;
    private String serviceName;
    private UserDTO user;
    private Mapper mapperObj;
    private String json;
    private ActionsBuilder actionBuilderObj;

    public accountConnector() {
        baseConfObj = new BaseConfiguration();
        user = new UserDTO();
        mapperObj = new Mapper();
    }

    public String getBaseUrl() {
        baseURL = baseConfObj.getEnvironmentURL();
        return baseURL;
    }

    public void setLoginServiceNameWithTheBodyRequest(String userEmail, String userPassword) {
        serviceName = "/cp_internal/login";
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
        json = mapperObj.mapObjectToJson(user);
    }

    public int login() {
        RequestSpecification spec = actionBuilderObj.prepareRequestSpecs(baseURL, null, json, null);
        Response response = actionBuilderObj.sendRequest(RequestTypes.POST, serviceName, spec);
        JsonPath jsonPath = new JsonPath(response.body().asString()).setRoot("Data");
        return response.statusCode();
    }
}