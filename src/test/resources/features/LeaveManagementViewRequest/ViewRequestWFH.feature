Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Work From Home
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Examples:
      |      parentTab     |       childTab      |  tab |
      | Leave Management   | View Request Status |  Work From Home |

  Scenario Outline: Verify Date Range field is present for Leave Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    Examples:
      |      parentTab     |       childTab      |       tab |
      | Leave Management   | View Request Status |    Work From Home   |

  Scenario Outline: Enter Invalid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" Valid Date range in WFH
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |       tab |
      | Leave Management   | View Request Status |    Work From Home   |

  Scenario Outline: Enter Valid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" Valid Date range in WFH
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |     tab    |   dateRange |
      | Leave Management   | View Request Status |    Work From Home   | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export WFH" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Print Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export WFH" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print WFH" button
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Copy Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export WFH" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" button
    And Verify "Copied to Clipboard" popup appears
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Click on Excel Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export WFH" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" button
    And Verify excel file is downloaded for "WFH" Tab
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Verify PDF option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export WFH" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Pdf" button
    And Verify pdf file is downloaded for "WFH" Tab
    Examples:
      |      parentTab     |       childTab      |     tab          |
      | Leave Management   | View Request Status | Work From Home   |

  Scenario Outline: Verify Number of Entries displayed
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    And Verify number of records displayed by default
    Then Select "<noOfRecords>" as Number of entries for "WFH" tab
    And Verify number of records displayed changes
    Examples:
      |      parentTab     |       childTab      |     tab          |  noOfRecords |
      | Leave Management   | View Request Status | Work From Home   |  25          |

  Scenario Outline: Enter WFH Period Name in Search Box
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When User Enters "<wfhPeriod>" period in search box for "WFH" tab
    Then Verify "<wfhPeriod>" Period is filtered for "WFH" tab
    Examples:
      |      parentTab     |       childTab      | wfhPeriod   |    tab |
      | Leave Management   | View Request Status | 27-Sep-2022 | Work From Home |

  Scenario Outline: Sort columns
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Sort "Period WFH,Half Day,Reason WFH,Remarks WFH" columns and verify sorting
    Examples:
      |      parentTab     |       childTab      |   tab |
      | Leave Management   | View Request Status | Work From Home |


  Scenario Outline: Page Next
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Click on "Next" button if there is more than one page
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |   tab |
      | Leave Management   | View Request Status | Work From Home |
  Scenario Outline: Page Previous
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    Then Click on "Next WFH" button if there is more than one page
    And Verify Records are present on Page
    Then Click on "Previous WFH" button if there is more than one page
    And Verify Records are present on Page
    Examples:
      |      parentTab     |       childTab      |   tab |
      | Leave Management   | View Request Status | Work From Home |
