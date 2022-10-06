Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Out Duty/Tour
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Verify Date Range field is present for Leave Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Enter Invalid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range in Out Duty
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Enter Valid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range in Out Duty
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |       tab      |       dateRange           |
      | Leave Management   | View Request Status |  Out Duty/Tour | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Out Duty/Tour" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Print Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Out Duty/Tour" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" button
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Copy Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Out Duty/Tour" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" button
    And Verify "Copied to Clipboard" popup appears
    Examples:
      |      parentTab     |       childTab      |      tab       |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Click on Excel Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Out Duty/Tour" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" button
    And Verify excel file is downloaded for "Out Duty/Tour" Tab
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Verify PDF option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export Out Duty/Tour" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Pdf" button
    And Verify pdf file is downloaded for "Out Duty/Tour" Tab
    Examples:
      |      parentTab     |       childTab      |     tab        |
      | Leave Management   | View Request Status |  Out Duty/Tour |

  Scenario Outline: Sort columns
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Sort "Period Out Duty,Duty Type,Reason Out Duty,Remarks Out Duty" columns and verify sorting
    Examples:
      |      parentTab     |       childTab      |       tab     |
      | Leave Management   | View Request Status | Out Duty/Tour |

  Scenario Outline: Enter Out Duty/Tour Period in Search Box
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod   |       tab     |
      | Leave Management   | View Request Status |    29 Sep 2022  | Out Duty/Tour |

  Scenario Outline: Expand Details
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    And Click on "Expand Out Duty" button
    Then Verify "Applied On" Date for "Out Duty/Tour" tab
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod   |     tab       |
      | Leave Management   | View Request Status |   29 Sep 2022   | Out Duty/Tour |

  Scenario Outline: Click on View button on Expanding Details
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    And Click on "Expand Out Duty" button
    Then Verify "Applied On" Date for "Out Duty/Tour" tab
    And Click on "View Out Duty" button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod |     tab       |
      | Leave Management   | View Request Status |   29 Sep 2022 | Out Duty/Tour |

  Scenario Outline: Verify Date in View Window
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    And Click on "Expand Out Duty" button
    Then Verify "Applied On" Date for "Out Duty/Tour" tab
    And Click on "View Out Duty" button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    And Verify "<outDutyPeriod>" date
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod  |        tab      |
      | Leave Management   | View Request Status | 29 Sep 2022    |   Out Duty/Tour |


  Scenario Outline: Search in View Window
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty" tab
    And Click on "Expand Out Duty" button
    Then Verify "Applied On" Date for "Out Duty/Tour" tab
    And Click on "View Out Duty" button
    Then Verify "Out Duty/Tour Request Detail" Window appears
    And Verify "<outDutyPeriod>" date
    When User Enters "<outDutyPeriod>" period in search box for "Out Duty Details" tab
    Then Verify "<outDutyPeriod>" Period is filtered for "Out Duty Details" tab
    Examples:
      |      parentTab     |       childTab      | outDutyPeriod |      tab      |
      | Leave Management   | View Request Status |   29 Sep 2022 | Out Duty/Tour |

