Feature: Technical Test

  @technical-test
  Scenario: Perform Tests on the Dotmatics Corporate Site Events Page

    Given I navigate to URL "https://www.dotmatics.com/events"
    Then  I should login successfully to Event  page
    And   I should clicks on "List" view on the page
    Then  I should filter Event by "Online"
     And I should see a list of one or more events
     Then I should select first event seen in the Results
     And I should print the Date and Time of this event



