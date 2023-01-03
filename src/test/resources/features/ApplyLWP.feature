Feature: MIS Leave Management Activities > Apply
  This tests are for Apply module of MIS Beta

  Background:
    Given User is logged into MIS




  @Tag6
  Scenario Outline: Navigate to Leave Management > LWP Change Request tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  |           tab           |  heading |
      | Leave Management   |     Apply  |    LWP Change Request   |Apply Leave / WFH / Comp Off / Out Duty / Change Request |



  @Tag6
  Scenario Outline: Verify Date, Type of leave and Reason fields are mandatory
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for LWP tab
    Then Verify "legitimate Reason" text box is mandatory field
    Then Verify "legitimate Type,from Date" dropdown is mandatory field
    Examples:
      |      parentTab     |  childTab  |           tab           |  heading |
      | Leave Management   |     Apply  |    LWP Change Request   |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

