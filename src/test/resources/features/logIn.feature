Feature: Log In website

  @LogInWebsite
  Scenario: Log In website
    Given a user visits the website
    When select log in
    And fill a signed username and password
    Then the system displays welcome username in the website menu