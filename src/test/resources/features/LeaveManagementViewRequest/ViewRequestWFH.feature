Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Page Previous
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Click on "Next WFH" button if there is more than one page
    And Verify Records are present on Page
    Then Click on "Previous WFH" button if there is more than one page
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |   tab |
      | Leave Management   | View Request Status | Work From Home |
