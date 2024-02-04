@All
  Feature: Checkout Step One Sauce Demo

    @CheckoutStepOne @Negative @SuccessClickCancel
      Scenario: Successful click the cancel button
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User click the cancel button
        Then Website will display cancel checkout validation

    @CheckoutStepOne @Negative @SuccessClickKeepCheckout
      Scenario: Successful click continue in cancel checkout validation
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User click the cancel button
        Then Website will display cancel checkout validation
        And User click keep checkout in cancel checkout validation
        Then User can continue checkout and still in the same page

    @CheckoutStepOne @Negative @SuccessCancel
      Scenario: Successful cancel the checkout
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User click the cancel button
        Then Website will display cancel checkout validation
        And User click cancel in cancel checkout validation
        Then User successfully cancel the checkout

    @CheckoutStepOne @Negative @FailedContinueWithNullData
      Scenario: Failed continue with null data
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User click continue button
        Then User get error data required

    @CheckoutStepOne @Negative @FailedContinueWithNullFirstName
      Scenario: Failed continue with null first name
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User input last name
        And User input zip code
        And User click continue button
        Then User get error first name required

    @CheckoutStepOne @Negative @FailedContinueWithNullLastName
      Scenario: Failed continue with null last name
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User input first name
        And User input zip code
        And User click continue button
        Then User get error last name required

    @CheckoutStepOne @Negative @FailedContinueWithNullZipCode
      Scenario: Failed continue with null zip code
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User input first name
        And User input last name
        And User click continue button
        Then User get error first zip code required

    @CheckoutStepOne @Positive @SuccessContinue
      Scenario: Successfully continue with correct data
        Given User in product page
        When User click product add to cart button
        And User click a cart icon
        Then Website will be direct to cart page and display product
        And User click checkout button
        Then Website will direct to checkout page
        And User input first name
        And User input last name
        And User input zip code
        And User click continue button
        Then Website will be direct to checkout two page and display product results
