package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public CatalogResultPage getCatalogResultPage() {
        return new CatalogResultPage(driver);
    }

    public ChangeLanguageAndCurrencyPage getChangeLanguageAndCurrencyPage() {
        return new ChangeLanguageAndCurrencyPage(driver);
    }

    public LogInPage getLogInPage() {
        return new LogInPage(driver);
    }

    public RegisterPage getRegisterPage() {
        return new RegisterPage(driver);
    }
}
