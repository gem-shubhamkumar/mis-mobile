@MISAutomation @LeaveBalance
Feature: Leave Balance

  Background:
    Given User has login to myMIS beta

  @LeaveBalance1
  Scenario: Verify leave Balance card is visible or not
    Then Verify "Profile card" is present on the current page
    Then Verify "Leave balance card" is present on the current page

  @LeaveBalance2
  Scenario: Click on number of leaves and verify leave history popup window
    Then Verify "Profile card" is present on the current page
    When Verify "Leave balance card" is present on the current page
    Then Navigate to "CL" link
    Then Verify "Leave history window" is present on the current page
    And Click on "Close button"
    Then Verify leave history window closes

  @LeaveBalance3
  Scenario: Navigate to leave history window and verify number of records
    Then Verify "Profile card" is present on the current page
    When Verify "Leave balance card" is present on the current page
    Then Navigate to "WFH" link
    And Verify "Leave history window" is visible on the current screen
    Then Verify number of records ar same as displayed on leave card

