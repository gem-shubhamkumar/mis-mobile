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
    Then Click OK on Success pop-up
    Then Click on "Next" button
    And Verify feedback data "<data>" is added

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
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Verify "<childTab>" input select has error


    Examples:
      |childTab| parentTab| data |
      | Submit Feedback | Feedback | |



  Scenario Outline: Valid Search a Feedback
    When User Clicks on "<childTab>" tab of "<parentTab>" tab
    Then Verify Submit Feedback tab opens
    Then Click on "Provide Feedback" button
    And "<childTab>" Modal open
    When User enters feedback "<data>"
    And Click on "Submit" button
    Then Click OK on Success pop-up
    Then Click on "next" button
    And Verify feedback data "<data>" is added
    When User searches the feedback "<data>" in search field
    Then "<data>" data should appear


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
    Then Click OK on Success pop-up
    Then Click on "next" button
    And Verify feedback data "<data>" is added
    When User searches the feedback "<wrongData>" in search field
    Then Data should not appear


    Examples:
      |childTab| parentTab| data | wrongData |
      | Submit Feedback | Feedback | Random Data | wrong |






