@MISLeave
Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS


  Scenario Outline: Navigate to Leave Management > Out of Duty/Tour tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |
      | Leave Management   |     Apply  |    Leave   | Out Duty/Tour |

  Scenario Outline: Verify From,Till,Type,Primary Contact Number and Reason for outing are mandatory fields
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for Out of Duty Tab
    Then Verify "Outing From,Outing Till" fields are highlighted in red
    Examples:
      |      parentTab     |  childTab  |     tab        |
      | Leave Management   |     Apply     | Out Duty/Tour |

  Scenario Outline: Enter Data and Click on Submit
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<contactNumber>" in "Primary contact number" textbox
    Then Enter "<enterReason>" in "Reason" textbox
    Then Click on Submit button for Out of Duty Tab
    And Verify Leave is submitted and "Out Duty/Tour request has been saved successfully" appears
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  3/09/2022 | 3/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |


  Scenario Outline: Select From and Till Leave date from Calendar
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    Examples:
      |      parentTab     |       childTab  | tab |  fromDate  | toDate     |
      | Leave Management   |          Apply  |    Out Duty/Tour   | 4/10/2022 | 4/10/2022 |

  Scenario Outline: Select type for Out Duty
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  3/09/2022 | 3/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |

  Scenario Outline: Enter Reason for Out Duty
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<enterReason>" in "Reason" textbox
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  3/09/2022 | 3/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |


  Scenario Outline: Enter Primary Contact Number for Out Duty
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates for Out Duty Tour
    And Select "<outOfDutyType>" from Type dropdown
    Then Enter "<contactNumber>" in "Primary contact number" textbox
    Examples:
      |      parentTab     |       childTab  |      tab       |   fromDate |    toDate  |       outOfDutyType      |  enterReason   |  contactNumber |
      | Leave Management   |          Apply  | Out Duty/Tour  |  3/09/2022 | 3/09/2022 |  Out Duty (Client Visit) |   client visit |   8888888888   |


