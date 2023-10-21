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
    private By myOrdersText = By.xpath("//*[@id=\"content\"]/div[2]/h2");
    private By orderHistoryButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/order')]");
    private By downloadsButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/download')]");
    private By rewardButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/reward')]");
    private By returnButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/return')]");

    private By transactionsButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/transaction')]");

    private By recurringPaymentsButton = By.xpath(".//div[@id='content']//a[contains(@href, 'account/recurring')]");

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

    public String getMyOrdersElementText(){
        WebElement element = driver.findElement(myOrdersText);
        return element.getText();
    }
    public String getOrderHistoryElementText(){
        WebElement element = driver.findElement(orderHistoryButton);
        return element.getText();
    }
    public String getDownloadsElementText(){
        WebElement element = driver.findElement(downloadsButton);
        return element.getText();
    }
    public String getRewardsElementText(){
        WebElement element = driver.findElement(rewardButton);
        return element.getText();
    }
    public String getReturnsElementText(){
        WebElement element = driver.findElement(returnButton);
        return element.getText();
    }
    public String getTransactionsElementText(){
        WebElement element = driver.findElement(transactionsButton);
        return element.getText();
    }

    public String getRecurringPaymentsElementText(){
        WebElement element = driver.findElement(recurringPaymentsButton);
        return element.getText();
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

    public void clickOrderHistoryButton() {
        WebElement element = driver.findElement(orderHistoryButton);
        element.click();
    }
}
