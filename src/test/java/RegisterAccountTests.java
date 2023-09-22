import org.example.AccountCreatedPage;
import org.example.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterAccountTests {
@BeforeMethod
@Test
    public void registerAccountMandatoryFieldsTest() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register")
    RegisterAccountPage registerAccountPage= new RegisterAccountPage(driver);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        Random random=new Random();
        registerAccountPage.insertEmail("johndoe"+random.nextLong()+"gmail.com");
        registerAccountPage.insertPhoneNumber();
        registerAccountPage.setPassword();
        registerAccountPage.setPasswordConfirm();
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContiunue();
        AccountCreatedPage accountCreatedPage= new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText="Congratulations! Your new account has been successfully created!"


    }
}
