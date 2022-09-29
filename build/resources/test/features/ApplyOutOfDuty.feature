@MISLeave
Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS


  Scenario Outline: Enter Data and Click on Submit
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<contactNumber>" in "Primary contact number" textbox
    Then Enter "<enterReason>" in "Reason" textbox
    Then Click on Submit button for Out of Duty Tab
    And Verify Leave is submitted and "Out Duty/Tour request has been saved successfully" appears
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  29/09/2022 | 29/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |
