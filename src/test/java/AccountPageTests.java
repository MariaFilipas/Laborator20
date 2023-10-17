import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.util.TestUtil.generateRandomEmail;

public class AccountPageTests extends BaseTest {

    private String accountPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    private AccountPage accountPage;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + accountPageURL);
        driver.get(accountPageURL);
        driver.manage().window().fullscreen();

        accountPage = new AccountPage(driver);
    }

    @Test
    public void editAccountInformationTest() {
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
        accountPage.clickEditAccountButton();
        AccountEditPage accountEditPage = new AccountEditPage(driver);
        accountEditPage.updatePhoneNumber("01233");

        accountEditPage.clickContinueButton();

        String actualResult = accountPage.getSuccessAlterMessage();
        String expectedResult = "Success: Your account has been successfully updated.";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void changePasswordTest() {
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
        accountPage.clickChangePassword();
        AccountChangePasswordPage accountChangePasswordPage = new AccountChangePasswordPage(driver);
        accountChangePasswordPage.setPassword("1234");
        accountChangePasswordPage.setPasswordConfirm("1234");

        accountChangePasswordPage.clickContinueButton();

        String actualResult = accountPage.getSuccessAlterMessage();
        String expectedResult = "Success: Your password has been successfully updated.";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subscribeUnsubscribeToNewsletter() {
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
        accountPage.clickSubscribeUnuscribeButton();
        AccountSubscribeNewsletterPage accountSubscribeNewsletterPage = new AccountSubscribeNewsletterPage(driver);

        accountSubscribeNewsletterPage.setClickContinueButton();

        String actualResult = accountPage.getSuccessAlterMessage();
        String expectedResult = "Success: Your newsletter subscription has been successfully updated!";
        Assert.assertEquals(actualResult, expectedResult);
    }
}