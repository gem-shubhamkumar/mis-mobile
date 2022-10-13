Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > Apply tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Examples:
      |      parentTab     |  childTab  | defaultTab |                        heading                           |
      | Leave Management   |     Apply  |    Leave   |  Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify fields are Auto Populated by default on Leave tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Verify "leave Contact Number,leave Alt Contact Number" fields are auto populated
    Examples:
      |      parentTab     |  childTab  | defaultTab |                        heading                           |
      | Leave Management   |     Apply  |    Leave   |  Apply Leave / WFH / Comp Off / Out Duty / Change Request |


  Scenario Outline: Verify From,Till and Reason fields are mandatory fields for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Verify "leave Contact Number,leave Alt Contact Number" fields are auto populated
    Then Click on Submit button for Leave Tab
    Then Verify "Leave From,Leave Till" calendar is mandatory field
    Then Verify "leave Reason" text box is mandatory field
    Examples:
      |      parentTab     |  childTab  | defaultTab |                        heading                           |
      | Leave Management   |     Apply  |    Leave   |  Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Select From and Till Leave date from Leave Calendar
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  | toDate     |                        heading                           |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 | 21/10/2022 | Apply Leave / WFH / Comp Off / Out Duty / Change Request |


  Scenario Outline: Verify Total Working Days tooltip from Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    Then Click on "Total Working Days" info icon
    And Verify "Total Working Days" tooltip text
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  | toDate     |                        heading                           |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 | 21/10/2022 | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Choose leave for half day option from Leave tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    When Click on "Leave for half day" checkbox
    And Verify "<halfDayOptions>" half day options are available
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |            halfDayOptions          |                     heading                             |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 | 21/10/2022  | First half leave,Second half leave |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Choose leave type
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Select "<leaveType>" from Leave Type dropdown
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |  leaveType |                    heading                              |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 |  21/10/2022 |     CL     |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Enter reason for leave
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Enter reason "leave Reason" for leave
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |                         heading                          |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 |  21/10/2022 | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Choose Availability for Leave
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And choose "Mobile" as Availability
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |                        heading                          |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 |  21/10/2022 |Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Enter required data and click on Submit leave
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Select "<leaveType>" from Leave Type dropdown
    And Enter reason "leave Reason" for leave
    And choose "Mobile" as Availability
    Then Click on Submit button for Leave Tab
    And Verify Leave is submitted and "Leave applied successfully" appears
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |  leaveType |                       heading                           |
      | Leave Management   |          Apply  |    Leave   | 21/10/2022 |  21/10/2022 |     CL     |Apply Leave / WFH / Comp Off / Out Duty / Change Request |