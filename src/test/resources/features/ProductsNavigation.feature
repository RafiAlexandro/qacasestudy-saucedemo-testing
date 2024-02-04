@ALL
  Feature: Products - Navigation

  @Navigation @Positive @OpenNavigationMenu
    Scenario: Successful click and open the navigation menu
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will display links

  @Navigation @Positive @ClickAllItems
    Scenario: Successful click and open all items link
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click all items link
    Then Website will be direct to all product page

  @Navigation @Positive @ClickAbout
    Scenario: Successful click and open about link
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And user click about link
    Then Website will be direct to about page

  @Navigation @Positive @ClickLogout
  Scenario: Successful click logout link
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click logout link
    Then Appear validation logout

  @Navigation @Positive @SuccessLogout
  Scenario: Successful logout
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click logout link
    Then Appear validation logout
    And User click logout validation button
    Then User successfully logout

  @Navigation @Negative @SuccessPostponeLogout
  Scenario: Successful postpone logout
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click logout link
    Then Appear validation logout
    And User click cancel validation button
    Then User successfully postpone logout

  @Navigation @Positive @ClickResetAppState
  Scenario: Successful click and open reset app state link
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click reset app state link
    Then Website will reset app state

  @Navigation @Positive @CloseNavigationMenu
  Scenario: Successful click close button and close the navigation menu
    Given User is on login page
    When User fill username and password
    And User click login
    Then Website will be direct to products page
    And User click menu button
    Then Navigation menu will appear links and close button
    And User click close button
    Then Navigation menu will be closed