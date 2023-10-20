package org.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class CheckoutSuccessPage extends BasePage {

    private By successMessage = By.xpath("//*[@id=\"content\"]/h1");

    public CheckoutSuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessMessage(){
        WebElement element = driver.findElement(successMessage);
        return element.getText();
    }
}
