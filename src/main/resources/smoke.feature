Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Log In with valid Credentials
    Given User opens '<homePage>' page
    And User clicks Account button
    And User checks Email field visibility
    And User clicks Email field
    When User enters '<validEmail>' for login
    And User clicks ContinueLogIn button
    And User enters a '<validPassword>' for login
    And User clicks SignIn button
    Then User checks account logged in
    Examples:
      | homePage                | validEmail                | validPassword |
      | https://www.amazon.com/ | mailfortest1321@gmail.com | qwertyasdfg1  |

  Scenario Outline: Check registration with invalid Email
    Given User opens '<homePage>' page
    And User clicks Account button
    And User clicks Register button
    When User enters '<validName>' name
    And User enters '<invalidEmail>' email
    And User enters '<validPassword>' pass
    And User enters '<validPassword>' to repeat password field
    And User clicks ContinueRegistration button
    Then User checks that '<invalidEmailMessage>' is displayed
    Examples:
      | homePage                | validName | invalidEmail             | validPassword | invalidEmailMessage   |
      | https://www.amazon.com/ | testName  | mailfortest1321@gmailcom | qwertyasdfg1  | Invalid email address |

  Scenario Outline: Check registration with invalid Password
    Given User opens '<homePage>' page
    And User clicks Account button
    And User clicks Register button
    When User enters '<validName>' name
    And User enters '<validEmail>' email
    And User enters '<invalidPassword>' pass
    And User enters '<invalidPassword>' to repeat password field
    And User clicks ContinueRegistration button
    Then User checks that '<invalidPasswordMessage>' is displayed
    Examples:
      | homePage                | validName | validEmail                | invalidPassword | invalidPasswordMessage |
      | https://www.amazon.com/ | testName  | mailfortest1321@gmail.com | 1234            | Minimum 6 characters   |

  Scenario Outline: Check registration with wrong re-enter Password
    Given User opens '<homePage>' page
    And User clicks Account button
    And User clicks Register button
    When User enters '<validName>' name
    And User enters '<validEmail>' email
    And User enters '<validPassword>' pass
    And User enters '<validPassword2>' to repeat password field
    And User clicks ContinueRegistration button
    Then User checks that '<invalidRepeatedPasswordMessage>' is displayed
    Examples:
      | homePage                | validName | validEmail                | validPassword | validPassword2 | invalidRepeatedPasswordMessage |
      | https://www.amazon.com/ | testName  | mailfortest1321@gmail.com | qwertyasdfg1! | qwertyasdfg3   | Passwords must match           |

  Scenario Outline: Check registration with valid Credentials
    Given User opens '<homePage>' page
    And User clicks Account button
    And User clicks Register button
    When User enters '<validName>' name
    And User enters '<validEmail>' email
    And User enters '<validPassword>' pass
    And User enters '<validPassword>' to repeat password field
    And User clicks ContinueRegistration button
    Then User checks that registration credentials passed
    Examples:
      | homePage                | validName | validEmail                | validPassword |
      | https://www.amazon.com/ | testName  | mailfortest1321@gmail.com | qwertyasdfg1! |

  Scenario Outline: Check change deliver location
    Given User opens '<homePage>' page
    And User checks change deliver location button visibility
    And User clicks change deliver location button
    And User clicks enter US zip code field
    When User enters '<zipCodeUs>' to field
    And User clicks Accept
    And User clicks Continue
    Then User checks that location changed on '<zipCodeUs>' state
    And User clicks change deliver location button
    And User clicks ship outside US field
    And User clicks Canada
    And User clicks Done
    And User checks that location changed on '<location>'

    Examples:
      | homePage                | zipCodeUs | location |
      | https://www.amazon.com/ | 90202     | Canada   |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks change deliver location button visibility
    And User clicks change deliver location button
    And User clicks ship outside US field
    And User clicks Canada
    And User clicks Done
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks add to cart
    Then User checks that amount of products in cart are '<amountOfProductsInCart>'
    Examples:
      | homePage                | keyword                               | amountOfProductsInCart |
      | https://www.amazon.com/ | Panasonic LUMIX G85 4K Digital Camera | 1                      |

  Scenario Outline: Check find product through catalog
    Given User opens '<homePage>' page
    And User clicks All button
    When User checks sidebar elements visibility
    And User clicks '<sidebarCategory>' element
    And User clicks '<sidebarSubcategory>' element
    And User checks section visibility
    And User clicks '<selectionCategory>' catalog
    And User checks products visibility
    And User clicks '<product>'
    Then User checks '<product>' page visibility
    Examples:
      | homePage                | sidebarCategory | sidebarSubcategory | selectionCategory | product |
      | https://www.amazon.com/ | Electronics     | Camera & Photo     | Digital Cameras   | Camera  |

  Scenario Outline: Check Language change
    Given User opens '<homePage>' page
    And User checks Language button visibility
    And User clicks Language button
    When User click deutsch language button
    And User click submit button
    Then User checks url on '<DE>' language visibility
    Examples:
      | homePage                | DE      |
      | https://www.amazon.com/ | Deutsch |

  Scenario Outline: Check Currency change
    Given User opens '<homePage>' page
    And User checks Language button visibility
    And User clicks Language button
    When User click old currency button
    When User click newCurrency
    And User click submit button
    And User checks search field visibility
    And User makes search by keyword '<product>'
    And User clicks search button
    Then User checks that product have newCurrency
    Examples:
      | homePage                | product               |
      | https://www.amazon.com/ | steel series arctis 9 |