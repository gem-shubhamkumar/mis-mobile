@AddGoalsAppraisalManagement
Feature: Automation of appraisal management screen in beta mis

  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@1234"
    Then Verify Dashboard page opens


  Scenario: Navigate to add goal page and verify Add goal window
    Then Click "Add Goals" sub-tab inside "Appraisal Management" tab
    Then Click on "Add/Update goal button"
    And Verify Add goal window opens
    Then Click on "Close add goal button"
    And Verify add goal window is closed

  Scenario: Verify financial year dropdown
    Then Click "Add Goals" sub-tab inside "Appraisal Management" tab
    And Verify "Add My Goal/Team Goal" text is present on the current page
    Then Click on "Financial year dropdown"
    And Verify all elements are available in dropdown
    Then Choose current financial year
    And Verify "Add My Goal/Team Goal" text is present on the current page


  Scenario: Verify link for list of KRAs and KPIs
    Then Click "Add Goals" sub-tab inside "Appraisal Management" tab
    And Verify "Add My Goal/Team Goal" text is present on the current page
    Then Click on "List of KRAs and KPIs link"
    Then Verify link is open on the same tab


  Scenario: Add new KPI/KRA mapping in add goal window and validate add KPI button
    Then Click "Add Goals" sub-tab inside "Appraisal Management" tab
    And Verify "Add My Goal/Team Goal" text is present on the current page
    Then Click on "Financial year dropdown"
    And Verify all elements are available in dropdown
    Then Choose current financial year
    And Verify "Add My Goal/Team Goal" text is present on the current page
    When Click on "Add KPI/KRA button"
    Then Select "Creative" from Goal type dropdown
    Then Enter "KRADemo" in "KRA" text field
    When Click on "Add KPI button"
    Then Verify "Add KPI description text field" is visible on the current screen
    Then Enter "Demo" in "KPI description" text field
    And Click on "Submit add button"


  Scenario: Verify warning popup appears when KPI/KRA fields are left empty
    Then Click "Add Goals" sub-tab inside "Appraisal Management" tab
    And Verify "Add My Goal/Team Goal" text is present on the current page
    Then Click on "Financial year dropdown"
    And Verify all elements are available in dropdown
    Then Choose current financial year
    And Verify "Add My Goal/Team Goal" text is present on the current page
    When Click on "Add KPI/KRA button"
    Then Select "Creative" from Goal type dropdown
    Then Enter "KRADemo" in "KRA" text field
    And Click on "Submit add button"
    Then Verify Warning popup appear which says "No KPI's have been added."
    When Click on "Add KPI button"
    Then Verify "Add KPI description text field" is visible on the current screen
    Then Enter "Demo" in "KPI description" text field
    And Click on "Submit add button"
    Then Verify Success pop appears which says "KPI's are added successfully!"

    Scenario: Verify adding data in each field
      When Click "Add Goals" sub-tab inside "Appraisal Management" tab
      Then Verify Add Goals tab opens
      Then User clicks on "add goals" button
      And User selects "Defect Rate - x%" in KPI
      And enters "Active Project" value in project
      And enters "Active Goal Desc" value in goal description
      Then User clicks on "Engineering" nav tab
      And selects "QA" in Primary Skill
     Then User clicks on "Behavioural" nav tab
      Then Fill a field in "Behavioural" tag
     Then User clicks on "Creative" nav tab
      Then Fill a field in "Creative" tag
      Then User clicks on "draft" button
      Then Verify "Success" Message
      Then User clicks on "close" button


    Scenario: Verify Add/Delete of new KPI Row
      When Click "Add Goals" sub-tab inside "Appraisal Management" tab
      Then Verify Add Goals tab opens
      Then User clicks on "add goals" button
      Then User clicks on "Engineering" nav tab
      Then click on "Add" option in add new KPI row
      And verify KPI row added
      Then click on "Delete" option in add new KPI row
      And verify KPI row removed

        Scenario: Verify entry counts
        When Click "Add Goals" sub-tab inside "Appraisal Management" tab
        Then Verify Add Goals tab opens
        Then Select "25" from the rows dropdown
        And verify number of rows from lower left

        Scenario: Verify page navigation
        When Click "Add Goals" sub-tab inside "Appraisal Management" tab
        Then Verify Add Goals tab opens
        Then verify number of pages in lower right corner
        Then click on next to check navigation and verify


  Scenario: verify export button functionality
    When Click "Add Goals" sub-tab inside "Appraisal Management" tab
    Then Verify Add Goals tab opens
    And  Click on "export in add goals"
    Then verify "Copy" option clickable and present
    Then verify "PDF" option clickable and present
    Then verify "Excel" option clickable and present
    Then verify "Print" option clickable and present

  @TestColSorting
  Scenario: verify column sorting working or not
    When Click "Add Goals" sub-tab inside "Appraisal Management" tab
    Then Verify Add Goals tab opens
    And click on sorting button on first
    Then verify sorting performed

  Scenario Outline: Verify searches
    When Click "Add Goals" sub-tab inside "Appraisal Management" tab
    Then Verify Add Goals tab opens
    Then User clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "<projName>" value in project
    And enters "<goalDesc>" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User clicks on "draft" button
    Then Verify "Success" Message
    Then User clicks on "close" button
    Then search "<searchQuery>" in search input
    And verify "<searchQuery>" in the search results


    Examples:
    |projName|goalDesc|searchQuery|
    |Active Project|Active Goal|Active Project|
    |Active Project|Active Goal|****|

    @DeleteWithouRemark
  Scenario: check delete with remark and without remark
   When Click "Add Goals" sub-tab inside "Appraisal Management" tab
   Then Verify Add Goals tab opens
   Then User clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
   And enters "Active Project" value in project
   And enters "Active Goal" value in goal description
   Then User clicks on "Engineering" nav tab
   And selects "QA" in Primary Skill
   Then User clicks on "draft" button
   Then Verify "Success" Message
   Then User clicks on "close" button
   And verify "Active Project" and "Active Goal" present
   Then User clicks on "delete" button
   And clicks on submit button "without remark"
   Then verify error in submission
   And clicks on submit button "with some remark"
   Then verify submitted successfully


   @SubmitGoals
  Scenario: Submit Goals
    When Click "Add Goals" sub-tab inside "Appraisal Management" tab
    Then Verify Add Goals tab opens
    Then User clicks on "add goals" button
    And User selects "Defect Rate - x%" in KPI
    And enters "project123" value in project
    And enters "goal123" value in goal description
    Then User clicks on "Engineering" nav tab
    And selects "QA" in Primary Skill
    Then User clicks on "draft" button
    Then Verify "Success" Message
    Then User clicks on "close" button
    Then User clicks on "submit goal" button


  Scenario: click on draft without filling any fields
       When Click "Add Goals" sub-tab inside "Appraisal Management" tab
       Then Verify Add Goals tab opens
       Then User clicks on "add goals" button
       Then User clicks on "Engineering" nav tab
       And selects "Select" in Primary Skill
       Then User clicks on "draft" button
       And verify warning and click ok
       Then User clicks on "Engineering" nav tab
       And selects "QA" in Primary Skill
       Then User clicks on "draft" button
       Then Verify "Success" Message
       Then User clicks on "close" button








