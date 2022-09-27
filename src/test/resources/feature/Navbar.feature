@MISAutomation
Feature: NavBar

  Background:
    Given Navigate to "myMIS"
    Then Enter credentials to "myMIS portal" using username as "priyanshu.prajapati" and password as "Gemini@1234"
    And Click on "sign in button"
    And Verify login is successful

  Scenario: Verify user redirect to landing page when clicking on Gemini logo
    Then Verify "Profile card" is present on the current page
    Then Click on "Employee Directory" tab
    And Verify "Employee directory table" is present on the current page
    When Click on "Gemini logo"
    Then Verify user is redirected to landing page

  Scenario: Verify toggle button on dashboard page
    Then Verify "Profile card" is present on the current page
    And Verify "Side navigation bar" is present on the current page
    Then Click on "Menu button"
    And Verify "Side navigation bar" disappears form current screen
    Then Click on "Menu button"
    And Verify "Side navigation bar" is present on the current page

  Scenario: Click on Change AD Password and verify  new tab is open
    Then Verify "Profile card" is present on the current page
    Then Click on "Change AD password button"
    But Verify new tab is open "RD Web Access" as page heading


