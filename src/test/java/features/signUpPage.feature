@SignUpPage
Feature: Sign Up Page

  @SignUp @CheckFormElements
  Scenario Outline: Check Registration Form
    Given User is on home page
    When  User hovers over Login button and clicks Sign Up Button in home page
    Then  User should see "<pageTitle>" pageTitle
    Then  User should see "SignUp Form Title" element in sign-up page
    Then  User should see "Email Input Container" element in sign-up page
    Then  User should see "Password Input Container" element in sign-up page
    Then  User should see "Show Password Icon" element in sign-up page
    Then  User should see "Phone Number Input Container" element in sign-up page
    Then  User should see "Email CheckBox " element in sign-up page
    Then  User should see "Call CheckBox " element in sign-up page
    Then  User should see "SMS CheckBox " element in sign-up page
    Then  User should see "Register Info Container " element in sign-up page
    Then  User should see "Terms of Use CheckBox " element in sign-up page
    Then  User should see "Clarification Text " element in sign-up page
    Then  User should see "Sign Up Button " element in sign-up page
    Then  User should see "Login Button " element in sign-up page
    Examples:
      |         pageTitle            |
      |    Üye Ol - LC Waikiki       |


  @SignUp @FillOutForm
  Scenario Outline: New User Registration
    Given User is on home page
    When  User hovers over Login button and clicks Sign Up Button in home page
    Then  User should see "<pageTitle>" pageTitle
    When  User fills out the "Email" input container with  "<emailInput>" in sign up page
    When  User fills out the "Password" input container with  "<passwordInput>" in sign up page
    When  User fills out the "Phone Number" input container with  "<phoneNumberInput>" in sign up page
    When  User checks "Terms of Use" checkbox in sign-up page
    When  User clicks  "Sign Up Button" element in sign-up page
    Then  User should see "Phone Confirmation Pop Up" element in sign-up page
    Examples:
      | pageTitle            |emailInput           |passwordInput |phoneNumberInput  |
      | Üye Ol - LC Waikiki  |seday30647@gmail.com |12345678a      |05234567890       |