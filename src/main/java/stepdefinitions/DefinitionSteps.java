package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    WebDriver driver;
    HomePage homePage;
    CatalogResultPage catalogResultPage;
    ChangeLanguageAndCurrencyPage changeLanguageAndCurrencyPage;
    LogInPage logInPage;
    RegisterPage registerPage;
    SearchResultPage searchResultPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks Account button")
    public void userClicksAccountButton() {
        homePage.openLogInPage();
    }

    @And("User checks Language button visibility")
    public void userChecksLanguageButtonVisibility() {

    }

    @And("User clicks Language button")
    public void userClicksLanguageButton() {
        homePage.openLanguageAndCurrencyPage();
    }

    @And("User checks Email field visibility")
    public void userChecksEmailFieldVisibility() {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.emailFieldIsDisplayed();
    }

    @And("User clicks Email field")
    public void userClicksEmailField() {
        logInPage.emailFieldClick();
    }

    @When("User enters {string} for login")
    public void userEntersValidEmail(String email) {
        logInPage.enterEmail(email);
    }

    @And("User clicks ContinueLogIn button")
    public void userClicksContinueLogInButton() {
        logInPage.clickContinueButton();
    }

    @And("User enters a {string} for login")
    public void userEntersAValidPasswordForLogIn(String password) {
        logInPage.passwordFieldClick();
        logInPage.enterPassword(password);
    }

    @And("User clicks SignIn button")
    public void userClicksSignInButton() {
        logInPage.clickSighIn();
    }

    @Then("User checks account logged in")
    public void userChecksAccountLoggedIn() {
        assertTrue(homePage.captureMessageIsDisplayed());
    }

    @And("User clicks Register button")
    public void userClicksRegisterButton() {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.checkVisibilityOfRegisterButton();
        logInPage.clickCreateNewAccount();
    }

    @When("User enters {string} name")
    public void userEntersValidName(String name) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterName(name);
    }

    @And("User enters {string} email")
    public void userEntersInvalidEmailEmail(String email) {
        registerPage.enterEmail(email);
    }

    @And("User enters {string} pass")
    public void userEntersValidPasswordPass(String password) {
        registerPage.enterPassword(password);
    }

    @And("User enters {string} to repeat password field")
    public void userEntersValidPasswordToRepeatPasswordField(String passwordCheck) {
        registerPage.enterPasswordCheck(passwordCheck);
    }

    @And("User clicks ContinueRegistration button")
    public void userClicksContinueRegistrationButton() {
        registerPage.clickContinueButton();
    }


    @Then("User checks that {string} is displayed")
    public void userChecksThatInvalidEmailMessageIsDisplayed(String invalidMessage) {
        assertTrue(registerPage.invalidEmailMessageIsPresent(invalidMessage));
    }

    @Then("User checks that registration credentials passed")
    public void userChecksThatRegistrationCredentialsPassed() {
        assertTrue((registerPage.credentialsPassedMessageIsPresent()));
    }


    @When("User click deutsch language button")
    public void userClickDeutschLanguageButton() {
        changeLanguageAndCurrencyPage = pageFactoryManager.getChangeLanguageAndCurrencyPage();
        changeLanguageAndCurrencyPage.clickDeutschLanguage();
    }

    @And("User click submit button")
    public void userClickSubmitButton() {
        changeLanguageAndCurrencyPage.clickSubmitButton();
    }

    @Then("User checks url on {string} language visibility")
    public void userAllOnChosenLanguageVisibility(String DE) {
        System.out.println(homePage.checkUrlOnLanguageVisibility());
        assertTrue(homePage.checkUrlOnLanguageVisibility().contains(DE));
    }

    @When("User click old currency button")
    public void userClickOldCurrencyButton() {
        changeLanguageAndCurrencyPage = pageFactoryManager.getChangeLanguageAndCurrencyPage();
        changeLanguageAndCurrencyPage.clickSelectCurrencyButton();
    }

    @When("User click newCurrency")
    public void userClickNewCurrency() {
        changeLanguageAndCurrencyPage.clickEuroCurrency();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() throws InterruptedException {
        homePage = pageFactoryManager.getHomePage();
        homePage.searchFieldIsDisplayed();
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordProduct(String KEYWORD) {
        homePage.searchByKeyword(KEYWORD);
    }

    @Then("User checks that product have newCurrency")
    public void userChecksThatProductHaveNewCurrency() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertTrue(searchResultPage.checkThatItemHaveNewCurrency());
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSubmitSearch();
    }

    @And("User checks change deliver location button visibility")
    public void userChecksChangeDeliverLocationButtonVisibility() {
        homePage.changeDeliverLocationIsDisplayed();
    }

    @And("User clicks change deliver location button")
    public void userClicksChangeDeliverLocationButton() {
        homePage.clickDeliverLocation();
    }

    @And("User clicks enter US zip code field")
    public void userClicksEnterUSZipCodeField() {
        homePage.clickEnterUsZipCodeField();
    }

    @When("User enters {string} to field")
    public void userEntersZipCodeUsToField(String code) {
        homePage.enterZipCode(code);
    }


    @And("User clicks Accept")
    public void userClicksAccept() {
        homePage.clickAcceptZipCode();
    }

    @And("User clicks Continue")
    public void userClicksContinue() throws InterruptedException {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickContinueChangeZipCode();
    }

    @Then("User checks that location changed on {string} state")
    public void userChecksThatLocationChangedOnUSState(String location) {
        assertTrue(homePage.getLocationUS().contains(location));
    }

    @And("User clicks ship outside US field")
    public void userClicksShipOutsideUSField() {
        homePage.clickOutsideUsDropList();
    }

    @And("User clicks Canada")
    public void userClicksCanada() {
        homePage.clickCanadaLocation();
    }

    @And("User clicks Done")
    public void userClicksDone() {
        homePage.clickDoneLocation();
    }

    @And("User checks that location changed on {string}")
    public void userChecksThatLocationChangedOnCanada(String location) {
        assertTrue(homePage.getLocationCanada().contains(location));
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnProduct();
    }


    @And("User clicks add to cart")
    public void userClicksAddToCart() {
        searchResultPage.clickAddToCart();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void userChecksThatAmountOfProductsInCartAreAmountOfProductsInCart(String amount) {
        assertTrue(searchResultPage.getAmountOfProductsInCart().contains(amount));
    }

    @And("User clicks All button")
    public void userClicksAllButton() {
        homePage.clickAllButton();
    }

    @When("User checks sidebar elements visibility")
    public void userChecksSidebarCategoryElementVisibility() {
        homePage.sideBarElementVisibility();
    }

    @And("User clicks {string} element")
    public void userClicksSidebarCategoryButton(String sidebarCategory) {
        homePage.clickSideBarElement(sidebarCategory);
    }

    @And("User checks section visibility")
    public void userChecksSectionVisibility() {
        catalogResultPage = pageFactoryManager.getCatalogResultPage();
        catalogResultPage.visibilityOfSelectionCategory();
    }

    @And("User clicks {string} catalog")
    public void userClicksSelectionCategoryCatalog(String selectionCategory) {
        catalogResultPage.clickSideBarElement(selectionCategory);
    }

    @And("User checks products visibility")
    public void userChecksProductVisibility() {
        catalogResultPage.visibilityOfNeededProducts();
    }


    @And("User clicks {string}")
    public void userClicksProduct(String productName) {
        catalogResultPage.clickOnFirstProductWitchContainsKeyword(productName);
    }

    @Then("User checks {string} page visibility")
    public void userChecksProductPageVisibility(String productName) {
        assertTrue(catalogResultPage.visibilityOfProductPage(productName));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
