Feature: Automation Tests in Demoblaze

  @ExtractingProductInformation
  Scenario: Extracting Product Information
    Given a visit to the website
    When the products information is displayed
    Then a text file is generated with each product information

  @AddToCart
  Scenario: Add a product to cart
    Given a user visits the website to add a product
    When select a product
    And select add to cart
    Then the system displays and alert confirmation

  @PlaceOrder
  Scenario: Place an order
    Given a user goes to cart
    When select place order
    And fill the payment data
    Then the system displays a message confirmation about the purchase

  @SignUpWebsite
  Scenario: Sign Up a new user
    Given a user visits the website to sign up
    When access to sign up
    And fill username and password
    Then the system displays an alert confirmation about the sign up

  @LogInWebsite
  Scenario: Log In website
    Given a user visits the website
    When select log in
    And fill a signed username and password
    Then the system displays welcome username in the website menu