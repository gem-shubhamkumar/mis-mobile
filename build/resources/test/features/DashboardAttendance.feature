Feature: Perform actions on Dashboard of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@123"

  Scenario: Select a month and verify
    Then Open "Dashboard" page
    And Verify "Dashboard" page of type "Main"
    And Open attendance of "July 2022"
    Then Logout from MIS
