Feature: MIS Leave Management Activities
  This tests are for Leave Management module of MIS Beta

  Background:
    Given User is logged into MIS

  Scenario Outline: Navigate to Leave Management > WFH tab
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    And Verify "<defaultTab>" displays by default
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Examples:
      |      parentTab     |  childTab  | defaultTab |     tab        |
      | Leave Management   |     Apply  |    Leave   | Work From Home |

  Scenario Outline: Verify field is Auto Populated by default
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Verify "mobileNo" fields are auto populated
    Examples:
      |      parentTab     |   childTab  |      tab       |
      | Leave Management   |      Apply  | Work From Home |

  Scenario Outline: Verify Date and Reason are mandatory fields
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Click on Submit button for WFH
    Then Verify "Date,WFH Reason" fields are highlighted in red
    Examples:
      |      parentTab     |       childTab  |        tab          |
      | Leave Management   |          Apply  |    Work From Home   |

  Scenario Outline: Select Date from Date dropdown
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    Examples:
      |      parentTab     |       childTab  |        tab          |
      | Leave Management   |          Apply  |    Work From Home   |

  Scenario Outline: Enter reason for WFH
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    And Enter reason "WFH leave" for leave
    Examples:
      |      parentTab     |       childTab  |        tab          |
      | Leave Management   |          Apply  |    Work From Home   |

  Scenario Outline: Enter required data and click on Submit leave
    When User is on MIS Home Page
    When Click on "<childTab>" sub tab of "<parentTab>" tab
    And Verify "<childTab>" opens successfully
    Then Click on "<tab>" Tab
    And Verify "<tab>" displays
    Then Select date from "<tab>" date dropdown
    And Enter reason "WFH leave" for leave
    Then Click on Submit button for WFH
    And Verify Leave is submitted and "Request processed successfully" appears
    Examples:
      |      parentTab     |       childTab  |        tab          |
      | Leave Management   |          Apply  |    Work From Home   |

