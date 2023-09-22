import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TemaLab17MariaFilipasTest {
    @Test
    void testLogoButtonRedirectsToHomepage(){
        WebDriver driver= new ChromeDriver();
        driver.get("http://testfasttrackit.info/magento-test/");

        WebElement logo= driver.findElement(By.className("logo"));
        logo.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="http://testfasttrackit.info/magento-test/";
        Assert.assertEquals(actualUrl,expectedUrl);


    }
}
