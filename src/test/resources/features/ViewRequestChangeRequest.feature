Feature: MIS LeaveManagement ViewRequestStatus
  This tests are for View Request Status module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Verify Date Range field is present for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Enter Invalid Date Range for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Enter Valid Date Range for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |         tab     |       dateRange           |
      | Leave Management   | View Request Status |  Change Request | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab        |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Print Option for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" export option
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |     tab         |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Copy Option for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" export option
    And Verify Copied to Clipboard text appears
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Excel Option for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" export option
    And Verify "Leave History List.xlsx" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |        tab      |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Verify PDF option for Change Request
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "PDF" export option
    And Verify "Leave History List.pdf" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |        tab      |
      | Leave Management   | View Request Status |  Change Request |
