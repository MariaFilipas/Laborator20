package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    private By errorMessage = By.xpath(".//div[@class = 'alert alert-danger alert-dismissible']");
    private By wishlistHeartElement = By.xpath(".//a[@aria-label = 'Wishlist']");
    private By searchInput = By.name("search");
    private By searchButton = By.xpath("//*[@id=\"search\"]/div[2]/button");

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickWishlist() {
        driver.findElement(wishlistHeartElement).click();
    }

    public void enterTextToSearch(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
    }
    public void clickSearchButton(){
        WebElement element = driver.findElement(searchButton);
        element.click();
    }


}
