Feature: MIS Leave Management > View Request Status
  This tests are for View Request Status module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Verify Date Range field is present for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Enter Invalid Date Range for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Verify Date Range field is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |


  Scenario Outline: Enter Valid Date Range for Out Duty/Tour
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
      |      parentTab     |       childTab      |       tab      |       dateRange           |
      | Leave Management   | View Request Status |  Out Duty/Tour | 01 Apr 2022 - 31 Mar 2023 |


  Scenario Outline: Click on Export Options Option for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Print Option for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" export option
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Copy Option for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" export option
    And Verify Copied to Clipboard text appears
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Excel Option for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" export option
    And Verify "Gemini - MIS.xlsx" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Verify PDF option for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When Click on "Export" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "PDF" export option
    And Verify "Gemini - MIS.pdf" file is downloaded in MIS
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Sort columns for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    Then Sort "Duty Type" columns and verify sorting
    Then Sort "Reason,Remarks" Columns and verify Sort
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status | Out Duty/Tour |

  Scenario Outline: Enter Out Duty/Tour Period in Search Box for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod   |       tab     |
      | Leave Management   | View Request Status |    29 Sep 2022  | Out Duty/Tour |

  Scenario Outline: Verify Data is present for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    And Verify data is present
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on View button for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    And Click on View Out Duty button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Verify Date in View Window for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    And Click on View Out Duty button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    And Verify "<outDutyPeriod>" date
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod  |        tab      |
      | Leave Management   | View Request Status | 29 Dec 2022    |   Out Duty/Tour |

  Scenario Outline: Search in View Window for Out Duty/Tour
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    When Click on "<tab>" tab
    And Verify "<tab>" displays
    And Click on View Out Duty button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    And Verify "<outDutyPeriod>" date
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty Details" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty Details" tab
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod |      tab      |
      | Leave Management   | View Request Status |   29 Dec 2022 | Out Duty/Tour |

