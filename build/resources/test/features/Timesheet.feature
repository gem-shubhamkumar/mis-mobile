Feature: Perform actions on TimeSheet of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@123"

  #-------------------------------------------Configure Timesheet-------------------------------------------#

  @Test @TC01 @TimeSheet @ConfTimesheet
  Scenario: Verify the table heads and table data
  #MIS_TimeSheet_ConfTimesheet_verifyTable
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Verify table for configure Timesheet page
    Then Logout from MIS

  @Test @TC02 @TimeSheet @ConfTimesheet
  Scenario: Verify total tabs and active tab
  #MIS_TimeSheet_ConfTimesheet_verifyTabs
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Verify all tabs and active tab
    Then Logout from MIS

  @Test @TC03 @TimeSheet @ConfTimesheet
  Scenario Outline: Search a text using search box
  #MIS_TimeSheet_ConfTimesheet_searchText
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Perform search for "<Text>" using search box when no records are displayed
    Then Logout from MIS
    Examples:
      | Text |
      | abcd |
      | @#$% |
      | 1234 |

  @Test @TC04 @TimeSheet @ConfTimesheet
  Scenario: Verify Save button is present and working
  #MIS_TimeSheet_ConfTimesheet_verifySave
    Then Open "Configure Timesheet" page of "TimeSheet" module
    And Verify "Configure Timesheet" page of type "Sub"
    And Click on save button
    Then Verify and accept success popup
    Then Logout from MIS

  #--------------------------------------------Create Timesheet--------------------------------------------#

  @Test @TC05 @TimeSheet @CreateTimesheet
  Scenario: Verify the table heads and table data
  #MIS_TimeSheet_CreateTimesheet_verifyTable
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Verify table for create Timesheet page
    Then Logout from MIS

  @Test @TC06 @TimeSheet @CreateTimesheet
  Scenario: Verify timesheet status
  #MIS_TimeSheet_CreateTimesheet_verifyTimesheetStatus
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Verify timesheet status
    Then Logout from MIS

  @Test @TC07 @TimeSheet @CreateTimesheet
  Scenario: Open previous and next week timesheet
  #MIS_TimeSheet_CreateTimesheet_openPreviousAndNextWeek
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Open previous and next week
    Then Verify and accept warning popup
    Then Logout from MIS

  @Test @TC08 @TimeSheet @CreateTimesheet
  Scenario Outline: Copy timesheet from a week
  #MIS_TimeSheet_CreateTimesheet_copyFromWeek
    Then Open "Create Timesheet" page of "TimeSheet" module
    And Verify and accept please note popup
    And Verify "Create Timesheet" page of type "Sub"
    And Copy timesheet from week "<week>" of year "<year>"
    Then Logout from MIS
    Examples:
      | week | year |
      |      |      |
      |      | 2022 |

  #-------------------------------------------Manage Task Template------------------------------------------#

  @Test @TC09 @TimeSheet @ManageTaskTemplate
  Scenario: Verify the table heads and table data
  #MIS_TimeSheet_ManageTaskTemplate_verifyTable
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Verify table for manage task template page
    Then Logout from MIS

  @Test @TC10 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Search a text using search box
  #MIS_TimeSheet_ManageTaskTemplate_searchText
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new valid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    And Perform invalid search for "<InvalidText>" using search box when records are displayed
    And Perform valid search for "<ValidText>" using search box when records are displayed
    Then Logout from MIS
    Examples:
      | Name | Description   | Team |   Task   | InvalidText | ValidText |
      | abc  |   123@##      |  QA  | Learning |    mnop     |    abc    |
      | XYZ  |   /;[=[++     |  QA  | Testing  |    @#$%     |  /;[=[++  |
      | pqr  |   batman      |  QA  | Reporting|    1234     |    QA     |

  @Test @TC11 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Add an invalid task template
  #MIS_TimeSheet_ManageTaskTemplate_AddInvalidTemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new invalid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    Then Logout from MIS
    Examples:
      | Name | Description   | Team |   Task   |
      |      |               |      |          |
      | abcd |               |      |          |
      |      | FirstTemplate |      |          |
      |      |               |  QA  |          |
      | abcd | FirstTemplate |      |          |
      | abcd | FirstTemplate |  QA  |          |

  @Test @TC12 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Delete and Add a valid task template
  #MIS_TimeSheet_ManageTaskTemplate_delAndAddValidTemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new valid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    Then Logout from MIS
    Examples:
      | Name | Description   | Team |   Task   |
      | abcd | FirstTemplate |  QA  | Learning |

  @Test @TC13 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Add a duplicate task template
  #MIS_TimeSheet_ManageTaskTemplate_AddDuplicateTemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new valid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    And Add a new duplicate task template with "<Name>" "<Description>" "<Team>" "<Task>"
    Then Logout from MIS
    Examples:
      | Name | Description | Team |   Task    |
      | TUV  | Automation  | FES  | Debugging |

  @Test @TC14 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Edit an existing task template
  #MIS_TimeSheet_ManageTaskTemplate_editATemplate
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new valid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    And Edit a task template "<Name>" with "<EName>" "<EDescription>" "<ETeam>" "<ETask>"
    Then Logout from MIS
    Examples:
      | Name | Description |  Team  |   Task    | EName | EDescription | ETeam |   ETask   |
      | Lmno |    njuik    | Gemini | Reporting |       |              |       |           |
      | Lmno |    njuik    | Gemini | Reporting | wxyz  |              |       |           |
      | Lmno |    njuik    | Gemini | Reporting |       |  MyTemplate  |       |           |
      | Lmno |    njuik    | Gemini | Reporting |       |              |  FES  |           |
      | Lmno |    njuik    | Gemini | Reporting |       |              |       |  Learning |
      | Lmno |    njuik    | Gemini | Reporting | wxyz  |  MyTemplate  |       |           |
      | Lmno |    njuik    | Gemini | Reporting | wxyz  |  MyTemplate  |  FES  |           |
      | Lmno |    njuik    | Gemini | Reporting | wxyz  |  MyTemplate  |  FES  |  Testing  |

  @Test @TC15 @TimeSheet @ManageTaskTemplate
  Scenario Outline: Verify rejecting a delete action for a task template
  #MIS_TimeSheet_ManageTaskTemplate_deleteATemplate_reject
    Then Open "Manage Task Template" page of "TimeSheet" module
    And Verify "Manage Task Template" page of type "Sub"
    And Add a new valid task template with "<Name>" "<Description>" "<Team>" "<Task>"
    And Click on Delete button for a task template "<Name>"
    Then Verify and reject confirmation popup
    Then Logout from MIS
    Examples:
      | Name | Description | Team |    Task     |
      | del  |    Test     |  ETL | Development |