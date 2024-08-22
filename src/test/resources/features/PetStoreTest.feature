Feature: PetStore API Test

  Scenario: Get Pet by ID
    Given I have the PetStore API endpoint
    When I send a GET request to the pet endpoint with ID 1
    Then I should receive a status code of 200
    And the response should contain the pet ID 1
    And the response should contain a pet status "sold"
