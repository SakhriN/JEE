Feature: Find All Rooms
  Scenario: get All Rooms
    Given there are some rooms in the library
    When I search for rooms with name started with "toto"
    Then List with 1 room should be returned
