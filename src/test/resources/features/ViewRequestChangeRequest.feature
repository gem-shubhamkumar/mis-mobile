Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > View Request Status tab > Change Request
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Verify Date Range field is present for Leave Tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Enter Invalid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "01 Apr 20000" "Invalid" Date range in Change Request
    And Verify "No results found" message displays
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Enter Valid Date Range
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    Then Verify "Date Range" fields is present
    And Click "Date Range" dropdown
    Then Enter "<dateRange>" "Valid" Date range in Change Request
    And Verify "<dateRange>" text displays
    Then Verify "<dateRange>" is selected
    Examples:
      |      parentTab     |       childTab      |         tab     |       dateRange           |
      | Leave Management   | View Request Status |  Change Request | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Click on Export Options Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export LWP" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    Examples:
      |      parentTab     |       childTab      |      tab        |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Print Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export LWP" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Print" button
    And Verify Print page appears
    Examples:
      |      parentTab     |       childTab      |     tab         |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Copy Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export LWP" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Copy" button
    And Verify "Copied to Clipboard" popup appears
    Examples:
      |      parentTab     |       childTab      |       tab       |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Click on Excel Option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export LWP" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Excel" button
    And Verify excel file is downloaded for "LWP" Tab
    Examples:
      |      parentTab     |       childTab      |        tab      |
      | Leave Management   | View Request Status |  Change Request |

  Scenario Outline: Verify PDF option
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When Click on "<tab>" tab
    And Verify "<tab>" opens successfully
    When Click on "Export LWP" button
    Then Verify "Copy,Excel,PDF,Print" options are displayed
    When Click on "Pdf" button
    And Verify pdf file is downloaded for "LWP" Tab
    Examples:
      |      parentTab     |       childTab      |        tab      |
      | Leave Management   | View Request Status |  Change Request |

