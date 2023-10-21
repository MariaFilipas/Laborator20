package org.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class ShippingCartPage extends BasePage {

    private By emptyShoppingCartText = By.xpath("//*[@id=\"content\"]/p");

    public ShippingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getEmptyShippingCartMessage(){
        WebElement element = driver.findElement(emptyShoppingCartText);
        return element.getText();
    }
}
