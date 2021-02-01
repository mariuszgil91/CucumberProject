Feature:
  As a user
  I want to add item to cart
  So I can open and check if item is in the cart

  Scenario: Add item to cart
    Given the user is on Item page
    When I add item to cart
    Then Window with message that product has been added successfully should appear
    And Item price should match