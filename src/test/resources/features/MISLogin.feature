Feature: Login MIS Application Activities

  Background: User verifies Login Page Elements Before Login
    Given User opens MIS Beta page "https://mymis.geminisolutions.com/"

#1
  Scenario Outline: User verifies elements of Login page
    Given User verifies logo and login page message
    Then User verifies element "<elementOne>"
    And User verifies element "<elementTwo>"
    Then User verifies element "<element Three>"

    Examples:
      |elementOne|elementTwo|element Three|
      |Forgot Password?|Login via SSO|Sign In|


#2
  Scenario Outline: User Clicks on Sign In without entering Credentials
     Given User clicks on sign in
     Then User verifies element "<Enter Credentials Alert Message>"
     And User verifies element "<Password Alert Message>"
     And User verifies element "<Username Alert Message>"

    Examples:
      | Enter Credentials Alert Message | Password Alert Message| Username Alert Message |
      |Enter your username and password.|Password is required.|Username is required.|


#3
  Scenario Outline: User Enters only username and Clicks on Sign In
     Given User enters Username as "<username>"
     Then User clicks on sign in
     And User verifies element "<Password Alert Message>"

     Examples:
       | username |Password Alert Message|
       |charu.srivastava|Password is required.|

#4
  Scenario Outline: User Enter only password and Clicks on Sign In
      Given User enters Password as "<password>"
      Then User clicks on sign in
      And User verifies element "<Username Alert Message>"

      Examples:
        |password|Username Alert Message|
        |Gemini@1234|Username is required.|


#5
  Scenario Outline: User Enters Invalid Credentials
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    Then User clicks on sign in
    And User verifies element "<Invalid Credentials>"

    Examples:
      | username | password | Invalid Credentials|
      |Charu     |Gemini    |The username or password you entered is not valid. Please try again.|


#6

  Scenario Outline: User Login to the Application via SSO
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    Then User clicks on Login via SSO
    And User verifies new Window of Microsoft Login

    Examples:
      |username  |password|
      |charu.srivastava|Gemini@1234|

#7

  Scenario Outline: User Login to the Application
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    Then User clicks on sign in
    And User Verifies Landing Page

    Examples:
      |username  |password|
      |charu.srivastava|Gemini@1234|


#8

  Scenario Outline: User clicks on Forget Password
    Given User enters Username as "<username>"
    And User Clicks on Forgot password
    Then User is navigated to Reset Password page
    And User clicks on Reset Password
    And User verifies Success message "<Success message>"
    Then User closes the Popup by clicking Ok "<Button>" and again verifies Reset Password Page

    Examples:
      | username |Success message|Button|
      |charu.srivastava|Password reset link sent to your official email. Kindly visit to change.|OK|


#9

  Scenario Outline: User Clicks on Reset linking without giving username
    Given User Clicks on Forgot password
    Then User is navigated to Reset Password page
    And User clicks on Reset Password
    Then User verifies element "<Alert message One>"
    And User verifies element "<Alert message Two>"
    Examples:
      | Alert message One | Alert message Two|
      |Enter your username.|Username is required.|


#10

 Scenario Outline: User clicks on forgot password and enters invalid username.
    Given User Clicks on Forgot password
    Then User is navigated to Reset Password page
    Then User enters Username as "<username>"
    And User clicks on Reset Password
   Then User verifies element "<Authorization Alert message>"

   Examples:
     | username |Authorization Alert message|
      |Charu|You are not authorised to perform the action|


#11
  Scenario Outline: User navigate back to sign In Page
    Given User Clicks on Forgot password
    Then User is navigated to Reset Password page
    And User clicks on sign in button
    Then User verifies element "<element>"
    Examples:
      | element |
    |Forgot Password?|