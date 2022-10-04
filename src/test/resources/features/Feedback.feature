Feature: Feedback

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "ayush.garg" and password "Gemini@1234"
    Then Verify Dashboard page opens


  Scenario: Open Submit Feedback Page
    When User Clicks on "Submit Feedback" tab of "Feedback" tab
    Then Verify Submit Feedback tab opens



  Scenario Outline: Submit a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    Then Click on "next" button
    And Verify data "<data>" is added in "<parentTab>" tab

    Examples:
    |childTab| parentTab| data |
    | Submit Feedback | Feedback | Feedback |

  Scenario Outline: Submit a Blank Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "<childTab>" input select has error


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | |


  Scenario Outline: Verify Page Navigation
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "next" button


    Examples:
      |childTab| parentTab|
      | Submit Feedback | Feedback |



  Scenario Outline: Valid Search a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    Then Click on "next" button
    And Verify data "<data>" is added in "<parentTab>" tab
    When User searches the "<data>" in search field
    Then "<data>" data should appear in "<parentTab>" tab


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |



  Scenario Outline: Invalid Search a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    Then Click on "next" button
    And Verify data "<data>" is added in "<parentTab>" tab
    When User searches the "<wrongData>" in search field
    Then Data should not appear in "<parentTab>" tab


    Examples:
      |childTab| parentTab| data | wrongData |
      | Submit Feedback | Feedback | Random Data | wrong |


  Scenario Outline: Verify number of rows data
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    When User selects "<number>" of rows to show for "<parentTab>" tab
    Then Verify total rows are <number>


    Examples:
      |childTab| parentTab| data | number |
      | Submit Feedback | Feedback | Random Data | 25 |

  Scenario Outline: Sort the Feedback column
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    When User clicks on Feedback row
    Then Verify data is in "descending" order
    When User clicks on Feedback row
    Then Verify data is in "ascending" order


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |

  Scenario Outline: View a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    Then Click on "next" button
    When User hovers over last View Action button
    Then Verify the "View" tooltip text
    Then Click on "View" button
    Then "View Feedback" Modal open
#    Then Verify message "<data>" is present



    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |


  Scenario Outline: Export Data
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "Success" Message
    Then Click on "Export" button
    And Verify export options open
    Then Click on "Excel" button
    And Verify "All Feedback List.xlsx" file is downloaded
    Then Click on "PDF" button
    And Verify "All Feedback List.pdf" file is downloaded
    Then Click on "Print" button
    And Verify print tab is open
    Then Click on "Copy" button
    And Verify data is copied



    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | Random Data |









