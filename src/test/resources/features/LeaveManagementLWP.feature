Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > LWP Change Request tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  |           tab           |
      | Leave Management   |     Apply  |    LWP Change Request   |

  Scenario Outline: Verify Date, Type of leave and Reason fields are mandatory
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for LWP tab
    Then Verify "LWP Change Request From,Type of Leave,Reason for Request" fields are highlighted in red
    Examples:
      |      parentTab     |  childTab  |           tab           |
      | Leave Management   |     Apply  |    LWP Change Request   |

