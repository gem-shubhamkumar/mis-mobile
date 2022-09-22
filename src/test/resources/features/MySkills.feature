Feature: My Skills in Dashboard

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User enters username "ayush.garg" and password "Gemini@1234"
    And Clicks "Sign In" Button
    Then Verify Dashboard page opens

  Scenario Outline: Verify My Skills are updating with Valid Data
    When "<Card>" card is present in dashboard
    Then Verify card is not empty
    When User clicks on "<skill>" skill in My Skill card
    Then Manage Skills Modal open
    When User selects Proficiency Level "<level>"
    And User selects Skill Type "<type>"
    And User enters experience "<experience>"
    Then Click on "update" button
    Then Click OK on Success pop-up
    And Verify skill "<skill>" is updated for type "<type>" and experience "<experience>"


    Examples:
    | Card | level | type | experience | skill |
    | My Skills |  Beginner | Secondary | 5 | JAVA |



  Scenario Outline: mis_dashboard_MySkills_update_skills_invalid_data
    When "<Card>" card is present in dashboard
    Then Verify card is not empty
    When User clicks on "<skill>" skill in My Skill card
    Then Manage Skills Modal open
    When User selects Proficiency Level "<level>"
    And User selects Skill Type "<type>"
    And User enters experience "<experience>"
    Then Click on "update" button
    Then Verify "<inputBox>" input select has error



    Examples:
      | Card | level | type | experience | skill | inputBox |
      | My Skills |  Beginner | Select | 5 | JAVA | skill   |
      | My Skills |  Beginner | Secondary | experience | JAVA | experience |
      | My Skills |  Beginner | Secondary | | JAVA | experience |
      | My Skills |  Beginner | Secondary | 1000 | JAVA | experience |



  Scenario: mis_dashboard_MySkills_minimize_card
    When "My Skills" card is present in dashboard
    Then User clicks on "Minimize" button on "My Skills" card
    And Verify that "My Skills" card is minimized

  Scenario: mis_dashboard_MySkills_maximize_card
    When "My Skills" card is present in dashboard
    Then User clicks on "Maximize" button on "My Skills" card
    And Verify that "My Skills" card is maximized




