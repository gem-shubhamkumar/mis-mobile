Feature: MIS Leave Management Activities > Apply
  This tests are for Apply module of MIS Beta

  Background:
    Given User is logged into MIS


  @Tag6
  Scenario Outline: Navigate to Leave Management > WFH tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |



  @Tag6
  Scenario Outline: Verify field is Auto Populated by default in WFH tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify "mobileNo" fields are auto populated
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |



  @Tag6
  Scenario Outline: Verify WFH Date and WFH Reason are mandatory fields
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for WFH tab
    Then Verify "Work From Home Date" dropdown is mandatory field
    Then Verify "WFH Reason" text box is mandatory field
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |




  @Tag6
  Scenario Outline: Select Date from WFH Date dropdown
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |






  @Tag6
  Scenario Outline: Enter reason for WFH
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    And Enter reason "WFH Reason" for leave
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |





  @Tag6
  Scenario Outline: Enter required data and click on Submit WFH
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    And Enter reason "WFH Reason" for leave
    Then Click on Submit button for WFH tab
#    And Verify Leave is submitted and "Request processed successfully" appears
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                          |
      | Leave Management   |     Apply  |    Leave   | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

