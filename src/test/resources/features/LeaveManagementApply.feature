Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > Apply tab
    When User is on MIS Home Page
    Then Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Examples:
      |      parentTab     |  childTab  | defaultTab |
      | Leave Management   |     Apply  |    Leave   |

  Scenario Outline: Verify fields are Auto Populated by default
    When User is on MIS Home Page
    Then Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Verify "Primary Contact Number,Other Contact Number" fields are auto populated
    Examples:
      |      parentTab     |   childTab  | defaultTab |
      | Leave Management   |      Apply  |    Leave   |

  Scenario Outline: Verify From,Till and Reason fields are mandatory
    When User is on MIS Home Page
    Then Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Verify "Primary Contact Number,Other Contact Number" fields are auto populated
    And Click on "Submit" button
    Then Verify "From,Till,Reason" fields are highlighted in red
    Examples:
      |      parentTab     |       childTab  | defaultTab |
      | Leave Management   |          Apply  |    Leave   |

