Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > WFH tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |
      | Leave Management   |     Apply  |    Leave   | Work From Home |
