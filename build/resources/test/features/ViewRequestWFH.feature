Feature: MIS Leave Management > View Request Status
  This tests are for View Request Status module of MIS Beta

  Background:
    Given User is logged into MIS
  Scenario Outline: Navigate to Leave Management > View Request Status tab > Work From Home
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |       childTab      |      tab        |
      | Leave Management   | View Request Status |  Work From Home |

  Scenario Outline: Verify Date Range field is present for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    Examples:
      |      parentTab     |       childTab      |          tab        |
      | Leave Management   | View Request Status |    Work From Home   |

  Scenario Outline: Enter Invalid Date Range for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |        tab          |
      | Leave Management   | View Request Status |    Work From Home   |

  Scenario Outline: Enter Valid Date Range for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |          tab        |        dateRange          |
      | Leave Management   | View Request Status |    Work From Home   | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Print Option for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" export option
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Copy Option for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" export option
    And Verify Copied to Clipboard text appears
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Excel Option for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" export option
    And Verify "WFH History List.xlsx" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Verify PDF option for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "PDF" export option
    And Verify "WFH History List.pdf" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  
  Scenario Outline: Verify Number of Entries displayed for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    And Verify number of records displayed by default
    Then Select "<noOfRecords>" as Number of entries for "WFH History" tab
    And Verify number of records displayed changes
    Examples:
      |      parentTab     |       childTab      |     tab          |  noOfRecords |
      | Leave Management   | View Request Status | Work From Home   |  25          |


  Scenario Outline: Enter WFH Period Name in Search Box for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When User Enters "<wfhPeriod>" period in search box for "WFH" tab
    Then Verify "<wfhPeriod>" Period is filtered for "WFH" tab
    Examples:
      | parentTab        | childTab            | wfhPeriod   | tab            |
      | Leave Management | View Request Status | 27-Sep-2022 | Work From Home |


  Scenario Outline: Sort columns for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Sort "Duty Type" columns and verify sorting
    Then Sort "Reason,Remarks" Columns and verify Sort
    Examples:
      |      parentTab     |       childTab      |        tab     |
      | Leave Management   | View Request Status | Work From Home |

  
  Scenario Outline: Page Next for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Click on Next button for "WFH History" tab
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status | Work From Home |

  Scenario Outline: Page Previous for WFH Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Click on Next button for "WFH History" tab
    And Verify Records are present on Page
    Then Click on Previous button for "WFH History" tab
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |       tab      |
      | Leave Management   | View Request Status | Work From Home |