package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
    List<WebElement> product;
    @FindBy(xpath = "//span[@class='a-price-symbol']")
    WebElement currencyOfProduct;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    WebElement Cart;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkThatItemHaveNewCurrency() {
        return currencyOfProduct.getText().contains("EUR");
    }

    public void clickOnProduct() {
        waitVisibilityOfElement(1, product.get(0));
        product.get(0).click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public String getAmountOfProductsInCart() {
        return Cart.getText();
    }
}
