package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountChangePasswordPage extends BasePage{

    private By passwordInput = By.id("input-password");
    private By passwordConfirmInput = By.id("input-confirm");
    private By continueButton = By.xpath("//*[@id=\"content\"]/form/div[3]/div[2]/input");
    public AccountChangePasswordPage(WebDriver driver){
        this.driver= driver;

    }
    public void setPassword(String password) {

        WebElement element = driver.findElement(passwordInput);
        element.clear();
        element.sendKeys(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        WebElement element = driver.findElement(passwordConfirmInput);
        element.clear();
        element.sendKeys(passwordConfirm);
    }
    public void clickContinueButton(){
        WebElement element = driver.findElement(continueButton);
        element.click();
    }
}
