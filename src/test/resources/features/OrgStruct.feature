Feature: Perform actions on Organization Structure of MIS website

  Background:
    Given Navigate to MIS Beta Application
    And Login to MIS with credentials "amisha.srivastava" "Gemini@1234"

  @Test @TC01 @OrgStructure
  Scenario: MIS_OrgStructure_SearchEmployeeAndGetDesignation
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
    And Search an employee "Amisha Srivastava" and get their designation
    Then Logout from MIS

  @Test @TC02 @OrgStructure
  Scenario: MIS_OrgStructure_CountSeniorsWithReportees
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
    And Count the total number of seniors having reportees
    Then Logout from MIS

  @Test @TC03 @OrgStructure
  Scenario: MIS_OrgStructure_ExpandAndCompress
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
    And Verify side arrows are present on the page
    #And Expand or compress senior with max reportees
    Then Logout from MIS

  @Test @TC04 @OrgStructure
  Scenario: MIS_OrgStructure_ZoomOnDoubleClick
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
    And Double click to zoom in or zoom out a card
    Then Logout from MIS

  @Test @TC05 @OrgStructure
  Scenario: MIS_OrgStructure_ZoomInZoomOut
    Then Open "Organization Structure" page
    And Verify "Organization Structure" page of type "Main"
    And Zoom in and zoom out organization structure
    Then Logout from MIS