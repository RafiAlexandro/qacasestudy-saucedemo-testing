@All
  Feature: Footer Sauce Demo

    @Footer @Positive @ClickTwitter
      Scenario: User successfully click twitter and direct to twitter page
        Given User is on a login page
        When User fill a username and password
        And User click the login
        Then Website direct to products page and contains footer and social media icons
        And User click twitter icon
        Then Website will direct to twitter page

    @Footer @Positive @ClickFacebook
      Scenario: User successfully click facebook and direct to facebook page
        Given User is on a login page
        When User fill a username and password
        And User click the login
        Then Website direct to products page and contains footer and social media icons
        And User click facebook icon
        Then Website will direct to facebook page

    @Footer @Positive @ClickLinkedin
      Scenario: User successfully click linkedin and direct to linkedin page
        Given User is on a login page
        When User fill a username and password
        And User click the login
        Then Website direct to products page and contains footer and social media icons
        And User click linkedin icon
        Then Website will direct to linkedin page
