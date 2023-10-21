package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

import java.util.List;

public class AccountOrderInfoPage extends BasePage {
    private By returnButtons = By.xpath(".//div[@id='content']//a[contains(@href, 'return/add')]");

    public AccountOrderInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getReturnButtons(){
        List<WebElement> elementList = driver.findElements(returnButtons);
        return elementList;
    }
}
