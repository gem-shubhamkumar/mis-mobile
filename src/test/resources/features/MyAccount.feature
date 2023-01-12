@MISAutomation
Feature: MIS AccountsPortal

  Background:
    Given User has login to myMIS beta


  Scenario: Verify elements loaded on My Account page
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    When On new tab : "greytHR IDP"
    Then Verify "greytHR logo" is present on the current page
    Then Verify "Gemini logo" is present on the current page
    Then Verify "greytHR username text field" is present on the current page
    Then Verify "gerytHR password text field" is present on the current page
    And Verify "Hello there!" text is present on the current page

  Scenario: Verify login to GreytHR portal and verify View Info list
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    And Verify "Priyanshu" text is present on the current page
    Then Click on "View My Info link"
    Then Verify View My Info options are present
    Then Click on "Accounts & Statutory"
    And Verify "Yes Bank" text is present on the current page

  Scenario: Verify log in failed when no credentials are enter
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Click on login button without entering username and password
    And Verify "Username and password is required." text is present on the current page

  Scenario: Verify all the element on GreytHR landing page
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    Then Verify all element on greytHR landing page are visible

  Scenario: Verify profile details in greytHR portal
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    Then Verify "Settings link" is present on the current page
    And Click on "Settings link"
    Then Verify "View login history link" is present on the current page
    And Click on "View login history link"
    Then Verify all elements are present on view login history page
