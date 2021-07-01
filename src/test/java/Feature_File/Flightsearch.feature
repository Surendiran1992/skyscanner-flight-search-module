@flightsSearch
Feature: Skyscanner Flights Page search box testing

  Background: User nagivated to search flights page
    Given User is on fights search page

  @search1
  Scenario Outline: All search fields are entered except checkboxes and default no. of traveller
    Given User enters <OriginCity> and  <DestCity>
    And User selects the depart year and month "2021-08"
    And User enters the from date "16"
    And User selects the return year and month "2021-12"
    And User enters the return date "14"
    When User clicks searchflights button
    Then user must see the search result in next page

    Examples: 
      | OriginCity | DestCity  |
      | chennai    | mumbai    |
      | delhi      | Ahmedabad |

  @search2
  Scenario: All search fields are entered except checkboxes and increasing just no.of adults
    Given User sets the origin city "delhi" and destination city "mumbai"
    And User selects the depart year and month "2021-07"
    And User enters the from date "25"
    And User selects the return year and month "2021-10"
    And User enters the return date "4"
    When User clicks travellers and increases the no.of adults to 5
    And User clicks searchflights button
    Then user must see the search result page with selected no of travellers

  @search3
  Scenario: All search fields are entered except checkboxes and increasing just no.of child.
    Given User sets the origin city "frankfurt" and destination city "warsaw"
    And User selects the depart year and month "2021-10"
    And User enters the from date "3"
    And User selects the return year and month "2021-11"
    And User enters the return date "12"
    When User clicks travellers and increases the no.of child to 2
    And User select the age of childs as 4 and 10
    And User clicks searchflights button
    Then user must see the search result page with selected no of travellers as 3

  @search4 
  Scenario: Increasing child and missing to select one of the child age.
    Given User sets the origin city "frankfurt" and destination city "warsaw"
    And User selects the depart year and month "2021-10"
    And User enters the from date "3"
    And User selects the return year and month "2021-11"
    And User enters the return date "22"
    When User clicks travellers and increases the no.of child to 2
    And User select the age of child as 7 
    And User clicks searchflights button
    Then user must get error msg to select children age.

  @search5
  Scenario Outline: All checkboxes are selected with default no. of traveller.
    Given User sets the origin city "london" and destination city "brussels"
    And User selects the depart year and month "2021-09"
    And User enters the from date "10"
    And User selects the return year and month "2021-09"
    And User enters the return date "19"
    When User clicks searchflights button
    Then user must see the search result in next page
