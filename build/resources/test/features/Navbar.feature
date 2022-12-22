@MISAutomation
Feature: NavBar

  Background:
    Given User has login to myMIS beta

  Scenario: Verify user redirect to landing page when clicking on Gemini logo
    Then Verify navigation to landing page is successful after log in
    Then Click on "Employee Directory" parent tab
    And Verify "Employee directory table" is present on the current page
    When Click on "Gemini logo"
    Then Verify user is redirected to landing page

  Scenario: Verify toggle button on dashboard page
    Then Verify navigation to landing page is successful after log in
    And Verify "Side navigation bar" is present on the current page
    Then Click on "Menu button"
    And Verify "Side navigation bar" disappears form current screen
    Then Click on "Menu button"
    And Verify "Side navigation bar" is present on the current page

  Scenario: Click on Change AD Password and verify  new tab is open
    Then Verify navigation to landing page is successful after log in
    Then Click on "Change AD password button"
    But Verify new tab is open "RD Web Access" as page heading

  Scenario: Click on profile menu and verify all items are present
    Then Verify navigation to landing page is successful after log in
    Then Open profile menu list from top right on navbar
    And Verify all menu items are present in the dropdown

  Scenario Outline: Verify Add skill close button after entering all values
    Then Click on "Profile button"
    Then Select "Skills" from dropdown menu list
    And Verify "Add skills window" is visible on the current screen
    Then Select "<Technology name>" from technology dropdown on add skills window
    Then Select "Beginner" from "Proficiency" dropdown on add skills window
    Then Select "Primary" from "Skill type" dropdown on add skills window
    And Enter "6" in "Experience" text field
    And Click on "Add skill close button"
    Then Verify skill card window is closed
    Examples:
      | Technology name |
      |    JAVA         |

  Scenario: Verify Add skill close button after entering all values
    Then Open profile menu list from top right on navbar
    Then Select "Skills" from dropdown menu list
    And Verify "Add skills window" is visible on the current screen
    And Click on "Add skill close button"
    Then Verify skill card window is closed

  Scenario Outline: Verify success/warning message box when adding new/duplicate skills from profile dropdown
    Then Open profile menu list from top right on navbar
    Then Select "Skills" from dropdown menu list
    And Verify "Add skills window" is visible on the current screen
    Then Select "<Technology name>" from technology dropdown on add skills window
    Then Select "Beginner" from "Proficiency" dropdown on add skills window
    Then Select "Primary" from "Skill type" dropdown on add skills window
    And Enter "6" in "Experience" text field
    And Click on "Save button"
    Then Verify "<Message box text>" message appear in screen
    And Verify "<Skill name>" Skill  is "<status>" and "<expected condition>" added in my skills card
    Examples:
      | Technology name |Message box text| Skill name  |  status    |expected condition|
      |Windows Clustering      |Success         | Windows Clustering     |    new     | can be   |
      |Manual Testing      |Duplicate       | Manual Testing   |   duplicate|cannot be         |

  Scenario Outline: Verify Experience text field on Add new skills window
    Then Open profile menu list from top right on navbar
    Then Select "Skills" from dropdown menu list
    And Verify "Add skills window" is visible on the current screen
    Then Select "<Technology name>" from technology dropdown on add skills window
    Then Select "Beginner" from "Proficiency" dropdown on add skills window
    Then Select "Primary" from "Skill type" dropdown on add skills window
    And Enter "<Experience in months>" in "Experience" text field
    And Click on "Save button"
    Then Verify Experience text field does not accepts invalid values like "<Experience in months>"
    Examples:
      | Experience in months |Technology name|
      |     |Photoshop                       |
      | www |Photoshop                       |

  Scenario: Logout to MIS portal
    Then Open profile menu list from top right on navbar
    Then Select "Logout" from dropdown menu list
    And Verify user is logged off and redirected to login page

  Scenario: Verify cards are added on dashboard when updating from dashboard setting
    Then Open profile menu list from top right on navbar
    Then Select "Dashboard Settings" from dropdown menu list
    And Verify "Dashboard setting table" is visible on the current screen
    Then Verify all check boxes are uncheck
    And Click on "Update button"
    And Verify no card is shown on the dashboard
    
   Scenario: Verify all cards re appear when checked from dashboard setting
    Then Open profile menu list from top right on navbar
    Then Select "Dashboard Settings" from dropdown menu list
    And Verify "Dashboard setting table" is visible on the current screen
    Then Check all text box
    And Click on "Update button"
    And Verify all cards are visible on the dashboard
