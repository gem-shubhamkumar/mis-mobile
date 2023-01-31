@applytoanycard
Feature: MIS Cards Management


  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@123"
    Then Verify beta-mis Dashboard page opens

  @minimize
  Scenario: Test to verify minimize functionality is working on any card in Beta Mis
    When check "Referral" card is present in dashboard
    Then User clicks on "Minimize" button on "Referral" card on dashboard
    And Verify that "Referral" card is minimized on dashboard

  @Beta
  Scenario: Test to verify fullscreen functionality is working on any card in Beta Mis
    When check "Health Insurance" card is present in dashboard
    Then User clicks on "Maximize" button on "Health Insurance" card on dashboard
    And Verify that "Health Insurance" card is maximized on dashboard





