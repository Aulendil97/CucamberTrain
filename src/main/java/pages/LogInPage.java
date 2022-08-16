package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends BasePage {
    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement sighInButton;
    @FindBy(xpath = "//a[contains(text(),'Create your Amazon account')]")
    WebElement createNewAccount;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public boolean emailFieldIsDisplayed() {
        waitVisibilityOfElement(5, emailField);
        return emailField.isDisplayed();
    }

    public void emailFieldClick() {
        emailField.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void passwordFieldClick() {
        passwordField.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSighIn() {
        sighInButton.click();
    }

    public boolean checkVisibilityOfRegisterButton() {
        waitVisibilityOfElement(5, createNewAccount);
        return createNewAccount.isDisplayed();
    }

    public void clickCreateNewAccount() {
        waitVisibilityOfElement(10, createNewAccount);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", createNewAccount);
    }
}
