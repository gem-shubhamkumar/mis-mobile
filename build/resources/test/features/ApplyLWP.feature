Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > LWP Change Request tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  |           tab           |  heading |
      | Leave Management   |     Apply  |    LWP Change Request   |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify Date, Type of leave and Reason fields are mandatory
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for LWP tab
    Then Verify "legitimate Reason" text box is mandatory field
    Then Verify "legitimate Type,from Date" dropdown is mandatory field
    Examples:
      |      parentTab     |  childTab  |           tab           |  heading |
      | Leave Management   |     Apply  |    LWP Change Request   |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

