@MISAutomation
Feature: NavBar

  Background:
    Given Navigate to "myMIS"
    Then Enter credentials to "myMIS portal" using username as "priyanshu.prajapati" and password as "Gemini@1234"
    And Click on "sign in button"
    And Verify login is successful

  Scenario: Verify user redirect to landing page when clicking on Gemini logo
    Then Verify navigation to landing page is successful after log in
    Then Click on "Employee Directory" tab
    And Verify "Employee directory table" is present on the current page
    When Click on "Gemini logo"
    Then Verify user is redirected to landing page

  Scenario: Verify toggle button on dashboard page
    Then Verify navigation to landing page is successful after log in
    And Verify "Side navigation bar" is present on the current page
    Then Click on "Menu button"
    And Verify "Side navigation bar" disappears form current screen
    Then Click on "Menu button"
    And Verify "Side navigation bar" is present on the current page

  Scenario: Click on Change AD Password and verify  new tab is open
    Then Verify navigation to landing page is successful after log in
    Then Click on "Change AD password button"
    But Verify new tab is open "RD Web Access" as page heading

  Scenario: Click on profile menu and verify all items are present
    Then Verify navigation to landing page is successful after log in
    Then Click on "Profile button"
    And Verify all menu items are present in the dropdown

  Scenario Outline: Verify success/warning message box when adding new/duplicate skills from profile dropdown
    Then Click on "Profile button"
    Then Click on "Skills option"
    And Verify "Add skills window" is visible on the current screen
    Then Select "<Technology name>" from technology dropdown on add skills window
    Then Select "Beginner" from "Proficiency" dropdown on add skills window
    Then Select "Primary" from "Skill type" dropdown on add skills window
    And Enter "5" in "Experience" text field
    And Click on "Save button"
    But Verify "Add skills window" disappears form current screen
    Then Verify "<Message box text>" message appear in screen
    Examples:
      | Technology name |Message box text|
      |.NET|Success                      |
      |.NET|Duplicate                    |









