package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

import java.util.List;

public class AccountOrderPage extends BasePage {

    private By orderRows = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr");
    private By orderInfoButtons = By.xpath(".//div[@id='content']//a[contains(@href, 'order/info')]");
    public AccountOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getOrderRows(){
        List<WebElement> elementList = driver.findElements(orderRows);
        return elementList;
    }

    public List<WebElement> getOrderInfoButtons() {
        List<WebElement> elements = driver.findElements(orderInfoButtons);
        return elements;
    }
}
