@CartPage
Feature: Cart Page

  @CheckProduct @FinishOrder
  Scenario Outline: Add a Product to Cart and Check it on the Cart Page
    Given User is on home page
    When  User clicks "<subCategory>" subcategory in "<category>" category
    Then  User should see "<productType>" page
    When  User filters "<filterType>" of the products by "<filterValue>"
    Then  User should see "<filterType>" and "<filterValue>" in chosen filters area
    When  User clicks on the 9. item
    Then  User should see product code info
    When  User choose size "<size>"
    Then  User should see size "<size>" selected
    Then  User adds the product to the cart
    When  User clicks "MyCart Button" element in product page
    Then  User should see "<pageTitle>" pageTitle
    Then  User should see "ProductCode" in cart page
    Then  User should see "ProductQuantity" in cart page
    Then  User should see "ProductSize" in cart page
    When  User clicks "Complete Order Button" element in cart page
    Then  User should see "New Address Form" element in checkout page

    Examples:
      | pageTitle             | subCategory   | category |   productType    |    filterValue    | filterType  | size |
      | Sepetim - LC Waikiki  |    Bluz       |  KADIN   |       Bluz       |       Siyah       |  Renk       |  M   |
