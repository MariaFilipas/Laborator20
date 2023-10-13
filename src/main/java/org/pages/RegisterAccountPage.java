package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage extends BasePage {


    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By passwordConfirmInput = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By firstNameErrorMessage = By.xpath(".//input[@name = 'firstname']/following-sibling::div");
    private By lastNameErrorMessage = By.xpath("//*[@id=\"account\"]/div[3]/div/div");
    private By emailErrorMessage = By.xpath("//*[@id=\"account\"]/div[4]/div/div");
    private By telephoneErrorMessage = By.xpath("//*[@id=\"account\"]/div[5]/div/div");
    private By passwordErrorMessage = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");
    private By confirmPasswordErrorMessage = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div");
    private By privacyPolicyCheckboxErrorMessage = By.xpath("//*[@id=\"account-register\"]/div[1]");


    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPhoneNumber(String phoneNumber) {
        driver.findElement(telephoneInput).sendKeys(phoneNumber);
    }

    public void setPassword(String password) {

        WebElement element = driver.findElement(passwordInput);
        element.sendKeys(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        WebElement element = driver.findElement(passwordConfirmInput);
        element.sendKeys(passwordConfirm);
    }

    public void checkPrivacyPolicy() {
        WebElement element = driver.findElement(privacyPolicyCheckbox);
        element.click();
    }

    public String getFirstNameErrorMessage() {
        WebElement element = driver.findElement(firstNameErrorMessage);
        return element.getText();
    }

    public String getLastNameErrorMessage() {
        WebElement element = driver.findElement(lastNameErrorMessage);
        return element.getText();
    }

    public String getEmailErrorMessage() {
        WebElement element = driver.findElement(emailErrorMessage);
        return element.getText();
    }

    public String getTelephoneErrorMessage() {
        WebElement element = driver.findElement(telephoneErrorMessage);
        return element.getText();
    }

    public String getPasswordErrorMessage() {
        WebElement element = driver.findElement(passwordErrorMessage);
        return element.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        WebElement element = driver.findElement(confirmPasswordErrorMessage);
        return element.getText();
    }


    public void clickContinue() {
        WebElement element = driver.findElement(continueButton);
        element.click();
    }
}
