package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pages.BasePage;

public class ProductReturnPage extends BasePage {

    private By returnMessage = By.xpath("//*[@id=\"content\"]/p[2]");
    public ProductReturnPage(WebDriver  driver){
        this.driver = driver;
    }

    public String getReturnMessage() {
        WebElement element = driver.findElement(returnMessage);
        return element.getText();
    }
}
