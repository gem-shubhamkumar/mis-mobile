Feature: Login MIS Application Activities

  Background: User verifies Login Page Elements Before Login
    Given User opens MIS Beta page "https://mymis.geminisolutions.com/"
    And User Verifies all elements of Login Page


  Scenario Outline: User Clicks on Sign In without entering Credentials
    Given User clicks on sign in
    Then User verifies error message for "<Enter Credentials Alert Message>"
     And  User verifies error message for "<Password Alert Message>"
     And User verifies error message for "<Username Alert Message>"

    Examples:
      | Enter Credentials Alert Message | Password Alert Message| Username Alert Message |
      |Enter your username and password.|Password is required.|Username is required.|

  Scenario Outline: User Enters only username and Clicks on Sign In
     Given User enters Username as "<username>"
     Then User clicks on sign in
     And User verifies error message for "<Password Alert Message>"
     Examples:
       | username |Password Alert Message|
       |charu.srivastava|Password is required.|

  Scenario Outline: User Enter only password and Clicks on Sign In
      Given User enters Password as "<password>"
      Then User clicks on sign in
      And User verifies error message for "<Username Alert Message>"
      Examples:
        |password|Username Alert Message|
        |Gemini@1234|Username is required.|


  Scenario Outline: User Enters Invalid Credentials
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    Then User clicks on sign in
    And User verifies error message for "<Invalid Credentials>"
    Examples:
      | username | password | Invalid Credentials|
      |charu     |Gemini    |The username or password you entered is not valid. Please try again.|


  Scenario Outline: User Login to the Application
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    Then User clicks on sign in
    And User Verifies Landing Page
    Examples:
      |username  |password|
      |charu.srivastava|Gemini@1234|



