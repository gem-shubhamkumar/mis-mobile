Feature: Reimbursement

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@1234"


    @ReimbursementTest01

    Scenario Outline: Reimbursement Add new request function

      Then Click on "<mainScreen>" tab of "<subsScreen>" tab
      Then Click on "<buttonName>", "<type>", "<month>" and select the drop down value for the current month
      Then Upload the file with "<FileName>", "<FilePath>" and validate "<Description>", "<BillNo>", "<Date>","<RembuirsmenetAmount>","<Amount>" after filling the details

      Examples:
        | mainScreen    | subsScreen      | buttonName  | type    | month     | FileName | FilePath                                  | Description    | BillNo | Date       | RembuirsmenetAmount | Amount |
        | Reimbursement | MyReimbursement | New Request | Monthly | July 2022 | LOGOFILE | C:\Users\si.porwal\Downloads\LOGOFILE.png | Gemini Desktop | 1      | 27/07/2022 | 7500                | 7500   |

  @ReimbursementTest02

  Scenario Outline: Reimbursement main page validations

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Select Drop Down values for current financial year and validate
    Then Change and validate entries on page
    Then Verify if Button is visible
    Then Verify No. of Columns and print name of columns
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest03

  Scenario Outline: Verify if search box is working

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate you are able to search "<value>" value successfully
    Examples:
      | mainScreen    | subsScreen      | value |
      | Reimbursement | MyReimbursement | 234   |

  @ReimbursementTest04

  Scenario Outline: Verify if search box is working for no records found

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate you are able to search "<value>" value and validate no records found successfully
    Examples:
      | mainScreen    | subsScreen      | value |
      | Reimbursement | MyReimbursement | 23400 |


@ReimbursementTest05
Scenario Outline: Verify we are able to check if warning pop up is visible
  Then Click on "<mainScreen>" tab of "<subsScreen>" tab
  Then Verify warning after file upload of "<FilePath>", "<type>", "<month>" is visible
  Examples:
    | mainScreen    | subsScreen      | FilePath                                                   | type    | month          |
    | Reimbursement | MyReimbursement | C:\Users\si.porwal\Downloads\MicrosoftTeams-image (55).png | Monthly | September 2022 |

  @ReimbursementTest06
  Scenario Outline: Verify warning for more than one reimbursement in a month

  Then Click on "<mainScreen>" tab of "<subsScreen>" tab
Then verify Warning "<buttonName>", "<FileName>", "<FilePath>", "<type>", "<month>" for more than one reimbursement in a month
    Then Verify "<description>", "<billNo>", "<date>", "<rembuirsmenetAmount>", "<amount>" save draft reimbursement for same month
    Examples:
      | mainScreen    | subsScreen      | buttonName  | FileName | FilePath                                  | type    | month          | description    | billNo | date       | rembuirsmenetAmount | amount |
      | Reimbursement | MyReimbursement | New Request | LOGOFILE | C:\Users\si.porwal\Downloads\LOGOFILE.png | Monthly | September 2022 | Gemini Desktop | 123    | 23/09/2022 | 12345               | 12345  |

  @ReimbursementTest07
  Scenario Outline: Verify total amount is correct

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify total amount in the UI is correct
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest08
  Scenario Outline: Validation Pdf export

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then PDF "<filePath>" export validation

    Examples:
      | mainScreen    | subsScreen      | filePath                     |
      | Reimbursement | MyReimbursement | C:\Users\si.porwal\Downloads |

  @ReimbursementTest09
  Scenario Outline: Validate if are able to navigate back to reimbursement main page

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate that we are able to navigate back to main page of reimbursement
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest10
  Scenario Outline: Validation for action button visibility

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate action button visibility
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest11
  Scenario Outline: Validation for cancel button functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate cancel button functionality
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |


  @ReimbursementTest12

  Scenario Outline: Reimbursement Add new request function save draft functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Click on "<buttonName>", "<type>", "<month>" and select the drop down value for the current month
    Then Validate "<Description>", "<BillNo>", "<Date>", "<ReimbursementAmount>", "<Amount>", "<FilePath>", "<FileName>" and click on save draft
    Examples:
      | mainScreen    | subsScreen      | buttonName  |  |  | FileName | FilePath                                  | Description    | BillNo | Date       | ReimbursementAmount | Amount | type    | month      |
      | Reimbursement | MyReimbursement | New Request |  |  | LOGOFILE | C:\Users\si.porwal\Downloads\LOGOFILE.png | Gemini Desktop | 1      | 27/06/2022 | 7500                | 7500   | Monthly | April 2022 |



#    Then verify Warning "(.*?)", "(.*?)", "(.*?)", "(.*?)", "(.*?)" for more than one reimbursement in a month

  @ReimbursementTest13

  Scenario Outline: Reimbursement Add new request function save draft functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify we are able to print
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |
