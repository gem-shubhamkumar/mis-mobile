Feature: DashboardReferral

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@123"

    @DashboardReferralTest01

    Scenario Outline:Verify if dashboard page is loaded properly and JD window is visible

      Then Click on main screen "<mainScreen>" tab
      Then Verify that dashboard page is downloaded and JD window is visible
      Examples:
        | mainScreen |  |
        | Dashboard  |  |

  @DashboardReferralTest02

  Scenario Outline:Create referral red error field validation

    Then Click on main screen "<mainScreen>" tab
    Then Create a referral and verify the red error warnings
    Examples:
      | mainScreen |
      | Dashboard  |

    # It may fail if you don't change the details before running the test case
  @DashboardReferralTest03

  Scenario Outline:Validation of referral creation

    Then Click on main screen "<mainScreen>" tab
    Then Create a referral by filling all the details with "<filePath>", "<name>", "<email>", "<mobileNo>", "<type>" and validate is a success
    Examples:
      | mainScreen | filePath                               | name    | email             | mobileNo   | type      |
      | Dashboard  | C:\Users\si.porwal\Downloads\gemam.pdf | sarkant | sarkant@gmail.com | 8889685002 | Batchmate |

  @DashboardReferralTest04

  Scenario Outline:Validation of resume popup in my referral card
    Then Click on main screen "<mainScreen>" tab
    Then  Validate resume popup in my referral card
    Examples:
      | mainScreen |
      | Dashboard  |

  @DashboardReferralTest05

  Scenario Outline:Validation of wrong email popup
    Then Click on main screen "<mainScreen>" tab
    Then Validate Wrong email popup
    Examples:
      | mainScreen |
      | Dashboard  |
  @DashboardReferralTest06

  Scenario Outline:Validation of wrong format upload pop
    Then Click on main screen "<mainScreen>" tab
    Then Validate Wrong format "<filePath>" upload popup
    Examples:
      | mainScreen | filePath                                  |
      | Dashboard  | C:\Users\si.porwal\Downloads\LOGOFILE.png |

  @DashboardReferralTest07

  Scenario Outline:Validation of FAQ pdf visibility
    Then Click on main screen "<mainScreen>" tab
  Then validate and Click on FAQ pdf
    Examples:
      | mainScreen |
      | Dashboard  |

  @DashboardReferralTest08

  Scenario Outline:Validation of manual pdf visibility
    Then Click on main screen "<mainScreen>" tab
    Then validate and Click on Manual pdf
    Examples:
      | mainScreen |
      | Dashboard  |

