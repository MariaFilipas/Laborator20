package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pages.BasePage;

public class AddressAddPage extends BasePage {

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By addressOneInput = By.name("address_1");
    private By cityInput = By.id("input-city");

    private By postCodeInput = By.id("input-postcode");
    private By countryInput = By.id("input-country");
    private By regionInput = By.id("input-zone");
    private By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");


    public AddressAddPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameInput);
        element.sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        WebElement element = driver.findElement(lastNameInput);
        element.sendKeys(lastName);
    }

    public void insertAddressOne(String addressOne) {
        WebElement element = driver.findElement(addressOneInput);
        element.sendKeys(addressOne);
    }

    public void insertCity(String city) {
        WebElement element = driver.findElement(cityInput);
        element.sendKeys(city);
    }
    public void insertPostcode(String postcode) {
        WebElement element = driver.findElement(postCodeInput);
        element.sendKeys(postcode);
    }
    public void selectCountry(String country) {
        WebElement element = driver.findElement(countryInput);
        Select select =new Select(element);
        select.selectByVisibleText(country);
    }
    public void selectRegion(String region) {
        WebElement element = driver.findElement(regionInput);
        Select select =new Select(element);
        select.selectByVisibleText(region);
    }

    public void clickContinueButton(){
        WebElement element = driver.findElement(continueButton);
        element.click();
    }
}
