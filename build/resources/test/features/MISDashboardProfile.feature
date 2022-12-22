@ProfileModule
Feature: MIS Dashboard Profile module Scenarios


  Background: User verifies Login Page Elements Before Login
    Given User opens MIS Beta page "https://mymis.geminisolutions.com/"
    Given User enters Username as "charu.srivastava"
    And User enters Password as "Gemini@123"
    Then User clicks on sign in
    And User Verifies Landing Page


#1
Scenario Outline: User Updates Mobile and Extn Number
    Given User clicks on edit button
    Then User verifies element "<element>"
    And User edits value "<LocationOne>" as "<value1>"
    And User edits value "<LocationTwo>" as "<value2>"
    Then User verifies element "<elementOne>" and element Two "<ElementTwo>" and Update Details
    And User closes the pop up
    Examples:
      | element | LocationOne | value1 | LocationTwo | value2 | elementOne |ElementTwo|
      |Update Profile|contactNo  |1234567890|extnNo     |123     |Your profile update request has been sent successfully and pending for approval.|Your profile update request is pending for approval.|


#2
Scenario Outline: User enters invalid Phone number
  Given User clicks on edit button
  Then User verifies element "<element>"
  And User edits value "<LocationOne>" as "<value1>"
  And User edits value "<LocationTwo>" as "<value2>"
  Then User verifies element "<elementOne>" and element Two "<elementTwo>" and Update Details
  And User closes the pop up

  Examples:
    | element | value1 | value2 |elementOne|LocationOne|LocationTwo|elementTwo|
    |Update Profile|12345|123   |Please put 10 digit mobile number.|contactNo|extnNo|Your profile update request is pending for approval.|

#3
Scenario Outline: User not fills a field in Mobile Number section
    Given User clicks on edit button
    Then User verifies element "<element>"
    And User deletes value "<LocationOne>"
    Then User edits value "<LocationTwo>" as "<Extn Number>"
    Then User clicks on Update details "<elementOne>" and verifies "<Field Name>"
    Examples:
      | element| LocationOne |LocationTwo|Extn Number|Field Name|elementOne|
      |Update Profile|contactNo  |extnNo     |123        |contactNo |Your profile update request is pending for approval.|

#4
Scenario Outline: User not fills a field in Extension number section
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    And User deletes value "<LocationOne>"
    Then User edits value "<LocationTwo>" as "<Mobile Number>"
    Then User clicks on Update details "<elementOne>" and verifies "<Field Name>"
    Examples:
      | elementOne | LocationOne | LocationTwo|Mobile Number |Field Name|
      |Update Profile|extnNo   |contactNo      |1234567890     |extnNo  |

#5
Scenario Outline: User enters invalid Extension Number
    Given User clicks on edit button
    Then User verifies element "<element>"
    And User edits value "<LocationOne>" as "<value1>"
    And User edits value "<LocationTwo>" as "<value2>"
    Then User verifies element "<elementOne>" and element Two "<elementTwo>" and Update Details
    And User closes the pop up
    Examples:
      | element| value1 | value2 |elementOne|LocationOne|LocationTwo|elementTwo|
      |Update Profile|1234567890|12  |Extention number should only be 3 digits.|contactNo|extnNo|Your profile update request is pending for approval.|


#6
Scenario Outline: User enters invalid Pin code
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Update Address>"
    And User edits value "<Location>" as "<PinCode>"
    And User clicks on Update Btn
    Then User verifies element "<element>"
    Then User closes appeared popup
    And User closes the pop up
    Examples:
      | elementOne | PinCode| element |Update Address|Location|
      |Update Profile| 123  |Pin code should only be 6 digits.|Update Address|presentPincode|


#7
Scenario Outline: User enters Incorrect Password
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Change Password>"
    And User edits value "<LocationOne>" as "<Old Password>"
    And User edits value "<LocationTwo>" as "<New Password>"
    And User edits value "<LocationThree>" as "<Confirm Password>"
    And User clicks on Update Password Btn
    Then User verifies element "<element>"
    Then User closes appeared popup
    And User closes the pop up
    Examples:
      | elementOne | Change Password | Old Password | New Password | Confirm Password | element |LocationOne|LocationTwo|LocationThree|
      |Update Profile|Change Password|1234          |1234#         |1234#             |The old password you entered is not valid. Please try again with correct password.|txtOldPassword|txtNewPassword|txtconfirmPassword|


