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
    Then  User should see "Phone Number input container" element
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
    Examples:
      |         pageTitle            |
      |    Üye Ol - LC Waikiki       |