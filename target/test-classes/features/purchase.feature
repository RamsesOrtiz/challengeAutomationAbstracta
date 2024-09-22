Feature: Purchase process

  @AddToCart
  Scenario: Add a product to cart
    Given a user visits the website
    When select a product
    And select add to cart
    Then the system displays and alert confirmation

  @PlaceOrder
  Scenario: Place an order
    Given a user goes to cart
    When select place order
    And fill the payment data
    Then the system displays a message confirmation about the purchase