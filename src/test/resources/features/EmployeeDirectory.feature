@web_test
Feature: MIS EmployeeDirectory

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@123"

  @EmployeeDirectoryTest01
  Scenario Outline:Check whether employee directory page is downloaded

    Then Click on main screen "<mainScreen>" tab
    Then Verify the employee directory page is downloaded


    Examples:
      | mainScreen         |  |
      | Employee Directory |  |

  @EmployeeDirectoryTest02 @rerun_web
  Scenario Outline:Check whether employee directory page is able to click on mail link
    Then Click on main screen "<mainScreen>" tab
    Then Verify mail link is able to click


    Examples:
      | mainScreen         |  |
      | Employee Directory |  |

  @EmployeeDirectoryTest03

  Scenario Outline:Check whether employee directory page verify profile window is visible
    Then Click on main screen "<mainScreen>" tab
    Then Verify Profile window is visible


    Examples:
      | mainScreen         |  |
      | Employee Directory |  |

