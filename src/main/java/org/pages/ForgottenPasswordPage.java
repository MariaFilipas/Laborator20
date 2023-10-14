package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgottenPasswordPage extends BasePage {
    private By inputEmailAddress = By.id("input-email");
    private By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div[2]/button");

    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertEmailAddress(String emailAddress){
    WebElement element;
    element = driver.findElement(inputEmailAddress);
    element.sendKeys(emailAddress);
    }

    public void clickContinueButton(){
        WebElement element = driver.findElement(continueButton);
        element.click();
    }
}
