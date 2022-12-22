Feature: MIS Forms- View Forms scenarios

  Background: User verifies Login Page Elements Before Login
    Given User opens MIS Beta page "https://mymis.geminisolutions.com/"
    Given User enters Username as "charu.srivastava"
    And User enters Password as "Gemini@123"
    Then User clicks on sign in
    And User Verifies Landing Page

 #1
  Scenario Outline: Open View Forms Page

    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies element "<elementOne>"
    And User verifies element "<elementTwo>"
    Then User verifies element "<elementThree>"
    And User closes application
    Examples:
      | parent Tab | child Tab |elementOne|elementTwo|elementThree|
      |Forms       |View Form  |View Forms|Form Name |Action      |

#2
  Scenario Outline: Check presence of Previous and Next Btn
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies element "<elementOne>"
    And User verifies element "<elementTwo>"
    Then User verifies element "<elementThree>"
    And User closes application
    Examples:
      | parent Tab | child Tab | elementOne | elementTwo | elementThree |
      |Forms       |View Form  |Previous    |Next        |1             |

#3
  Scenario Outline: User selects a department
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    And User click on field
    Then User scroll to Element "<elementOne>"
    And User selects the element "<elementTwo>"
    And User closes application
    Examples:
      | parent Tab | child Tab | elementOne | elementTwo |
      |Forms       |View Form  |Quality Assurance|Quality Assurance|

#4
  Scenario Outline: User select number of entries
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User selects number of entries "<element>"
    And User closes application
    Examples:
      | parent Tab | child Tab | element |
      |Forms       |View Form  |25       |

#5
  Scenario Outline: User enters valid value in search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies search field and enters value "<value>"
    Then User verifies element "<element>"
    And User closes application
    Examples:
      | parent Tab | child Tab | value | element |
      |Forms       |View Form  |Rei|Reimbursement Form|

#6
  Scenario Outline: User enters invalid value in search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies search field and enters value "<value>"
    Then User verifies element "<element>"
    And User closes application
    Examples:
      | parent Tab | child Tab | value | element |
      |Forms       |View Form  |hii    |No matching records found|

#7
  Scenario Outline: User clicks on eye button to view policy
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User clicks on eye button and view policy
    And User closes application
    Examples:
      | parent Tab | child Tab |
      |Forms       |View Form  |

#8
  Scenario Outline: User downloads document
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User downloads file and deletes "<fileName>"
    And User closes application
    Examples:
      | parent Tab | child Tab |fileName|
      |Forms       |View Form  |Loyalty Redemption Form|



########################################### MY FORMS ####################################################

#9
  Scenario Outline: User opens My Forms page
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies element "<elementOne>"
    And User verifies element "<elementTwo>"
    Then User verifies element "<elementThree>"
    #Then User verifies element "<elementFour>"
    #Then User verifies element "<elementFive>"
    #Then User verifies element "<elementSix>"
    Examples:
      | parent Tab | child Tab | elementOne | elementTwo | elementThree | elementFour | elementFive | elementSix |
      |Forms |My Form          |My Form     |Form        |My Form       |Status       |Uploaded On  |Action      |

 #10
  Scenario Outline: User uploads Incorrect File
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User Clicks on upload Btn
    And And User uploads  file "<fileLoc>"
    Then User verifies element "<Warning Message>"
    And User closes appeared popup
    And User closes application

    Examples:
      | parent Tab | child Tab | fileLoc |Warning Message|
      |Forms       |My Form |C:\\Users\\ch.srivastava\\OneDrive - Gemini Solutions\\Desktop\\client-Logo.png|Invalid file selected. Supported extensions are .xlsx,.xls,.pdf|

#11
  Scenario Outline: User Uploads correct File
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User Clicks on upload Btn
    And User Selects form Type "<Form Type>"
    And And User uploads  file "<fileLoc>"
    Then User saves the file
    Then User verifies element "<Success Message>"
    And User closes appeared popup
    And User closes application
    Examples:
      | parent Tab | child Tab | Form Type | fileLoc | Success Message |
      |Forms       |My Form    |Employee Achievement  |C:\\Users\\ch.srivastava\Downloads\\MIS_Scenarios.xlsx|Your form has been uploaded successfully|

#12
Scenario Outline: User uploads file and selects number of entries
  Given User clicks on tab "<parent Tab>" and "<child Tab>"
  Then User Clicks on upload Btn
  And User Selects form Type "<Form Type>"
  And And User uploads  file "<fileLoc>"
  Then User saves the file
  Then User verifies element "<Warning Message>"
  And User closes appeared popup
  And User closes application
  Examples:
    | parent Tab | child Tab | Form Type | fileLoc | Warning Message |
    |Forms       |My Form    |Employee Achievement |C:\\Users\\ch.srivastava\Downloads\\MIS_Scenarios.xlsx|File with same name already exists|


#13
  Scenario Outline: User enters valid value in My forms search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies search field and enters value "<value>"
    Then User verifies element "<element>"
    And User closes application
    Examples:
      | parent Tab | child Tab | value | element |
      |Forms       | My Form  |Employee |Employee Achievement Form FY 2018.docx|

#14
  Scenario Outline: User enters an invalid value in My Forms search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies search field and enters value "<value>"
    Then User verifies element "<element>"
    And User closes application
    Examples:
      | parent Tab | child Tab | value | element |
      |Forms       | My Form  |Hello |No matching records found|

#15
  Scenario Outline: User hover over and clicks on deactivate Button
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User hover over deactivate button and clicks it
    And User closes application

    Examples:
      | parent Tab | child Tab |
      |Forms       | My Form  |

#16

  Scenario Outline: User downloads from My Forms page
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies element "<ColumnName>" downloads file and deletes "<fileName>"
    And User closes application
    Examples:
      | parent Tab | child Tab | ColumnName | fileName |
      |Forms       |My Form    |Action       |Loyalty Redemption Form|
