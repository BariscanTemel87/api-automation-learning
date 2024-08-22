package com.api.test.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PetStoreSteps {

    private Response response;

    @Given("I have the PetStore API endpoint")
    public void i_have_the_petStore_api_endpoint() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("I send a GET request to the pet endpoint with ID {int}")
    public void i_send_a_get_request_to_the_pet_endpoint_with_id(Integer petId) {
        response = RestAssured
                .given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}");
    }

    @Then("I should receive a status code of {int}")
    public void i_should_receive_a_status_code_of(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain the pet ID {int}")
    public void the_response_should_contain_the_pet_id(int petId) {
        response.then().body("id", equalTo(petId));
    }

    @Then("the response should contain a pet status {string}")
    public void the_response_should_contain_a_pet_status(String status) {
        response.then().body("status", equalTo(status));
    }
}
