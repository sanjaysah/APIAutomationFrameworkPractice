Feature: Create a new Booking and Verify response
  Scenario Outline: Create a new Booking and Verify bookingid and response code
    Given Get the "<url>" with Auth and make the call
    When I make a POST request with payload
    Then Response Code "<responseCode>" and message should be verified
    Examples:
    | url | responseCode  |
    | /booking  | 200 |