package com.foodics.steps;

import com.foodics.presentaion.userConnectors.accountConnector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.testng.Assert;

public class UserLoginSteps {

    public accountConnector account;
    public UserLoginSteps() {
        account = new accountConnector();
    }

    @Given("Post Login API")
    public void post_login_api() {
        RestAssured.baseURI  =   account.getBaseUrl();
    }

    @When("Provide Valid Credential {string}{string}")
    public void provide_valid_credential(String email, String password) {
        account.setLoginServiceNameWithTheBodyRequest(email, password);
    }

    @Then("Status_code equals {int}")
    public void statuscode_equals_(int StatusCode) {
        System.out.println(StatusCode);
        Assert.assertEquals(StatusCode, account.login());
    }

    @When("Provide different combinations to {string}{string}")
    public void provide_different_combinations_to(String email, String password) {
        account.setLoginServiceNameWithTheBodyRequest(email, password);
    }
}

