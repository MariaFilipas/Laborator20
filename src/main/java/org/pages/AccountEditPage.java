package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountEditPage extends BasePage {
    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
    public AccountEditPage(WebDriver driver){
        this.driver = driver;
    }

    public void updatePhoneNumber(String phoneNumber) {
        WebElement element = driver.findElement(telephoneInput);
        element.clear();
        element.sendKeys(phoneNumber);
    }

    public void clickContinueButton(){
        WebElement element = driver.findElement(continueButton);
        element.click();
    }


}
