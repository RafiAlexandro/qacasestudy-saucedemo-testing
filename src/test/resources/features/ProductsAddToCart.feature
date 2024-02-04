@All
  Feature: Products - Add To Cart Button

    @AddToCart @Positive @SuccessfulAddProduct
      Scenario: Successful add product to Cart
        Given User in the login page
        When User insert the username and password
        And User is click login button
        Then Website will direct to products page
        And User click add to cart button
        And User click cart icon
        Then Product will appear in cart page

    @AddToCart @Positive @SuccessfulRemoveProductInProductPage
      Scenario: Successful remove product from product page
        Given User in the login page
        When User insert the username and password
        And User is click login button
        Then Website will direct to products page
        And User click add to cart button
        Then Website will display remove button
        And User click remove button
        And User click cart icon
        Then User successfully remove product

    @AddToCart @Positive @SuccessfulRemoveProductInCartPage
      Scenario: Successful remove product from cart page
        Given User in the login page
        When User insert the username and password
        And User is click login button
        Then Website will direct to products page
        And User click add to cart button
        And User click cart icon
        And User click remove button from cart page
        Then User successfully remove product