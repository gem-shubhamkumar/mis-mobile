Feature: Login MIS Application Activities

  Background: User verifies Login Page Elements Before Login
    Given User opens MIS Beta page
    And User Verifies all elements of Login Page

  Scenario: User Login to the Application
    Given User enters Username as "charu.srivastava"
    And User enters Password as "Gemini@1234"
    Then User Login clicks on sign in