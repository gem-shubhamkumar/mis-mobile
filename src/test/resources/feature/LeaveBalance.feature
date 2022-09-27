@MISAutomation
Feature: Leave Balance

  Background:
    Given Navigate to "myMIS"
    Then Enter credentials to "myMIS portal" using username as "priyanshu.prajapati" and password as "Gemini@1234"
    And Click on "sign in button"
    And Verify login is successful


  Scenario: Verify leave Balance card is visible or not
    Then Click on "Dashboard" tab
    Then Verify "Profile card" is present on the current page
    Then Verify "Leave balance card" is present on the current page


  Scenario: Click on number of leaves and verify leave history popup window
    Then Click on "Dashboard" tab
    Then Verify "Profile card" is present on the current page
    When Verify "Leave balance card" is present on the current page
    Then Click on "CL leave balance link"
    Then Verify "Leave history window" is present on the current page
    And Click on "Close button"
    Then Verify leave history window closes


  Scenario: Navigate to leave history window and verify number of records
    Then Click on "Dashboard" tab
    Then Verify "Profile card" is present on the current page
    When Verify "Leave balance card" is present on the current page
    Then Click on "WFH"
    And Verify "Leave history window" is visible on the current screen
    Then Verify number of records ar same as displayed on leave card

