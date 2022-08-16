package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogResultPage extends BasePage {
    @FindBy(xpath = "//a[@class='a-link-normal s-navigation-item']")
    List<WebElement> selectionCategory;
    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    List<WebElement> products;
    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement titleOfProductOnProductPage;

    public CatalogResultPage(WebDriver driver) {
        super(driver);
    }

    public void visibilityOfSelectionCategory() {
        waitVisibilityOfElement(5, selectionCategory.get(2));
        waitVisibilityOfElement(5, selectionCategory.get(3));
    }

    public void visibilityOfNeededProducts() {
        waitVisibilityOfElement(5, products.get(0));
        waitVisibilityOfElement(5, products.get(1));
    }

    public boolean visibilityOfProductPage(String KEYWORD) {
        waitVisibilityOfElement(5, titleOfProductOnProductPage);
        return titleOfProductOnProductPage.getText().contains(KEYWORD);
    }

    public void clickOnFirstProductWitchContainsKeyword(String KEYWORD) {
        for (int i = 0; i <= products.size(); i++) {
            if (products.get(i).getText().contains(KEYWORD)) {
                products.get(i).click();
                break;
            }
        }
    }

    public void clickSideBarElement(String elementName) {
        for (int i = 0; i <= selectionCategory.size(); i++) {
            if (selectionCategory.get(i).getText().contains(elementName)) {
                selectionCategory.get(i).click();
                break;
            }
        }
    }
}
