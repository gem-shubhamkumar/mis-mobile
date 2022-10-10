Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Comp Off
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Examples:
      |      parentTab     |       childTab      |     tab   |
      | Leave Management   | View Request Status |  Comp Off |

  Scenario Outline: Verify Date Range field is present for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Invalid Date Range for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range in Comp Off
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Valid Date Range for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range in Comp Off
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |       tab     |       dateRange           |
      | Leave Management   | View Request Status |    Comp Off   | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Comp Off" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Print Option for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Comp Off" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" button
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |      tab      |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Copy Option for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Comp Off" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" button
    And Verify "Copied to Clipboard" popup appears
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Click on Excel Option for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Comp Off" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" button
    And Verify excel file is downloaded for "Comp Off" Tab
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Verify PDF option for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Comp Off" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Pdf" button
    And Verify pdf file is downloaded for "Comp Off" Tab
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status |    Comp Off   |

  Scenario Outline: Enter Comp Off Period Name in Search Box for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When User Enters "<compOffPeriod>" period in search box for "Comp Off" tab
    Then Verify "<compOffPeriod>" Period is filtered for "Comp Off" tab
    Examples:
      |      parentTab     |       childTab      | compOffPeriod |    tab   |
      | Leave Management   | View Request Status |   25-Sep-2022 | Comp Off |

  Scenario Outline: Sort columns for Comp Off Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Sort "Applied for,Days,Reason Comp Off,Remarks Comp Off" columns and verify sorting
    Examples:
      |      parentTab     |       childTab      |   tab    |
      | Leave Management   | View Request Status | Comp Off |

  Scenario Outline: Expand Details of Comp Off
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    When User Enters "<compOffPeriod>" period in search box for "Comp Off" tab
    Then Verify "<compOffPeriod>" Period is filtered for "Comp Off" tab
    And Click on "Expand Comp Off" button
    And Verify details of Comp Off request for "<compOffPeriod>"
    Examples:
      |      parentTab     |         childTab       |      tab      |   compOffPeriod  |
      | Leave Management   |   View Request Status  |    Comp Off   |     25-Sep-2022  |
