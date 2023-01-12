Feature: MIS Dashboard MySkills

  Background:
    Given User logins into MIS Beta application with username "ayush.garg" and password "Gemini@123"


  Scenario Outline: Verify My Skills are updating with Valid Data
    When "<Card>" card is present in dashboard
    Then Verify card is not empty
    When User clicks on "<skill>" skill in My Skill card
    Then "Manage Skills" Modal open
    When User selects Proficiency Level "<level>"
    And User selects Skill Type "<type>"
    And User enters experience "<experience>"
    Then Click on update button
    And Verify skill "<skill>" is updated for type "<type>" and experience "<experience>"


    Examples:
    | Card | level | type | experience | skill |
    | My Skills |  Beginner | Secondary | 5 | JAVA |



  Scenario Outline: Verify My Skills are not updating with InValid Data
    When "<Card>" card is present in dashboard
    Then Verify card is not empty
    When User clicks on "<skill>" skill in My Skill card
    Then "Manage Skills" Modal open
    When User selects Proficiency Level "<level>"
    And User selects Skill Type "<type>"
    And User enters experience "<experience>"
    Then Click on update button
    Then Verify "<inputBox>" input select has error



    Examples:
      | Card | level | type | experience | skill | inputBox |
      | My Skills |  Beginner | Select | 5 | JAVA | skill   |
      | My Skills |  Beginner | Secondary | experience | JAVA | experience |
      | My Skills |  Beginner | Secondary | | JAVA | experience |







