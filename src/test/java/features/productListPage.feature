@ProductsListPage
Feature: ProductList Page

  @Category @Click @Filter
  Scenario Outline: Choose a Product
    Given User is on home page
    When  User clicks "<subCategory>" subcategory in "<category>" category
    Then  User should see "<productType>" page
    When  User filters "<filterType>" of the products by "<filterValue>"
    Then  User should see "<filterType>" and "<filterValue>" in chosen filters area
    When  User clicks on the 8. item in the product list
    Then  User should see product code info

    Examples:
      | subCategory   | category |   productType    |    filterValue    | filterType  |
      |    Bluz       |  KADIN   |       Bluz       |       Siyah       |  Renk       |
