@All
  Feature: Products - Sort

  @Sort @Positive @FilterNameAToZ
  Scenario: Successful filter name (a to z)
    Given User on login page
    When User insert username and password
    And User click the login button
    Then Website will be direct to the products page
    And User click sort menu
    Then User do filter name a to z

  @Sort @Positive @FilterNameZToA
  Scenario: Successful filter name (z to a)
    Given User on login page
    When User insert username and password
    And User click the login button
    Then Website will be direct to the products page
    And User click sort menu
    Then User do filter name z to a

  @Sort @Positive @FilterPriceLowToHigh
  Scenario: Successful filter price (low to high)
    Given User on login page
    When User insert username and password
    And User click the login button
    Then Website will be direct to the products page
    And User click sort menu
    Then User do filter price low to high

  @Sort @Positive @FilterPriceHighToLow
  Scenario: Successful filter price (high to low)
    Given User on login page
    When User insert username and password
    And User click the login button
    Then Website will be direct to the products page
    And User click sort menu
    Then User do filter price high to low

