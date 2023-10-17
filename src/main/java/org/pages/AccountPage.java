package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage{

    private By editAccountInfoButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/div[1]/a");
    private By successAlert = By.xpath("//*[@id=\"account-account\"]/div[1]");
    private By changePasswordButton= By.xpath("//*[@id=\"content\"]/div[1]/div/div/div[2]/a");
    private By subscribeUnsubscribeButton= By.xpath("//*[@id=\"content\"]/div[1]/div/div/div[5]/a");
    public AccountPage(WebDriver driver){
        this.driver = driver;
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
}
