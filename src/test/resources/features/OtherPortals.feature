Feature: OtherPortals


  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@1234"

  @otherPortalTest01
  Scenario Outline: My MIS Other Portals validation

    Given Launch my MIS application
    Then Verify If other Portal is able to navigate "<subsScreen>" to the required location

    Examples:
      | mainScreen    | subsScreen  |
      | Other Portals | L&D Portal  |
      | Other Portals | Contripoint |