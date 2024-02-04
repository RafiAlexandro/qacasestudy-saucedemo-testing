@All
  Feature: Checkout Step Two Sauce Demo

    @CheckoutStepTwo @Positive @ClickCancelButton
      Scenario: Click the cancel button
        Given User in the product page
        When User click the product add to cart button
        And User click cart icon button
        Then Website will direct to cart page and display product
        And User click the checkout button
        Then Website will direct to the checkout one page
        And User input data user
        And User click the continue button
        Then Website in checkout two page with the product and results
        And User click cancel in checkout two page
        Then Website will display cancel checkout step two validation

    @CheckoutStepTwo @Positive @ClickCancelInValidationStepTwo
      Scenario: Click cancel button in validation checkout
        Given User in the product page
        When User click the product add to cart button
        And User click cart icon button
        Then Website will direct to cart page and display product
        And User click the checkout button
        Then Website will direct to the checkout one page
        And User input data user
        And User click the continue button
        Then Website in checkout two page with the product and results
        And User click cancel in checkout two page
        Then Website will display cancel checkout step two validation
        And User click cancel in cancel checkout step two validation
        Then User success cancel the checkout step two and direct to product page

    @CheckoutStepTwo @Positive @ClickKeepCheckoutInValidationStepTwo
      Scenario: Click keep checkout button in validation checkout
        Given User in the product page
        When User click the product add to cart button
        And User click cart icon button
        Then Website will direct to cart page and display product
        And User click the checkout button
        Then Website will direct to the checkout one page
        And User input data user
        And User click the continue button
        Then Website in checkout two page with the product and results
        And User click cancel in checkout two page
        Then Website will display cancel checkout step two validation
        And User click keep checkout in cancel checkout step two validation
        Then User success keep the checkout and still in checkout step two page

    @CheckoutStepTwo @Positive @FinishCheckout
      Scenario: Successful finish the checkout
        Given User in the product page
        When User click the product add to cart button
        And User click cart icon button
        Then Website will direct to cart page and display product
        And User click the checkout button
        Then Website will direct to the checkout one page
        And User input data user
        And User click the continue button
        Then Website in checkout two page with the product and results
        And User click finish button
        Then Website will be direct to checkout complete page
