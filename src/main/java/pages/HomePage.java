package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage {
    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-us']")
    WebElement LanguageAndCurrency;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement Authorization;
    @FindBy(xpath = "//h4[text()='Important Message!']")
    WebElement catchCapture;
    @FindBy(xpath = "//a[@href]/span[text()='Deutsch']")
    WebElement deutschLanguage;
    @FindBy(xpath = "//input[@name='field-keywords']")
    WebElement searchField;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement submitSearch;
    @FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
    WebElement deliverLocation;
    @FindBy(xpath = "//input[@class='GLUX_Full_Width a-declarative']")
    WebElement zipCodeField;
    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    WebElement outsideUsDropList;
    @FindBy(xpath = "//input[@aria-labelledby='GLUXZipUpdate-announce']")
    WebElement acceptZipCode;
    @FindBy(xpath = "//button[@name='glowDoneButton']")
    WebElement doneChangeLocationButton;
    @FindBy(xpath = "//span[@id='GLUXConfirmClose-announce']")
    WebElement continueChangeZipCode;
    @FindBy(xpath = "//span[contains(text(),'90202')]")
    WebElement locationUS;
    @FindBy(xpath = "//span[contains(text(),'Canada')]")
    WebElement locationCanada;
    @FindBy(xpath = "//a[contains(text(),'Canada')]")
    WebElement canadaLocation;
    @FindBy(xpath = "//span[@class='hm-icon-label']")
    WebElement allButton;
    @FindBy(xpath = "//a[@class='hmenu-item']")
    List<WebElement> sideBarElements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void sideBarElementVisibility() {
        waitVisibilityOfElement(5, sideBarElements.get(0));
    }

    public void clickSideBarElement(String elementName) {
        for (int i = 0; i <= sideBarElements.size(); i++) {
            if (sideBarElements.get(i).getText().contains(elementName)) {
                sideBarElements.get(i).click();
                break;
            }
        }
    }

    public void clickAllButton() {
        allButton.click();
    }

    public void openLogInPage() {
        waitForPageLoadComplete(5);
        Authorization.click();
    }

    public void openLanguageAndCurrencyPage() {
        LanguageAndCurrency.click();
    }

    public boolean captureMessageIsDisplayed() {
        return catchCapture.isDisplayed();
    }

    public String checkUrlOnLanguageVisibility() {
        waitVisibilityOfElement(5, deutschLanguage);
        return deutschLanguage.getText();
    }

    public boolean searchFieldIsDisplayed() throws InterruptedException {
        sleep(1200); //workaround for issue after currency change
        return searchField.isDisplayed();
    }

    public void searchByKeyword(String KEYWORD) {
        searchField.click();
        searchField.sendKeys(KEYWORD);
    }

    public void clickSubmitSearch() {
        submitSearch.click();
    }

    public boolean changeDeliverLocationIsDisplayed() {
        return deliverLocation.isDisplayed();
    }

    public void clickDeliverLocation() {
        deliverLocation.click();
    }

    public void clickEnterUsZipCodeField() {
        waitVisibilityOfElement(2, zipCodeField);
        zipCodeField.click();
    }

    public void enterZipCode(String KEYWORD) {
        zipCodeField.click();
        zipCodeField.sendKeys(KEYWORD);
    }

    public void clickAcceptZipCode() {
        acceptZipCode.click();
    }

    public void clickContinueChangeZipCode() throws InterruptedException {
        sleep(1000); //workaround for issue
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", continueChangeZipCode);
    }

    public String getLocationUS() {
        waitVisibilityOfElement(5, locationUS);
        return locationUS.getText();
    }

    public String getLocationCanada() {
        waitVisibilityOfElement(5, locationCanada);
        return locationCanada.getText();
    }

    public void clickOutsideUsDropList() {
        waitVisibilityOfElement(5, outsideUsDropList);
        outsideUsDropList.click();
    }

    public void clickCanadaLocation() {
        canadaLocation.click();
    }

    public void clickDoneLocation() {
        doneChangeLocationButton.click();
    }
}
