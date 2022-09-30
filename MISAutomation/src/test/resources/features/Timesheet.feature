Feature: Perform actions on Timesheet of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@1234"

  @Test @TC01 @TimeSheet @ConfTimesheet
  Scenario: MIS_TimeSheet_ConfTimesheet_verifyTable
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Verify table data for configure Timesheet page
    Then Logout from MIS

  @Test @TC02 @TimeSheet @ConfTimesheet
  Scenario: MIS_TimeSheet_ConfTimesheet_verifyTabs
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Verify all tabs and active tab
    Then Logout from MIS

  @Test @TC03 @TimeSheet @ConfTimesheet
  Scenario Outline: MIS_TimeSheet_ConfTimesheet_searchText
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Perform search for "<Text>" using search box
    Then Logout from MIS
    Examples:
      | Text |
      | abcd |
      | @#$% |
      | 1234 |

  @Test @TC04 @TimeSheet @ConfTimesheet
  Scenario: MIS_TimeSheet_ConfTimesheet_verifySave
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Click on save button
    Then Verify and accept success popup
    Then Logout from MIS

  @Test @TC05 @TimeSheet @CreateTimesheet
  Scenario: MIS_TimeSheet_CreateTimesheet_verifyTable
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Verify table data for create Timesheet page
    Then Logout from MIS

  @Test @TC06 @TimeSheet @CreateTimesheet
  Scenario: MIS_TimeSheet_CreateTimesheet_verifyTimesheetStatus
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Verify timesheet status
    Then Logout from MIS

  @Test @TC07 @TimeSheet @CreateTimesheet
  Scenario: MIS_TimeSheet_CreateTimesheet_openPreviousAndNextWeek
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Open previous and next week
    Then Verify and accept warning popup
    Then Logout from MIS

  @Test @TC08 @TimeSheet @CreateTimesheet
  Scenario Outline: MIS_TimeSheet_CreateTimesheet_copyFromWeek
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Copy timesheet from week "<week>" of year "<year>"
    Then Logout from MIS
    Examples:
      | week | year |
      |      |      |
      |      | 2022 |

  @Test @TC09 @TimeSheet @ManageTaskTemplate
  Scenario: MIS_TimeSheet_ManageTaskTemplate_verifyTable
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Verify table data for manage task template page
    Then Logout from MIS

  @Test @TC10 @TimeSheet @ManageTaskTemplate
  Scenario Outline: MIS_TimeSheet_ManageTaskTemplate_searchText
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Perform search for "<Text>" using search box
    Then Logout from MIS
    Examples:
      | Text |
      | abcd |
      | @#$% |
      | 1234 |

  @Test @TC11 @TimeSheet @ManageTaskTemplate
  Scenario Outline: MIS_TimeSheet_ManageTaskTemplate_addNewTemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new task template with "<Name>" "<Description>" "<Team>" "<Task>"
    Then Logout from MIS
    Examples:
      | Name | Description   | Team |   Task   |
      |      |               |      |          |
      | abcd |               |      |          |
      |      | FirstTemplate |      |          |
      |      |               |  QA  |          |
      | abcd | FirstTemplate |      |          |
      | abcd | FirstTemplate |  QA  |          |
      | abcd | FirstTemplate |  QA  | Learning |

  @Test @TC12 @TimeSheet @ManageTaskTemplate
  Scenario Outline: MIS_TimeSheet_ManageTaskTemplate_editATemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Edit a task template "abc" with "<Name>" "<Description>" "<Team>" "<Task>"
    Then Logout from MIS
    Examples:
      | Name | Description | Team |   Task   |
      |      |             |      |          |
      | wxyz |             |      |          |
      |      | MyTemplate  |      |          |
      |      |             | FES  |          |
      | wxyz | MyTemplate  |      |          |
      | wxyz | MyTemplate  | FES  |          |
      | wxyz | MyTemplate  | FES  | Testing  |


  @Test @TC13 @TimeSheet @ManageTaskTemplate
  Scenario: MIS_TimeSheet_ManageTaskTemplate_deleteATemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Click on Delete button for a task template "xyz"
    Then Verify and accept confirmation popup
    Then Logout from MIS