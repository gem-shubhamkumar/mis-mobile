Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > Out of Duty/Tour tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify "<defaultTab>" displays by default
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab       | heading|
      | Leave Management   |     Apply  |    Leave   | Out Duty/Tour |Apply Leave / WFH / Comp Off / Out Duty / Change Request |


  Scenario Outline: Verify From,Till,Type,Primary Contact Number and Reason for outing are mandatory fields
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for Out of Duty Tab
    Then Verify "Outing From,Outing Till" calendar is mandatory field
    Examples:
      |      parentTab     |  childTab  |      tab       |                    heading                              |
      | Leave Management   |     Apply  |  Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Select From and Till Leave date from Calendar
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    Examples:
      |      parentTab     |  childTab |      tab        |  fromDate | toDate     |
      | Leave Management   |    Apply  |  Out Duty/Tour  | 4/10/2022 | 4/10/2022  |

  Scenario Outline: Select type for Out Duty
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  31/10/2022 | 31/10/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |

  Scenario Outline: Enter Reason for Out Duty
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<enterReason>" in "outing Reason" text box
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |
      | Leave Management   |          Apply  | Out Duty/Tour  |  31/10/2022 | 31/10/2022 |  Out Duty (Client Visit) |   client visit |

  Scenario Outline: Enter Primary Contact Number for Out Duty
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<contactNumber>" in "outing Contact Number" textbox
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |    contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  31/10/2022 | 31/10/2022 |  Out Duty (Client Visit) |    8888888888   |

  Scenario Outline: Enter Data and Click on Submit for Out of Duty tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    When User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<contactNumber>" in "outing Contact Number" textbox
    Then Enter "<enterReason>" in "outing Reason" text box
    Then Click on Submit button for Out of Duty Tab
    And Verify Leave is submitted and "Out Duty/Tour request has been applied successfully." appears
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  29/09/2022 | 29/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |
