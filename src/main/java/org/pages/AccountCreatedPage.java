package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends BasePage{

    private By paragraphElement = By.xpath("//div[@id='content']/p[2]");
    private By logoutButton = By.xpath("//*[@id=\"column-right\"]/div/a[14]");


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

}
