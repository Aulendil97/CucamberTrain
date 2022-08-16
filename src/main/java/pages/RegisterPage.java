package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//input[@id='ap_customer_name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passField;
    @FindBy(xpath = "//input[@name='passwordCheck']")
    WebElement checkPasswordField;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class='a-alert-content']")
    List<WebElement> invalidCredentialsMessage;
    @FindBy(xpath = "//div[@class='a-box a-alert a-alert-warning a-spacing-base']")
    WebElement credentialsPassed;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        nameField.click();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passField.click();
        passField.sendKeys(pass);
    }

    public void enterPasswordCheck(String passwordCheck) {
        checkPasswordField.click();
        checkPasswordField.sendKeys(passwordCheck);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean invalidEmailMessageIsPresent(String s) {
        boolean a = false;
        for (int i = 0; i <= invalidCredentialsMessage.size(); i++) {
            if (invalidCredentialsMessage.get(i).getText().contains(s)) {
                a = true;
                break;
            } else {
                a = false;
            }
        }
        return a;
    }

    public boolean credentialsPassedMessageIsPresent() {
        return credentialsPassed.isDisplayed();
    }
}
