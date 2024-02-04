@All
  Feature: Login Sauce Demo

  @Login @Negative @NullData
    Scenario: Failed login with Null Data
      Given User is already on login page
      When User click login button
      Then User get error username and password required

  @Login @Negative @InvalidUsername
    Scenario: Failed login with invalid username
      Given User is already on login page
      When User input invalid username and correct password
      And User click login button
      Then User get error username and password do not match

  @Login @Negative @InvalidPassword
  Scenario: Failed login with invalid password
    Given User is already on login page
    And User input correct username and invalid password
    And User click login button
    Then User get error username and password do not match

    @Login @Negative @UsernameOnly
    Scenario: Failed login with input username only
      Given User is already on login page
      When User input correct username
      And User click login button
      Then User get error password is required

    @Login @Negative @PasswordOnly
    Scenario: Failed login with input username only
      Given User is already on login page
      When User input correct password
      And User click login button
      Then User get error username is required

  @Login @Positive @SuccessLogin
  Scenario: Successful login
    Given User is already on login page
    When User input username and password
    And User click login button
    Then User successfully login