Feature: Customer add products

  Scenario: 01 Customer add products in his shopping cart

    Given  Mike on home page after opening nopCart mobile app
    When Mike click "electronics" from our categories list from home page
    And Mike click to "Nokia Lumia 1020" product details page
    Then Mike select size "Large" from product details page
    And Mike click plus button to increase Qty by "2"
    Then Mike click add to cart button to add the product in his cart
