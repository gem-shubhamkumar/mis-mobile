@KnowledgeBaseTest
Feature: Automation of Knowledge Base menu and View Document Submenu in MIS Dashboard


  Background:
    Given Verify beta-mis is open and loaded successfully.
    When User logins into application with username "arpit.mishra" and password "Gemini@1234"
    Then Verify Dashboard page opens


    @Test1
  Scenario Outline: On Knowledge Base navigate to view documents and verify add New Documents Tag Icon Present and functional
    When Goto "<menuItem>" and click on "<subMenuItem>"
    Then click on "<targetElement>"
    And click on "<cross>" button
    Then verify no records added in the grid
    Then click on "<targetElement>"
    And click on "<close>" button
    Then verify no records added in the grid
    Then click on "<targetElement>"
    And click on "<addButton>" without entry
    Then click on ok button on warning popup
    Then verify no records added in the grid


    Examples:
    |menuItem|subMenuItem|targetElement|addButton|close|cross|
    |knowledge base|view document|add New Document|addButton|closeButton|crossIcon|


  @Test2
  Scenario Outline:  On Knowledge Base add new document and check how these working
    When Goto "<menuItem>" and click on "<subMenuItem>"
    Then click on "<targetElement>"
    And enter "<validTagName>" tag name and click on "<addButton>"
    Then click ok on the popup
    Then click on "<targetElement>"
    And enter "<validTagName>" tag name click and click on "<crossButton>"
    Then click on "<targetElement>"
    And enter "<validTagName>" tag name click and click on "<closeButton>"
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" and click on "<addButton>"
    And click ok on the popup
    And click on "<closeButton>" button
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" and click on "<crossButton>"
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" and click on "<closeButton>"

    Examples:
    |menuItem|subMenuItem|targetElement|validTagName|addButton|crossButton|invalidTagName|closeButton|
    |knowledge base|view document|add New Document|TagName1|addButton|crossButton|*&^*^^%^%*|closeButton|



    Scenario Outline:click on checking the functionality of adding folder
      When Goto "<menuItem>" and click on "<subMenuItem>"
      Then click on "<targetElement>"
      And click on "<crossButton>"
      Then click on "<targetElement>"
      And Put "<InvalidFolderName>"
      Examples:
        |menuItem|subMenuItem|targetElement|crossButton|
        |knowledge base|view document|AddNewFolder|crossButton|