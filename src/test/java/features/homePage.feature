@HomePage
Feature: Home Page

  @Banner
  Scenario: Check Banner
    Given User is on home page
    Then  User should see Banner

  @Category @Check
  Scenario Outline: Check Categories
    Given User is on home page
    Then  User should see "<category1>" category
    Then  User should see "<category2>" category
    Then  User should see "<category3>" category
    Then  User should see "<category4>" category
    Then  User should see "<category5>" category
    Then  User should see "<category6>" category
    Then  User should see "<category7>" category
    Then  User should see "<category8>" category
    Examples:
      | category1 | category2 | category3 | category4 | category5 | category6 | category7 |   category8    |
      |   KADIN   |   ERKEK   |   ÇOCUK   |  BEBEK    |  AYAKKABI |  AKSESUAR |  EV & YAŞAM | DİĞER MARKALAR |

  @Category @Click
  Scenario Outline: Go to category
    Given User is on home page
    When  User clicks "<subCategory>" subcategory in "<category>" category
    Then  User should see "<productType>" page
    Examples:
      | subCategory   | category | productType |
      |    Bluz       |  KADIN   |    Bluz     |


