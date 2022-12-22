@TagAll
Feature: Feedback

  Background:
    Given User logins into MIS Beta application with username "ayush.garg" and password "Gemini@123"

@tag1
  Scenario: Open Submit Feedback Page
    When User Clicks on "Submit Feedback" tab of "Feedback" tab
    Then Verify Submit Feedback tab opens

@tag2
  Scenario Outline: Submit a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    Then Click on "next" button for pagination
    And Verify data "<data>" is added in "<parentTab>" tab

    Examples:
    |childTab| parentTab| data |
    | Submit Feedback | Feedback | Feedback |

@tag3
  Scenario Outline: Submit a Blank Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Verify "<childTab>" input select has error


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | |

@tag4
  Scenario Outline: Verify Page Navigation
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "next" button for pagination


    Examples:
      |childTab| parentTab|
      | Submit Feedback | Feedback |


@tag5
  Scenario Outline: Valid Search a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    Then Click on "next" button for pagination
    And Verify data "<data>" is added in "<parentTab>" tab
    When User searches the "<data>" in search field
    Then "<data>" data should appear in "<parentTab>" tab


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |


@tag6
  Scenario Outline: Invalid Search a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    Then Click on "next" button for pagination
    And Verify data "<data>" is added in "<parentTab>" tab
    When User searches the "<wrongData>" in search field
    Then Data should not appear in "<parentTab>" tab


    Examples:
      |childTab| parentTab| data | wrongData |
      | Submit Feedback | Feedback | Random Data | wrong |

@tag7
  Scenario Outline: Verify number of rows data
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    When User selects "<number>" of rows to show for "<parentTab>" tab
    Then Verify total rows are <number>


    Examples:
      |childTab| parentTab| data | number |
      | Submit Feedback | Feedback | Random Data | 25 |
@tag8
  Scenario Outline: Sort the Feedback column
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    When User clicks on Feedback row
    Then Verify data is in "descending" order
    When User clicks on Feedback row
    Then Verify data is in "ascending" order


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |
@tag9
  Scenario Outline: View a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    Then Click on "next" button for pagination
    When User hovers over last View Action button
    Then Verify the "View" tooltip text
    Then Click on View button
    Then "View Feedback" Modal open
    Then Verify message "<data>" is present



    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |

@tag10
  Scenario Outline: Export Data
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on Provide Feedback button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And User should click on "Submit" button
    Then Validate "Success" Message
    Then Click on Export Options "Export" button
    And Verify export options open
    Then Click on Export Options "Excel" button
    And Verify Feedback "All Feedback List.xlsx" file is downloaded
    Then Click on Export Options "PDF" button
    And Verify Feedback "All Feedback List.pdf" file is downloaded
    Then Click on Export Options "Print" button
    And Verify print tab is open
    Then Click on Export Options "Copy" button
    And Verify data is copied



    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |









