Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > Apply tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Examples:
      |      parentTab     |  childTab  | defaultTab |
      | Leave Management   |     Apply  |    Leave   |

  Scenario Outline: Verify fields are Auto Populated by default
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Verify "Primary Contact Number,Other Contact Number" fields are auto populated
    Examples:
      |      parentTab     |   childTab  | defaultTab |
      | Leave Management   |      Apply  |    Leave   |

  Scenario Outline: Verify From,Till and Reason fields are mandatory
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Verify "Primary Contact Number,Other Contact Number" fields are auto populated
    Then Click on Submit button for Leave Tab
    Then Verify "From,Till,Reason" fields are highlighted in red
    Examples:
      |      parentTab     |       childTab  | defaultTab |
      | Leave Management   |          Apply  |    Leave   |

  Scenario Outline: Select From and Till Leave date from Calendar
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  | toDate     |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 | 29/09/2022 |

  Scenario Outline: Verify Total Working Days tooltip
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    Then Click on "Total Working Days" info icon
    And Verify "Total Working Days" tooltip text
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  | toDate    |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 | 29/09/2022|

  Scenario Outline: Choose leave for half day option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    When Click on "Leave for half day" checkbox
    And Verify "<halfDayOptions>" half day options are available
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |            halfDayOptions        |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 | 29/09/2022  | First half leave,Second half leave |

  Scenario Outline: Choose leave type
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Select "<leaveType>" from Leave Type dropdown
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |  leaveType |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 |  29/09/2022 |     CL     |

  Scenario Outline: Enter reason for leave
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Enter reason "sick leave" for leave
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 |  29/09/2022 |

  Scenario Outline: Choose Availability
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And choose "Mobile" as Availability
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 |  29/09/2022 |

  Scenario Outline: Enter required data and click on Submit leave
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Select "<leaveType>" from Leave Type dropdown
    And Enter reason "sick leave" for leave
    Then Click on Submit button for Leave Tab
    And Verify Leave is submitted and "leave applied successfully" appears
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |  leaveType |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 |  29/09/2022 |     CL     |