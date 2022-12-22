Feature: Policy Activities
  This tests are for Policy module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Policy > View Policies
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    Examples:
      | parentTab |    childTab    |  heading     |
      |  Policy   | View Policies  | View Policies|

  Scenario Outline: Verify Data is present in Policies tab
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    Then Verify Data is present on all pages
    Examples:
      | parentTab |    childTab    |  heading     |
      |  Policy   | View Policies  | View Policies|

  Scenario Outline: Verify Number of Entries displayed
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    And Verify number of records displayed by default
    Then Select "<noOfRecords>" as number of entries
    And Verify number of records displayed changes
    Examples:
      | parentTab |    childTab    |  noOfRecords |   heading    |
      |  Policy   | View Policies  |     25       | View Policies|

  Scenario Outline: Enter Policy Name in Search Box
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User Enters "<policyName>" policy in search box
    Then Verify "<policyName>" policy is filtered
    Examples:
      | parentTab |    childTab    |                policyName                |     heading    |
      |  Policy   | View Policies  |     Human Resource Security Policy       | View Policies  |

  Scenario Outline: Enter Invalid Policy Name in Search Box
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User Enters "<policyName>" policy in search box
    Then Verify "No matching records found" displays for Invalid Policy
    Examples:
      | parentTab |    childTab    |                policyName           |    heading |
      |  Policy   | View Policies  |     Human Resource Securities       | View Policies |

  Scenario Outline: View Policy
    When User is on MIS Home Page
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<heading>" of "<childTab>" tab
    When User Enters "<policyName>" policy in search box
    Then Verify "<policyName>" policy is filtered
    Then Click on "View" button on Policy Page
    Then Verify "<policyName>" page opens
    And Click on "Close" button of Policy page
    Examples:
      | parentTab |    childTab    |                policyName                |    heading |
      |  Policy   | View Policies  |     Human Resource Security Policy       | View Policies   |