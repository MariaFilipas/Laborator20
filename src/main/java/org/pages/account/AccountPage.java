package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class AccountPage extends BasePage {

    private By firstSectionHeader = By.xpath(".//div[@id = 'content']/div[1]/h2");

    private By editAccountInfoButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/edit')]");
    private By successAlert = By.xpath("//*[@id=\"account-account\"]/div[1]");
    private By changePasswordButton= By.xpath(".//div[@id='content']//a[contains(@href, 'account/password')]");
    private By subscribeUnsubscribeButton= By.xpath(".//div[@id='content']//a[contains(@href, 'account/newsletter')]");
    private By modifyWishlistButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/wishlist')]");
    private By modifyAddressEntriesButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/address')]");
    private By logoutButton = By.xpath("//*[@id=\"column-right\"]/div/a[14]");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFirstSectionHeaderText() {
        return driver.findElement(firstSectionHeader).getText();
    }

    public String getEditAccountElementText() {
        return driver.findElement(editAccountInfoButton).getText();
    }

    public String getChangePasswordElementText() {
        return driver.findElement(changePasswordButton).getText();
    }

    public String getModifyAddressElementText() {
        return driver.findElement(modifyAddressEntriesButton).getText();
    }

    public String getMyWishlistElementText() {
        return driver.findElement(modifyWishlistButton).getText();
    }

    public String getNewsletterElementText() {
        return driver.findElement(subscribeUnsubscribeButton).getText();
    }

    public void clickEditAccountButton(){
        WebElement element = driver.findElement(editAccountInfoButton);
        element.click();
    }

    public String getSuccessAlterMessage(){
        WebElement element = driver.findElement(successAlert);
        return element.getText();
    }
    public void clickChangePassword(){
        WebElement element = driver.findElement(changePasswordButton);
        element.click();
    }
    public void clickSubscribeUnuscribeButton(){
        WebElement element= driver.findElement(subscribeUnsubscribeButton);
        element.click();
    }

    public void clickLogout(){
        WebElement element = driver.findElement(logoutButton);
        element.click();
    }
    public void clickModifyAddressEntitiesButton(){
        WebElement element = driver.findElement(modifyAddressEntriesButton);
        element.click();
    }
}
