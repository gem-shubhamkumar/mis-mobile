Feature: MIS Leave Management Activities > Apply
  This tests are for Apply module of MIS Beta

  Background:
    Given User is logged into MIS

  @tagMS
  Scenario Outline: Navigate to Leave Management > Comp Off tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    Then Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |                         heading                           |
      | Leave Management   |     Apply  |    Leave   |    Comp Off    |   Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify Date and Reason are mandatory fields for Comp Off
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When User clicks on Submit button for Comp off Tab
    Then Verify "Comp Off Reason" text box is mandatory field
    Then Verify "Comp Off Date" dropdown is mandatory field
    Examples:
      |      parentTab     |  childTab  |     tab        |                         heading                           |
      | Leave Management   |     Apply  |    Comp Off    |   Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Select Date from Comp Off Date dropdown
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from date dropdown
    Examples:
      |      parentTab     |  childTab  |     tab        |                         heading                           |
      | Leave Management   |     Apply  |    Comp Off    |   Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Enter Reason for Comp off
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Enter "weekend testing" as reason
    Examples:
      |      parentTab     |  childTab  |     tab        |                         heading                           |
      | Leave Management   |     Apply  |    Comp Off    |   Apply Leave / WFH / Comp Off / Out Duty / Change Request |


  # will only work if there is a date in date dropdown , which is not there at times
  Scenario Outline: Enter Data and submit Comp off
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from date dropdown
    Then Enter "weekend testing" as reason
    When User clicks on Submit button for Comp off Tab
    And Verify Leave is submitted and "Request processed successfully" appears
    Examples:
      |      parentTab     |  childTab  |     tab        |                         heading                           |
      | Leave Management   |     Apply  |    Comp Off    |   Apply Leave / WFH / Comp Off / Out Duty / Change Request |
