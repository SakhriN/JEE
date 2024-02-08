Feature: Checkout
  Scenario Outline: Checkout rooms
    Given the room "<name>" cost <price>
    When I buy <qty> of the room "<name>"
    Then the total of "<name>" checkout is <total>

    Examples:

      |name|price|qty|total|
      | b1 | 10  | 1 | 10  |
      | b2 | 20  | 2 | 40  |