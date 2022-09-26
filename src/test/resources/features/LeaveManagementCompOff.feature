Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > Comp Off tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |
      | Leave Management   |     Apply  |    Leave   |    Comp Off    |

  Scenario Outline: Verify Date and Reason are mandatory fields
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for Comp off Tab
    Then Verify "Date,Comp Off Reason" fields are highlighted in red
    Examples:
      |      parentTab     |       childTab  |     tab       |
      | Leave Management   |          Apply  |    Comp Off   |

  