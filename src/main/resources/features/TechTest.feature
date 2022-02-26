Feature: Technical Test

  @technical-test
  Scenario: Perform Tests on the Dotmatics Corporate Site Events Page

    Given I navigate to URL "https://www.dotmatics.com/events"
    Then  I should login successfully to Event  page
    And   I should clicks on "List" view on the page
    Then  I should filter Event by following options
          |Industry Event |
          |Online         |
     And I should see a list of one or more events
     Then I should select first event seen in the Results
     And I should print the Date and Time of this event



    # Write Steps Here to:
    #   1. Select the "List" view
    #   2. Select to Filter by "Industry Event" or "Online" - so that we get a list of one or more events
    #   3. Open up the first event seen in the Results
    #   4. Print the Date and Time of this event to System.out