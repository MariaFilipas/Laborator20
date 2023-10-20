package org.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class ConfirmOrderPage extends BasePage {

    private By confirmOrderButton = By.id("button-confirm");

    public ConfirmOrderPage(WebDriver driver){
      this.driver = driver;
    }

    public void clickConfirmOrderButton(){
        WebElement element = driver.findElement(confirmOrderButton);
        element.click();
    }
}
