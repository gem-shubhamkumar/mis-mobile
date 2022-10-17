Feature: MIS Leave Management > View Request Status
  This tests are for View Request Status module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Comp Off
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |       childTab      |     tab   |
      | Leave Management   | View Request Status |  Comp Off |

  Scenario Outline: Verify Date Range field is present for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Invalid Date Range for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Valid Date Range for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |       tab     |       dateRange           |
      | Leave Management   | View Request Status |    Comp Off   | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Print Option for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" export option
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Copy Option for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" export option
    And Verify Copied to Clipboard text appears
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Excel Option for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" export option
    And Verify "CompOff History List.xlsx" file is downloaded
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Verify PDF option for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "PDF" export option
    And Verify "CompOff History List.pdf" file is downloaded
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Comp Off Period Name in Search Box for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When User Enters "<compOffPeriod>" period in search box for "Comp Off" tab
    Then Verify "<compOffPeriod>" Period is filtered for "Comp Off" tab
    Examples:
      |      parentTab     |       childTab      | compOffPeriod |    tab   |
      | Leave Management   | View Request Status |   25-Sep-2022 | Comp Off |

  Scenario Outline: Sort columns for Comp Off Tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Sort "Applied for,Days" columns and verify sorting
    Then Sort "Reason,Remarks" Columns and verify Sort
    Examples:
      |      parentTab     |       childTab      |   tab    |
      | Leave Management   | View Request Status | Comp Off |

  Scenario Outline: Expand Details of Comp Off
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    When User Enters "<compOffPeriod>" period in search box for "Comp Off" tab
    Then Verify "<compOffPeriod>" Period is filtered for "Comp Off" tab
    And Click on Expand Comp Off button
    And Verify details box appears
    Examples:
      |      parentTab     |         childTab       |      tab      |   compOffPeriod  |
      | Leave Management   |   View Request Status  |    Comp Off   |     25-Sep-2022  |
