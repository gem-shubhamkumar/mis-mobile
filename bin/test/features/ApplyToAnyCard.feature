@MySkills
Feature: Apply to any card maximizing and minimizing cards.

  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@1234"
    Then Verify Dashboard page opens


  Scenario: Test to verify my-skills card is minimizing
    When "My Skills" card is present in dashboard
    Then User clicks on "Minimize" button on "My Skills" card
    And Verify that "My Skills" card is minimized

  Scenario: Test to verify my-skills card is maximizing
    When "My Skills" card is present in dashboard
    Then User clicks on "Maximize" button on "My Skills" card
    And Verify that "My Skills" card is maximized




