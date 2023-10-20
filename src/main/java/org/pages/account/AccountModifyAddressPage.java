package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

import java.util.List;

public class AccountModifyAddressPage extends BasePage {

    private By newAddressButton = By.xpath(".//div[@id='content']//a[contains(@href, 'address/add')]");
    private By alertMessage = By.xpath("//*[@id=\"account-address\"]/div[1]");
    private By deleteButtons = By.xpath(".//div[@id='content']//a[contains(@href, 'address/delete')]");


    public AccountModifyAddressPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickNewAddressButton(){
        WebElement element = driver.findElement(newAddressButton);
        element.click();
    }

    public String getAlertMessage(){
        WebElement element = driver.findElement(alertMessage);
        return element.getText();
    }

    public List<WebElement> getDeleteButtons() {
        List<WebElement> elements = driver.findElements(deleteButtons);
        return elements;
    }
}
