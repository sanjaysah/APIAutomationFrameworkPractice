Feature: Get All Booking and Verify
  Scenario Outline: Get All Booking and Verify Status Code
    Given Get the "<url>"
    When I make a GET request
    Then Response Code "<responseCode>" should be verified
    Examples:
      | url | responseCode  |
      | /booking  | 200 |