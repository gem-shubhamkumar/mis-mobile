Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Policy > View Policies
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
   Examples:
      | parentTab |    childTab    |
      |  Policy   | View Policies  |

  Scenario Outline: Verify Data is present
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Verify Data is present on all pages
    Examples:
      | parentTab |    childTab    |
      |  Policy   | View Policies  |

  Scenario Outline: Verify Number of Entries displayed
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify number of records displayed by default
    Then Select "<noOfRecords>" as number of entries
    And Verify number of records displayed changes
    Examples:
      | parentTab |    childTab    |  noOfRecords |
      |  Policy   | View Policies  |     25       |

  Scenario Outline: Enter Policy Name in Search Box
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When User Enters "<policyName>" policy in search box
    Then Verify "<policyName>" policy is filtered
    Examples:
      | parentTab |    childTab    |                policyName                |
      |  Policy   | View Policies  |     Human Resource Security Policy       |

  Scenario Outline: Enter Invalid Policy Name in Search Box
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When User Enters "<policyName>" policy in search box
    Then Verify "No matching records found" displays for Invalid Policy
    Examples:
      | parentTab |    childTab    |                policyName           |
      |  Policy   | View Policies  |     Human Resource Securities       |

  Scenario Outline: View Policy
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    When User Enters "<policyName>" policy in search box
    Then Verify "<policyName>" policy is filtered
    When Click on "View" button
    Then Verify "<policyName>" page opens
    And Click on "Close" button
    Examples:
      | parentTab |    childTab    |                policyName                |
      |  Policy   | View Policies  |     Human Resource Security Policy       |
