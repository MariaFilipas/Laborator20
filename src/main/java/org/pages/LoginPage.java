package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.xpath(".//input[@value = 'Login']");

    private By loginAlert = By.xpath("//*[@id=\"account-login\"]/div[1]");

    private By forgottenPassword=By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/div[2]/a");
    private By passwordResetConfirmationAlert = By.xpath("//*[@id=\"account-login\"]/div[1]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickForgottenPassword(){
        WebElement forgottenPassElement = driver.findElement(forgottenPassword);
        forgottenPassElement.click();
    }
    public String getLoginAlertMessage(){
        WebElement element = driver.findElement(loginAlert);
        return element.getText();
    }
    public String getPasswordResetConfirmationAlertMessage(){
        WebElement element;
        element = driver.findElement(passwordResetConfirmationAlert);
        return element.getText();
    }
}
