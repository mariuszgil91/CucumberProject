Feature:
  As a user
  I want to be able to log in the system
  So that i can add accounting data for that client


  Scenario: Sign up a new user
    Given the user is on landing page
    When she provides the email as automationTest@test1234.com
    And she provides the password as automationTest12345
    And she signs-up
    Then she should be logged in to the application