Feature: delete room
  Scenario: delete existed room
    Given there are two rooms, one with id 1
      And second with id 2 in the library
    When I delete the room with id 2
    Then list with one room with id 1 should be returned
