@All
  Feature: Checkout Complete Sauce Demo

    @Complete @Positive @CheckoutAnother
      Scenario: User can checkout another
        Given User in a product page
        When User click all add to cart button
        And User click a cart icon button
        Then Website direct to cart page and display product
        And User click a checkout button
        Then Website direct to the checkout one page
        And User input the data user
        And User click a continue button
        Then Website direct to checkout two page with the product and results
        And User click the finish button
        Then Website direct to checkout complete page
        And User click checkout another button
        Then Website direct to cart page