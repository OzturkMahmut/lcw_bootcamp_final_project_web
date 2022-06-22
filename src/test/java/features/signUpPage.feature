@SignUpPage
Feature: Sign Up Page

  @SignUp @CheckFormElements
  Scenario Outline: Check Registration Form
    Given User is on home page
    When  User hovers over Login button and clicks Sign Up Button
    Then  User should see "<pageTitle>" pageTitle
    Then  User should see "SignUp Form Title" element
    Then  User should see "Email Input Container" element
    Then  User should see "Password Input Container" element
    Then  User should see "Show Password Icon" element
    Then  User should see "Phone Number Input Container" element
    Then  User should see "Email CheckBox " element
    Then  User should see "Call CheckBox " element
    Then  User should see "SMS CheckBox " element
    Then  User should see "Register Info Container " element
    Then  User should see "Terms of Use CheckBox " element
    Then  User should see "Clarification Text " element
    Then  User should see "Sign Up Button " element
    Then  User should see "Login Button " element
    Examples:
      |         pageTitle            |
      |    Üye Ol - LC Waikiki       |


  @SignUp @FillOutForm
  Scenario Outline: New User Registration
    Given User is on home page
    When  User hovers over Login button and clicks Sign Up Button
    Then  User should see "<pageTitle>" pageTitle
    When  User fills out the "Email" input container with  "<emailInput>"
    When  User fills out the "Password" input container with  "<passwordInput>"
    When  User fills out the "Phone Number" input container with  "<phoneNumberInput>"
    When  User checks "Terms of Use" checkbox
    When  User clicks  "Sign Up Button" element
    Then  User should see "Phone Confirmation Pop Up" element
    Examples:
      | pageTitle            |emailInput           |passwordInput |phoneNumberInput  |
      | Üye Ol - LC Waikiki  |seday30647@gmail.com |12345678a      |05234567890       |