Feature: Perform actions on Timesheet of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@1234"

  @Test @TC01 @TimeSheet @ConfTimesheet
  Scenario: MIS_TimeSheet_ConfTimesheet_
    Then Open "Configure Timesheet" page of "TimeSheet" module