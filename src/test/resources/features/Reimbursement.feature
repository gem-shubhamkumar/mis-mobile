Feature: Reimbursement

  Background:
    Given MIS Beta is opened and verify application opens successfully
    When User logins into application with username "siddhanshi.porwal" and password "Gemini@123"

    #submit details is not working as you can only input one reimbursement for a single month
    @ReimbursementTest01 @reb

    Scenario Outline: Reimbursement Add new request function

      Then Click on "<mainScreen>" tab of "<subsScreen>" tab
      Then Click on "<buttonName>", "<type>", "<month>" and select the drop down value for the current month
      Then Upload the file with "<FileName>", "<FilePath>" and validate "<Description>", "<BillNo>", "<Date>","<reimbursementAmount>","<Amount>" after filling the details

      Examples:
        | mainScreen    | subsScreen      | buttonName  | type    | month      | FileName | FilePath                                  | Description | BillNo | Date       | reimbursementAmount | Amount |
        | Reimbursement | MyReimbursement | New Request | Monthly | June 2022 | err2.png | C:\Users\sa.chand\Pictures\err2.png | Gemini wive | 1     | 06/20/2022 | 7500                | 7500   |

  @ReimbursementTest02 @reb

  Scenario Outline: Reimbursement main page validations

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Select Drop Down values for current financial year and validate
    Then Change and validate entries on page
    Then Verify if Button is visible
    Then Verify No. of Columns and print name of columns
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest03 @reb

  Scenario Outline: Verify if search box is working

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate you are able to search "<value>" value successfully
    Examples:
      | mainScreen    | subsScreen      | value |
      | Reimbursement | MyReimbursement | 234   |

  @ReimbursementTest04 @reb

  Scenario Outline: Verify if search box is working for no records found

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate you are able to search "<value>" value and validate no records found successfully
    Examples:
      | mainScreen    | subsScreen      | value |
      | Reimbursement | MyReimbursement | 23400 |


  @ReimbursementTest05 @reb
  Scenario Outline: Verify we are able to check if warning pop up is visible
  Then Click on "<mainScreen>" tab of "<subsScreen>" tab
  Then Verify warning after file upload of "<FilePath>", "<type>", "<month>" is visible
  Examples:
    | mainScreen    | subsScreen      | FilePath                                                   | type    | month          |
    | Reimbursement | MyReimbursement | C:\Users\sa.chand\Pictures\farewell3.png | Monthly | September 2022 |

  @ReimbursementTest06 @reb
  Scenario Outline: Verify warning for more than one reimbursement in a month

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then verify Warning "<buttonName>", "<FileName>", "<FilePath>", "<type>", "<month>" for more than one reimbursement in a month
    Then Verify "<description>", "<billNo>", "<date>", "<reimbursementAmount>", "<amount>" save draft reimbursement for same month
    Examples:
      | mainScreen    | subsScreen      | buttonName  | FileName | FilePath                                  | type    | month          | description    | billNo | date       | reimbursementAmount | amount |
      | Reimbursement | MyReimbursement | New Request | err2 | C:\Users\sa.chand\Pictures\err2.png | Monthly | September 2022 | Gemini Desktop | 123    | 09/23/2022 | 12345               | 12345  |

  @ReimbursementTest07 @reb
  Scenario Outline: Verify total amount is correct

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify total amount in the UI is correct
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest08 @reb
  Scenario Outline: Validation Pdf export

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then PDF export validation

    Examples:
      | mainScreen    | subsScreen      |  |
      | Reimbursement | MyReimbursement |  |

  @ReimbursementTest09 @reb
  Scenario Outline: Validate if are able to navigate back to reimbursement main page

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate action button for "<elementNo>", "<actionButtonNo>" visibility
    Then Validate that we are able to navigate back to main page of reimbursement
    Examples:
      | mainScreen    | subsScreen      | elementNo | actionButtonNo |
      | Reimbursement | MyReimbursement | 2         | 2              |

  @ReimbursementTest10 @reb
  Scenario Outline: Validation for action button visibility

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate action button for "<elementNo>", "<actionButtonNo>" visibility
    Examples:
      | mainScreen    | subsScreen      | elementNo | actionButtonNo |
      | Reimbursement | MyReimbursement | 2         | 2              |

   #Due to less no. of cancel button we have to change the details in feature file again and again
  @ReimbursementTest11 @reb
  Scenario Outline: Validation for cancel button functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Validate cancel button for "<cancelButtonNo>", "<noOfElement>" functionality
    Examples:
      | mainScreen    | subsScreen      | cancelButtonNo | noOfElement |  |
      | Reimbursement | MyReimbursement | 1             |    1        |  |


  #Sometimes it throws null backend API exception while file upload
  @ReimbursementTest12 @reb

  Scenario Outline: Reimbursement Add new request function save draft functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Click on "<buttonName>", "<type>", "<month>" and select the drop down value for the current month
    Then Validate "<Description>", "<BillNo>", "<Date>", "<ReimbursementAmount>", "<Amount>", "<FilePath>", "<FileName>" and click on save draft
    Examples:
      | mainScreen    | subsScreen      | buttonName  |  |  | FileName | FilePath                                  | Description | BillNo | Date       | ReimbursementAmount | Amount | type    | month     |
      | Reimbursement | MyReimbursement | New Request |  |  | LOGO.png | C:\Users\sa.chand\Downloads\LOGO.png | Files       | 3      | 06/17/2022 | 7500                | 7500   | Monthly | June 2022 |


  @ReimbursementTest13 @reb

  Scenario Outline: Reimbursement Add new request function save draft functionality

    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify we are able to print
    Examples:
      | mainScreen    | subsScreen      |
      | Reimbursement | MyReimbursement |

  @ReimbursementTest14 @reb

  Scenario Outline: Verify if Copy functionality is working properly
    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    And Verify data is copied for reimbursement page
  Examples:
  | mainScreen    | subsScreen      |
  | Reimbursement | MyReimbursement |

  @ReimbursementTest15 @reb
  Scenario Outline: Verify wrong extension warning pop up is visible
    Then Click on "<mainScreen>" tab of "<subsScreen>" tab
    Then Verify wrong extension warning after file upload of "<FilePath>", "<type>", "<month>" is visible
    Examples:
      | mainScreen    | subsScreen      | FilePath                                                                                  | type    | month          |
      | Reimbursement | MyReimbursement | C:\Users\sa.chand\Downloads\medical-record.pdf | Monthly | September 2022 |