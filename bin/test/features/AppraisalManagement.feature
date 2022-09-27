Feature: Automation of appraisal management screen in beta mis

  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@1234"
    Then Verify Dashboard page opens

  Scenario: Test to check open Add Goals page from appraisal management
    When "Appraisal Management" is present in the dashboard
    Then User clicks on "Appraisal Mangement" dropdown and clicks "Add Goals"
    And Verify page opens with title "Add My Goal/Team Goal" upon clicking "Add Goals"

  Scenario: Test to Select financial Year in add Goals Screen
    When "Appraisal Management" is present in the dashboard
    Then User clicks on "Appraisal Mangement" dropdown and clicks "Add Goals"
    And Verify page opens with title "Add My Goal/Team Goal" upon clicking "Add Goals"
    Then "financial year" dropdown is present
    And Select "current financial year"


  Scenario: Test to verify links of KRAs & KPIs
    When "Appraisal Management" is present in the dashboard
    Then User clicks on "Appraisal Mangement" dropdown and clicks "Add Goals"
    And Verify page opens with title "Add My Goal/Team Goal" upon clicking "Add Goals"
    Then Verify link of "list of KRAs and KPIs" is clickable


  Scenario: Test to check functionality of KRAs and KPIs
    When "Appraisal Management" is present in the dashboard
    Then User clicks on "Appraisal Mangement" dropdown and clicks "Add Goals"
    And Verify page opens with title "Add My Goal/Team Goal" upon clicking "Add Goals"
    Then "financial year" dropdown is present
    And Select "current financial year"
    Then Select "Add new KRA/KPI Mapping"
    And Click on goal type and select an options from goal type dropdown
    Then Click on "KRA Field" and enter some text
    And Click on KPI Button and Add 2 KPI Fields
    Then Verify the KPI Fields added
    And Remove 1 empty KPI Field
    Then Verify empty KPI Removed
    Then Click on "Submit Button" on KPI/KRA
    And Verify KPI Submitted successfully


  Scenario: Test to add goals while leaving input fields empty
    When "Appraisal Management" is present in the dashboard
    Then User clicks on "Appraisal Management" dropdown and clicks "Add Goals"
    And Verify page opens with title "Add My Goal/Team Goal" upon clicking "Add Goals"
    Then "financial year" dropdown is present
    And Select "current financial year"
    Then Select "Add new KRA/KPI Mapping"



