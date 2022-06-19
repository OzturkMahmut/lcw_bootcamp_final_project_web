@ProductsPage
Feature: Products Page

  @Category @Click @Filter
  Scenario Outline: Go to category
    Given User is on home page
    When  User clicks "<subCategory>" subcategory in "<category>" category
    Then  User should see "<productType>" page
    When  User filters "<filterType>" of the products by "<filter>"
    Then  User should see "<filterType>" and "<filter>" in chosen filters area
    When  User clicks on the "<8>"th item
    Then  User should see product code info

    Examples:
      | subCategory   | category |   productType    |    filter      | filterType  |
      |    Bluz       |  Kadın   |       Bluz       |    Siyah       |  Renk       |
