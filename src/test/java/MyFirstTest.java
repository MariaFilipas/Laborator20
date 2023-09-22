import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/magento-test/");
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("sale");
        searchBox.submit();
        WebElement searchResultTextElement = driver.findElement(By.className("note-msg"));
        String actualText = searchResultTextElement.getText();
        String expectedText = "Your search returns no results.";
        Assert.assertEquals(actualText, expectedText);
    }

}
