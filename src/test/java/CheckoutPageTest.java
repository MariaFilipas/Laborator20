import org.openqa.selenium.WebElement;
import org.pages.*;
import org.pages.account.AccountCreatedPage;
import org.pages.account.AccountPage;
import org.pages.account.RegisterAccountPage;
import org.pages.checkout.CheckoutPage;
import org.pages.checkout.CheckoutSuccessPage;
import org.pages.checkout.ConfirmOrderPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.util.TestUtil.generateRandomEmail;

public class CheckoutPageTest extends BaseTest {
    private String accountPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private AccountPage accountPage;

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Navigate to " + accountPageURL);
        driver.get(accountPageURL);

         accountPage = new AccountPage(driver);
        System.out.println("Navigate to " + registerPageURL);
        driver.get(registerPageURL);
        RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinueButton();
    }
    @Test
    public void placeOrderTest() throws InterruptedException {
        accountPage.enterTextToSearch("Nikon D300");
        accountPage.clickSearchButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<WebElement> results = searchResultsPage.getResults("Nikon D300");
        results.get(0).click();
        searchResultsPage.clickBuyNow();
        Thread.sleep(3000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertFirstName("John");
        checkoutPage.insertLastName("Doe");
        checkoutPage.insertAddressOne("Street one");
        checkoutPage.insertCity("Cluj-Napoca");
        checkoutPage.insertPostcode("400");
        checkoutPage.selectCountry("Romania");
        Thread.sleep(1000);
        checkoutPage.selectRegion("Cluj");
        checkoutPage.clickAgreeTermsAndConditions();
        Thread.sleep(1000);
        checkoutPage.clickContinueButton();
        Thread.sleep(5000);

        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage.clickConfirmOrderButton();
        Thread.sleep(3000);

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        String expectedMessage = "Your order has been placed!";
        String actualMessage = checkoutSuccessPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
