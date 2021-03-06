@LoginPage
Feature: Login Page

  @Login @CheckComponents @Email
  Scenario Outline: Check Email Components
    Given User is on home page
    When  User clicks "Login Button" element in homepage
    Then  User should see "<pageTitle>" pageTitle
    When  User clicks "Email Radio Button" element in login page
    Then  User should see "<formTitle>" text in "Form Title" element in login page
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Email Input Container" element in login page
    Then  User should see "Password Input Container" element in login page
    Then  User should see "<emailPlaceholder>" text in "Email Input Container Placeholder" element in login page
    Then  User should see "<passwordPlaceholder>" text in "Password Input Container Placeholder" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "<rememberMeText>" text in "Remember Me" element in login page
    Then  User should see "Forgot Password Link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    Examples:
      | pageTitle            |  formTitle  | emailPlaceholder   | passwordPlaceholder  |rememberMeText|
      | Üye Girişi - LC Waikiki  |  GİRİŞ YAP  | E-Posta Adresiniz  | Şifreniz             |Beni hatırla  |


  @Login @CheckComponents @Phone
  Scenario Outline: Check Phone Components
    Given User is on home page
    When  User clicks "Login Button" element in homepage
    Then  User should see "<pageTitle>" pageTitle
    When  User clicks "Phone Radio Button" element in login page
    Then  User should see "<formTitle>" text in "Form Title" element in login page
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Phone Input Container" element in login page
    Then  User should see "Password Container" element in login page
    Then  User should see "<passwordPlaceholder>" text in "Password Container" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "<rememberMeText>" text in "Remember Me" element in login page
    Then  User should see "Forgot Password link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    Examples:
      | pageTitle                |  formTitle   | passwordPlaceholder  |rememberMeText|
      | Üye Girişi - LC Waikiki  |  GİRİŞ YAP   | Şifreniz             |Beni hatırla  |


  @Login @SuccessfulLogin
  Scenario Outline: Successful Login
    Given User is on home page
    When  User clicks "Login Button" element in homepage
    Then  User should see "<pageTitle>" pageTitle
    When  User clicks "Email Radio Button" element in login page
    When  User fills out the "Email" input container with  "<emailInput>" in login page
    When  User fills out the "Password" input container with  "<passwordInput>" in login page
    When  User clicks "Login Button" element in login page
    Then  User should see "<text>" text in "My Account Button" element in home page
    Examples:
      | pageTitle                |emailInput          |passwordInput       |text    |
      | Üye Girişi - LC Waikiki  |vba98041@zcrcd.com  |3ZxP9PEkn2tYQad     |Hesabım |
