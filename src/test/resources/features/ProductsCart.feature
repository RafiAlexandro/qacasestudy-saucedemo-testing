@All
  Feature: Products - Cart

    @Cart @Positive @ContinueShopping
      Scenario: Successful click continue shopping
        Given User on the login page
        When User input the username and password
        And User click a login button
        Then Website will direct to a products page
        And User click the cart icon
        Then Website will display cart page
        And User click continue shopping
        Then Website will return to product page

    @Cart @Negative @CantCheckoutIfNotHaveProduct
      Scenario: User cant click checkout if not have product
        Given User on the login page
        When User input the username and password
        And User click a login button
        Then Website will direct to a products page
        And User click the cart icon
        Then Website will display cart page
        And User click checkout
        Then Website cant direct to checkout one page

    @Cart @Positive @SuccessClickCheckout
      Scenario: Successful click checkout
        Given User on the login page
        When User input the username and password
        And User click a login button
        Then Website will direct to a products page
        And User click the add to cart button
        And User click the cart icon
        Then Website will display cart page and display product
        And User click checkout
        Then Website will be direct to checkout one page