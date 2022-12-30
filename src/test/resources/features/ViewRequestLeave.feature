Feature: MIS Leave Management > View Request Status
  This tests are for View Request Status module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Verify Date Range field is present for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Enter Invalid Date Range for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 2000" Invalid Date range for Leave Tab
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |


  Scenario Outline: Enter Valid Date Range for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" Valid Date range for Leave Tab
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      | defaultTab |       dateRange           |
      | Leave Management   | View Request Status |    Leave   | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Verify Export Options for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When Click on "Export" button on Leave tab
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Click on Print Option for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When Click on "Export" button on Leave tab
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" export option
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Click on Excel Option for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When Click on "Export" button on Leave tab
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" export option
    And Verify "Leave History List.xlsx" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Click on Copy Option for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When Click on "Export" button on Leave tab
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" export option
    And Verify Copied to Clipboard text appears
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Verify PDF option for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When Click on "Export" button on Leave tab
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "PDF" export option
    And Verify "Leave History List.pdf" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      | defaultTab |
      | Leave Management   | View Request Status |    Leave   |

  Scenario Outline: Verify Number of Entries displayed for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" Valid Date range for Leave Tab
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    And Verify number of records displayed by default
    Then Select "<noOfRecords>" as Number of entries for "Leave History" tab
    And Verify number of records displayed changes
    Examples:
      |      parentTab     |       childTab      |         dateRange          |   noOfRecords |
      | Leave Management   | View Request Status |  01 Apr 2021 - 31 Mar 2022 |       25      |

  Scenario Outline: Enter Leave Period Name in Search Box for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    When User Enters "<leavePeriod>" period in search box for "Leave" tab
    Then Verify "<leavePeriod>" Period is filtered for "Leave" tab
    Examples:
      |      parentTab     |       childTab      |        leavePeriod         |
      | Leave Management   | View Request Status | 25-Sep-2022 to 26-Sep-2022 |

  Scenario Outline: Sort columns for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Sort "Period,Type,Reason,Remarks" columns and verify sorting
    Examples:
      |      parentTab     |       childTab      |
      | Leave Management   | View Request Status |

  Scenario Outline: Page Next for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" Valid Date range for Leave Tab
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Then Click on Next button for "Leave History" tab
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |          dateRange         |
      | Leave Management   | View Request Status |  01 Apr 2021 - 31 Mar 2022 |

  Scenario Outline: Page Previous for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" Valid Date range for Leave Tab
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Then Click on Next button for "Leave History" tab
    And Verify Records are present on Page
    Then Click on Previous button for "Leave History" tab
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |          dateRange         |
      | Leave Management   | View Request Status |  01 Apr 2021 - 31 Mar 2022 |

  Scenario Outline: Cancel Leave for Leave Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And Select "<leaveType>" from Leave Type dropdown
    And Enter reason "leave Reason" for leave
    And choose "Mobile" as Availability
    Then Click on Submit button for Leave Tab
    And Verify Leave is submitted and "Leave applied successfully" appears
    When Click on "<anotherTab>" tab
    Then Verify Date Range field is present
    And Click on Expand Leave button
    When Click on Cancel button
    Then Verify "Are you sure you want to cancel this request ?" Popup appears
    And Click on Yes button
    And Verify Leave is cancelled and "Request processed successfully" appears
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |  leaveType |     anotherTab      |
      | Leave Management   |          Apply  |    Leave   | 24/11/2022 |  24/11/2022 |     CL     | View Request Status |


