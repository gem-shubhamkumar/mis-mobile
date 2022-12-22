Feature: OtherPortals


  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@123"

@otherPortalTest01
  Scenario Outline: My MIS Other Portals validation

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify If other Portal is able to navigate "<subsScreen>" to the required location

    Examples:
      | mainScreen    | subsScreen |
      | Other Portals | L&D Portal |
#   | Other Portals | Contripoint |