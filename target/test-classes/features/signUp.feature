Feature: Sign Up in the website

  @SignUpWebsite
  Scenario: Sign Up a new user
    Given a user visits the website
    When access to sign up
    And fill username and password
    Then the system displays an alert confirmation about the sign up