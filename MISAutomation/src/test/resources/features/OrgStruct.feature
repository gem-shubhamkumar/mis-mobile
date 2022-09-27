Feature: Perform actions on Organization Structure of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@1234"

  @Test @TC01 @OrgStructure @
  Scenario: MIS_OrgStructure_
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
