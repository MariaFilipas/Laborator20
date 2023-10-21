package org.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.BasePage;

public class AccountReturnPage extends BasePage {

    private By reasonToReturn = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[3]/label/input");
    private By submitButton = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");

    public AccountReturnPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectReasonToReturn(String reasonToReturnValue){
        WebElement element = driver.findElement(reasonToReturn);
        element.click();

    }

    public void clickSubmitButton(){
        WebElement element = driver.findElement(submitButton);
        element.click();
    }
}
