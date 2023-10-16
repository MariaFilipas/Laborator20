package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By resultItems = By.xpath("//*[@id=\"mz-product-grid-image-31-212469\"]/div/div[1]/img");

    private By addToWishlistButton = By.xpath(".//button[@title = 'Add to Wish List']");

    private By closePopupButton = By.xpath(".//button[@aria-label = 'Close']");

    public void clickFirstItem() {
        driver.findElements(resultItems).get(0).click();
    }

    public WebElement getFirstItem() {
        return driver.findElements(resultItems).get(0);
    }

    public List<WebElement> getResults(String productName){
        String xPath = ".//div[@class = 'carousel-item active']/img[contains(@title, '"+productName+"')]";
        By results = By.xpath(xPath);
        return driver.findElements(results);
    }

    public WebElement getAddToWishlistButton() {
        return driver.findElements(addToWishlistButton).get(0);
    }

    public void addFirstItemToWishlist() {
        driver.findElements(addToWishlistButton).get(0).click();
    }

    public void clickClosePopupButton() {
        driver.findElement(closePopupButton).click();
    }
}
