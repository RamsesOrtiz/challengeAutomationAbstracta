Feature: Extract product information to a text file

  @ExtractingProductInformation
  Scenario: Extracting Product Information
    Given a visit to the website
    When the products information is displayed
    Then a text file is generated with each product information