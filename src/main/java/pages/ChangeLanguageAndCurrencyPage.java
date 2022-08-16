package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeLanguageAndCurrencyPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Deutsch ')]")
    WebElement deutschLanguage;
    @FindBy(xpath = "//input[@aria-labelledby='icp-save-button-announce']")
    WebElement submitButton;
    @FindBy(xpath = "//span[@data-csa-c-func-deps='aui-da-a-dropdown-button']")
    WebElement selectCurrencyButton;
    @FindBy(xpath = "//span[contains(text(),'EUR')]")
    WebElement euroCurrency;

    public ChangeLanguageAndCurrencyPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeutschLanguage() {
        deutschLanguage.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickSelectCurrencyButton() {
        selectCurrencyButton.click();
    }

    public void clickEuroCurrency() {
        euroCurrency.click();
    }
}