#8
Scenario Outline: User enters Different Password in Confirm Password
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Change Password>"
    And User edits value "<LocationOne>" as "<Old Password>"
    And User edits value "<LocationTwo>" as "<New Password>"
    And User edits value "<LocationThree>" as "<Confirm Password>"
    And User clicks on Update Password Btn
    Then User verifies element "<element>"
    And User closes the pop up
    Examples:
      | elementOne | Change Password | LocationOne | Old Password | LocationTwo | New Password | LocationThree | Confirm Password | element |
      |Update Profile|Change Password|txtOldPassword|Gemini@1234  |txtNewPassword|1234#        |txtconfirmPassword|12345#         |Password and confirm password does not match.|


#9 Once password changes it will fail all test cases ,so commented

Scenario Outline: User Changes Password Successfully
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Change Password>"
    And User edits value "<LocationOne>" as "<Old Password>"
    And User edits value "<LocationTwo>" as "<New Password>"
    And User edits value "<LocationThree>" as "<Confirm Password>"
    #And User clicks on Update Password Btn
    #Then User verifies element "<element>"
    #And User closes appeared popup
    #Then User verifies SignIn page
    And User closes the pop up

    Examples:
      | elementOne | Change Password | LocationOne | Old Password | LocationTwo | New Password | LocationThree | Confirm Password | element |
    |Update Profile|Change Password|txtOldPassword|Gemini@12345|txtNewPassword|Gemini@1234|txtconfirmPassword|Gemini@1234  |Success  |


#10
Scenario Outline: User not fills a field in Change Password section
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Change Password>"
    And User edits value "<LocationOne>" as "<Old Password>"
    And User edits value "<LocationTwo>" as "<New Password>"
    And User clicks on Update Password Btn
    Then User verifies blank field "<Field Name>"
    Examples:
      | elementOne | Change Password | LocationOne | Old Password | LocationTwo | New Password |Field Name|
      |Update Profile|Change Password|txtOldPassword|Gemini@12345 |txtNewPassword|Gemini@1234  |txtconfirmPassword|


#11
Scenario Outline: User Updates Address
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Update Address>"
    And User edits value "<Location>" as "<PinCode>"
    And User clicks on Update Btn
    Then User verifies element "<element>"
    Then User closes appeared popup
    And User closes the pop up
    Examples:
      | elementOne | Update Address | Location | PinCode | element |
      |Update Profile|Update Address|presentPincode|123456|Your address detail has been updated successfully.|

#12
Scenario Outline:User leaves Pin Code field blank
    Given User clicks on edit button
    Then User verifies element "<elementOne>"
    Then User clicks on field "<Update Address>"
    And User deletes value "<LocationOne>"
    And User clicks on Update Btn
    Then User verifies blank field "<Field Name>"
    Examples:
      | elementOne | Update Address | LocationOne |Field Name|
      |Update Profile|Update Address|presentPincode|presentPincode|

#13
  @lunch
Scenario Outline: User applies for lunch
    Given User clicks on Lunch Btn
    Then User verifies element "<elementOne>"
    And User clicks on FromDate Calendar Selects Date "<Date1>"
    Then User clicks on To Date Calendar Selects Date "<Date2>"
    Then User Selects location from dropdown "<Location>"
    Then User Clicks On Add Btn
    Then User verifies element "<element>"
    And User closes appeared popup
    Then User closes the lunch pop up
    Examples:
      | elementOne |Date1|Date2|element|Location|
      |Apply for Lunch|6| 10|Dates Added successfully|Austin, Texas|


#14
Scenario Outline: User applies for lunch for already applied date
    Given User clicks on Lunch Btn
    Then User verifies element "<elementOne>"
    And User clicks on FromDate Calendar Selects Date "<Date1>"
    Then User clicks on To Date Calendar Selects Date "<Date2>"
    Then User Selects location from dropdown "<Location>"
    Then User Clicks On Add Btn
    Then User verifies element "<Warning Message>"
    And User closes appeared popup
    Then User closes the lunch pop up
    Examples:
      | elementOne |Date1|Date2|Warning Message|Location|
      |Apply for Lunch|22| 23|You have already applied for these dates.|Austin, Texas|


#15
Scenario Outline: User leave a field blank in Apply lunch
    Given User clicks on Lunch Btn
    Then User verifies element "<elementOne>"
    And User clicks on FromDate Calendar Selects Date "<Date1>"
    Then User Selects location from dropdown "<Location>"
    Then User Clicks On Add Btn
    Then User verifies blank field "<Field Name>"
    Examples:
      | elementOne | Date1 | Field Name |Location|
      |Apply for Lunch|22 |tillDateEmp |Austin, Texas|

#16
  @Download
  Scenario Outline: Download Card
    When User card is present in dashboard
    Then User clicks on download card button
    And Verify file is downloaded "<fileName>"
    Examples:
      |fileName|
      |card.jpg  |
