package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSubscribeNewsletterPage extends BasePage{

    private By clickContinueButton= By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");

    public AccountSubscribeNewsletterPage(WebDriver driver){
        this.driver = driver;
    }
    public void setClickContinueButton() {
        WebElement element = driver.findElement(clickContinueButton);
        element.click();
    }
}
