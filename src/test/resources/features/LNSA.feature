Feature: LNSA

  Background:
    Given User logins into MIS Beta application with username "jasleen.multani" and password "Gemini@123"

  Scenario: Open Apply LNSA Tab
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens

    @Test12
  Scenario: Move to previous date
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
      And User should click on "previous date" button
    Then Verify previous date data is populated


  Scenario: Move to next date
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And User should click on "previous date" button
    And User should click on "next date" button
    Then Verify next date data is populated


  Scenario: Select Week Checkbox
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And Click on week checkbox
    Then Verify week is active

  Scenario: Submit LNSA without selecting date
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And User should click on "Submit" button
    Then Validate "Warning" Message


  @tags
  Scenario: Cancel Submit Window
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And Click on week checkbox
    Then Verify week is active
    And User should click on "Submit" button
    Then Click on Close button

  @tags
  Scenario: Submit Blank LNSA
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And Click on week checkbox
    Then Verify week is active
    And User should click on "Submit" button
    And User should click on "Submit Reason" button
    Then Verify "Reason" input select has error

  @tags
  Scenario: Submit Valid LNSA
    When User Clicks on "Apply LNSA" tab of "LNSA" tab
    Then Verify Apply LNSA tab opens
    And Click on week checkbox
    Then Verify week is active
    And User should click on "Submit" button
    When User enters reason "reason"
    And User should click on "Submit Reason" button
    Then Validate "Success" Message



  Scenario: Open View Request status Tab
    When User Clicks on "View Request Status" tab of "LNSA" tab
    Then Verify View Request Status tab opens


  Scenario: Export Data
    When User Clicks on "View Request Status" tab of "LNSA" tab
    Then Verify View Request Status tab opens
    Then Click on Export Options "Export" button
    And Verify export options open
    Then Click on Export Options "Excel" button
    And Verify "All Lnsa Request List.xlsx" file is downloaded
    Then Click on Export Options "PDF" button
    And Verify "All Lnsa Request List.pdf" file is downloaded
    Then Click on Export Options "Copy" button
    And Verify data is copied
    Then Click on Export Options "Print" button
    And Verify print tab is open

  Scenario: Verify number of rows data
    When User Clicks on "View Request Status" tab of "LNSA" tab
    Then Verify View Request Status tab opens
    When User selects "25" of rows to show for "LNSA" tab
    Then Verify total rows are 25


  Scenario Outline: Valid Search a LNSA Request
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify View Request Status tab opens
    When User searches the "<data>" in search field
    Then "<data>" data should appear in "<parentTab>" tab


    Examples:
      |childTab| parentTab| data |
      | View Request Status | LNSA | reason |


  Scenario Outline: Invalid Search a LNSA Request
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify View Request Status tab opens
    When User searches the "<data>" in search field
    Then Data should not appear in "<parentTab>" tab



    Examples:
      |childTab| parentTab| data |
      | View Request Status | LNSA | qqqqqqq |


  Scenario: Sort the LNSA columns
    When User Clicks on "View Request Status" tab of "LNSA" tab
    Then Verify View Request Status tab opens
    When User clicks on "From Date" row
    Then Verify "From Date" row is in "descending" order
    When User clicks on "From Date" row
    Then Verify "From Date" row is in "ascending" order
    When User clicks on "Till Date" row
    Then Verify "Till Date" row is in "descending" order
    When User clicks on "Till Date" row
    Then Verify "Till Date" row is in "ascending" order
    When User clicks on "No of Days" row
    Then Verify "No of Days" row is in "descending" order
    When User clicks on "No of Days" row
    Then Verify "No of Days" row is in "ascending" order
    When User clicks on "Reason" row
    Then Verify "Reason" row is in "descending" order
    When User clicks on "Reason" row
    Then Verify "Reason" row is in "ascending" order
    When User clicks on "Status" row
    Then Verify "Status" row is in "descending" order
    When User clicks on "Status" row
    Then Verify "Status" row is in "ascending" order
    When User clicks on "Requested On" row
    Then Verify "Requested On" row is in "descending" order
    When User clicks on "Requested On" row
    Then Verify "Requested On" row is in "ascending" order
    When User clicks on "Action" row
    Then Verify "Action" row is in "descending" order
    When User clicks on "Action" row
    Then Verify "Action" row is in "ascending" order


  Scenario: View Status
    When User Clicks on "View Request Status" tab of "LNSA" tab
    Then Verify View Request Status tab opens
    When Click on status button
    Then "Remarks" Modal open









