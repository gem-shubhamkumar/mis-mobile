Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Choose Availability
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Select "<fromDate>" From date and "<toDate>" till Leave dates from Calendar
    And choose "Mobile" as Availability
    Examples:
      |      parentTab     |       childTab  | defaultTab |  fromDate  |   toDate    |
      | Leave Management   |          Apply  |    Leave   | 29/09/2022 |  29/09/2022 |

