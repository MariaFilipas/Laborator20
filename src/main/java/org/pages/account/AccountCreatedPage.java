package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class AccountCreatedPage extends BasePage {

    private By paragraphElement = By.xpath("//div[@id='content']/p[2]");
    private By logoutButton = By.xpath("//*[@id=\"column-right\"]/div/a[14]");
    private By continueButton = By.xpath("//*[@id=\"content\"]/div/a");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getParagraphText() {
        return driver.findElement(paragraphElement).getText();
    }
    public void clickLogout(){
        WebElement element = driver.findElement(logoutButton);
        element.click();
    }
    public void clickContinueButton(){
        WebElement element = driver.findElement(continueButton);
        element.click();
    }

}
