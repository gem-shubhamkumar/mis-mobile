@MISAutomation
Feature: Accounts Portal

  Background:
    Given Navigate to "myMIS"
    Then Enter credentials to "myMIS portal" using username as "priyanshu.prajapati" and password as "Gemini@1234"
    And Click on "sign in button"
    And Verify login is successful

  @Test1
  Scenario: Verify elements loaded on My Account page
    Then Click on "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    When On new tab : "greytHR IDP"
    Then Verify "greytHR logo" is present on the current page
    Then Verify "Gemini logo" is present on the current page
    Then Verify "greytHR username text field" is present on the current page
    Then Verify "gerytHR password text field" is present on the current page
    And Verify "Hello there!" text is present on the current page

  @Test2
  Scenario: Verify login to GreytHR portal and landed back to myMIS tab when greytHR tab is closed
    Then Click on "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    And Close GreytHR portal tab and verify landed to myMis tab
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    And Click on "Log in button"
    And Verify "Priyanshu" text is present on the current page
    Then Click on "View My Info link"
    Then Verify View My Info options are present
    Then Click on "Accounts & Statutory"
    And Verify "Yes Bank" text is present on the current page

  @Test3
  Scenario: Verify log in failed when no credentials are entered
    Then Click on "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Click on "Log in button"
    And Verify "Username and password is required." text is present on the current page

  @Test4
  Scenario: Verify all the element on GreytHR landing page
    Then Click on "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    And Click on "Log in button"
    Then Verify all element on greytHR landing page are visible

  @Test5
  Scenario: Verify profile details in greytHR portal
    Then Click on "My Account" sub-tab inside "Accounts Portal" tab
    But Verify new tab is open "greytHR IDP" as page heading
    Then Enter credentials to "greytHR portal" using username as "priyanshu.prajapati@Geminisolutions.com" and password as "Nishu@greytHR"
    And Click on "Log in button"
    Then Verify "Settings link" is present on the current page
    And Click on "Settings link"
    Then Verify "View login history link" is present on the current page
    And Click on "View login history link"
    Then Verify all elements are present on view login history page


























