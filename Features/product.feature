@ProductScenario
Feature: EndToEnd Scenario for TestMeApp
  Login with Rick account and purchase product and complete payment process
  Background: Login with valid credentials
  Given User is on home page
  When User enters username and password and click on Login button
  Then User should be logged in and Verified

  @AddToCartandPaymentProcess
  Scenario: Successfull Checkout
    Given Navigate to All categories - electronics and Head phone
    And Add product into shopping cart
    When proceed to Checkout
    And select bank and add credentials
    Then redirected to the thank you page

