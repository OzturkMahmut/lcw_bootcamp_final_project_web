@ProductPage
Feature: Products Page

  @Category @Click @Filter
  Scenario Outline: Go to category
    Given User is on home page
    When  User clicks "<subCategory>" subcategory in "<category>" category
    Then  User should see "<productType>" page
    When  User filters "<filterType>" of the products by "<filterValue>"
    Then  User should see "<filterType>" and "<filterValue>" in chosen filters area
    When  User clicks on the 8. item
    Then  User should see product code info
    When  User choose size "<size>"
    Then  User should see size "<size>" selected
    Then  User adds the product to the cart

    Examples:
      | subCategory   | category |   productType    |    filterValue    | filterType  | size |
      |    Bluz       |  KADIN   |       Bluz       |       Siyah       |  Renk       |  M   |
