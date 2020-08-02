Feature:  Registraction process on google cloud

  @prod @prodreg
  Scenario: Customer is register in Store
    When Customer is opening store homepage
    Then Customer is registering into Store
   @prod @prodlog
  Scenario: Customer is login using harcoded values
    When Customer is opening store homepage
    And I login with following hardcoded credentials
      | Username                 | Password     |
      | golden@mail.com           | Grudzien2021!|