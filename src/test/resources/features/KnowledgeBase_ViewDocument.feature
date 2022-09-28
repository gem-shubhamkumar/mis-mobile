@KnowledgeBaseTest
Feature: Automation of  View Document and view shared document Submenu in knowledge base menu in MIS Dashboard


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
    Then click ok on the popup in add new tag
    Then click on "<targetElement>"
    And enter "<validTagName>" tag name and click on "<crossButton>"
    Then click on "<targetElement>"
    And enter "<validTagName>" tag name and click on "<closeButton>"
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" tag name and click on "<addButton>"
    And click ok on the popup in add new tag
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" tag name and click on "<crossButton>"
    Then click on "<targetElement>"
    Then enter "<invalidTagName>" tag name and click on "<closeButton>"

    Examples:
    |menuItem|subMenuItem|targetElement|validTagName|addButton|crossButton|invalidTagName|closeButton|
    |knowledge base|view document|add New Document|TagName25|addButton|crossIcon|*&^*^^%^%&^*|closeButton|


    @Test3
    Scenario Outline:click on checking the functionality of adding folder
      When Goto "<menuItem>" and click on "<subMenuItem>"
      Then click on "<targetElement>"
      And click on "<crossButton>" button
      Then click on "<targetElement>"
      And Put "<InvalidFolderName>" and click on "<crossButton>"
      And Put "<InvalidFolderName>" and click on "<addButton>"
      Then click ok on the popup in add Folder
      Then verify folder added

      Examples:
        |menuItem|subMenuItem|targetElement|crossButton|InvalidFolderName|addButton|
        |knowledge base|view document|AddNewFolder|crossIconOnFolderName|*&*ArFolderNamjbnabe|folderNameSaveButton|

    @Test4
    Scenario Outline: Knowledge base view documents add new folder testcase to check folder functionality
      When Goto "<menuItem>" and click on "<subMenuItem>"
      Then click on "<targetElement>"
      And click on "<crossButton>" button
      Then click on "<targetElement>"
      And click on "<closeButton>" button
      Then click on "<targetElement>"
      And create folder without name and click "<addButton>"
      And click on ok button from success window
      Then verify folder added
      Then  click on "<targetElement>"
      And click on "<crossButton>" button
      Then  click on "<targetElement>"
      And click on "<closeButton>" button

      Examples:
        |menuItem|subMenuItem|targetElement|crossButton|closeButton|addButton|
        |knowledge base|view document|AddNewFolder|crossIconOnFolderName|folderNameCloseButton|folderNameSaveButton|

     @Test5
    Scenario Outline:check folder functionality add folder without name
      When Goto "<menuItem>" and click on "<subMenuItem>"
       Then click on "<targetElement>"
       And click on "<closeButton>" button
      Then click on "<targetElement>"
      And click on "<crossButton>" button
      Then click on "<targetElement>"
      And create folder without name and click "<addButton>"


      Examples:
        |menuItem|subMenuItem|targetElement|crossButton|closeButton|addButton|
        |knowledge base|view document|AddNewFolder|crossIconOnFolderName|folderNameCloseButton|folderNameSaveButton|

  @Test6
  Scenario Outline: Check duplicate folder functionality by adding one duplicate folder
      When Goto "<menuItem>" and click on "<subMenuItem>"
      Then click on "<targetElement>"
      And Put "<validFolderName>" and click on "<addButton>"
      Then click on "<targetElement>"
      And Put "<duplicateFolderName>" and click on "<addButton>"
      Then verify duplicate folder created
      Then click on "<targetElement>"
      Then create folder without name and click "<addButton>"
      And verify folder added
      Then click on "<targetElement>"
      And Put "<folderName>" and click on "<closeButton>"

      Examples:
        |menuItem|subMenuItem|targetElement|noName|closeButton|addButton|validFolderName|duplicateFolderName|folderName|
        |knowledge base|view document|AddNewFolder| |closeButton|addButton|validFolderName|validFolderName|folderName123|

    @Test7
    Scenario Outline: check right click working
      When Goto "<menuItem>" and click on "<subMenuItem>"
      Then right click on "<targetElement>"
      And verify menu opens
      Examples:
        |menuItem|subMenuItem|targetElement|noName|closeButton|addButton|validFolderName|duplicateFolderName|folderName|
        |knowledge base|view document|newFolder||closeButton|addButton|validFolderName|validFolderName|folderName123|

  @Test8
  Scenario Outline: check right click functionality
    When Goto "<menuItem>" and click on "<subMenuItem>"
    Then right click on "<targetElement>"
    And verify menu opens
    Then click on "<addSubFolders>" from the menu
    Then click on "<crossButton>" at input folder name place
    Then click on "<addSubFolders>" from the menu
    Then click on "<closeButton>" at input folder name place


    Examples:
      |menuItem|subMenuItem|targetElement|noName|closeButton|addButton|validFolderName|duplicateFolderName|crossButton|
      |knowledge base|view document|newFolder||closeButton|addButton|validFolderName|validFolderName|crossButton|



   Scenario Outline: Check functionality of view documents number of rows from dropdown
     When Goto "knowledge base" and click on "view document"

     Examples:
       |menuItem|subMenuItem|targetElement|noName|closeButton|addButton|validFolderName|duplicateFolderName|crossButton|
       |knowledge base|view document|AddNewFolder||closeButton|addButton|validFolderName|validFolderName|crossButton|




  @Test16
  Scenario: check refresh button in view documents tab
    When Goto "knowledge base" and click on "view document"
    Then click on refresh icon

  @Test17
  Scenario: check number of rows dropdown working or not
    When Goto "knowledge base" and click on "view document"
    Then click on "dropdown"
    And select some number from dropdown
    Then verify the change in grid




  @Test18192021
    Scenario Outline: verify search bar functionality on view documents page
    When Goto "knowledge base" and click on "view document"
    Then click on view documents search bar and input "<testString>"
    And verify record availability after input in search bar

    Examples:
      |testString|
      |perl|
      |perl123|
      |***|
      |   |




  @Test2223
   Scenario Outline: Check navigation on view document page
     When Goto "<menuItem>" and click on "<subMenuItem>"
     Then click on "<next>" button
     And verify this is the last page
     Then verify no records added in the grid
     Examples:
       |menuItem|subMenuItem|next|
       |knowledge base|view document|nextButton|
       |knowledge base|view document|prevButton|

   @Test2425
   Scenario Outline: verify clicks of previous button and next page button on first page.
     When Goto "<menuItem>" and click on "<subMenuItem>"
     Then click on "<next>" button
     And verify user not navigated
     Then verify no records added in the grid
     Examples:
       |menuItem|subMenuItem|next|
       |knowledge base|view document|nextButton|
       |knowledge base|view document|prevButton|

  @Test26
  Scenario: goto View shared documents and verify view functionality
    When Goto "knowledge base" and click on "view shared Document"
    Then click on "eye" button
    And verify that a popup window is displayed
    Then Verify document is scrollable and not empty

  @Test27
  Scenario: check the sorting functionality in view shared documents
    When Goto "knowledge base" and click on "view shared Document"
    Then click on the sorting icon
    And Verify that "eye" button is hidden
    Then click on the sorting icon
    And verify that "eye" button is visible

  @Test28
 Scenario: check the dropdown on view shared documents select rows
    When Goto "knowledge base" and click on "view shared Document"
    Then click on Number from dropdown on view shared documents page
    And verify number of rows present


  @Test29303132
  Scenario Outline: check search bar functionality in view shared documents
    When Goto "knowledge base" and click on "view shared Document"
    Then click on search bar and input "<testString>"
    And verify record availability on the basis of "<testString>"
    Examples:
      |testString|
      |perl|
      |perl123|
      |***|
      |   |

  @Test33
  Scenario: check next button functionality at last page in view shared documents
    When Goto "knowledge base" and click on "view shared Document"
    Then Goto last page by clicking next
    And verify this is last page in view shared documents

  @Test32
  Scenario: check previous button working while not on first page
    When Goto "knowledge base" and click on "view shared Document"
    Then click on "nextButton" in lower right corner
    Then click on "nextButton" in lower right corner
    Then click on "prevButton" in lower right corner
    Then click on "prevButton" in lower right corner
    And verify user is on first Page

  @Test3435
  Scenario Outline: check the navigation buttons are working on view shared documents
    When Goto "knowledge base" and click on "view shared Document"
    Then click on "<navButton>" in lower right corner
    And check change in entries text according to the "<navButton>"
    Examples:
    |navButton|
    |nextButton|
    |prevButton|







