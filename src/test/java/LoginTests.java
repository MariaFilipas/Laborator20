import org.pages.account.AccountCreatedPage;
import org.pages.login.ForgottenPasswordPage;
import org.pages.login.LoginPage;
import org.pages.account.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.util.TestUtil;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURL);
        driver.get(loginPageURL);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void validCredentialsTest() {
        String emailAddress = TestUtil.generateRandomEmail();
        String password = "123abc";
        System.out.println("Go to " + registerPageURL);
        driver.get(registerPageURL);
        RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(emailAddress);
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword(password);
        registerAccountPage.setPasswordConfirm(password);
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickLogout();
        driver.get(loginPageURL);
        loginPage.insertEmail(emailAddress);
        loginPage.insertPassword(password);

        loginPage.clickLogin();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
        Assert.assertEquals(actualUrl, expectedUrl, "Actual URL is not the same as the expected URL");


    }

    @Test
    public void invalidCredentialsTest() {
        loginPage.insertEmail(TestUtil.generateRandomEmail());
        loginPage.insertPassword("randomPassword");

        loginPage.clickLogin();

        String actualValue = loginPage.getErrorMessage();
        String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void inexistingAccountTest() {
        loginPage.insertEmail(TestUtil.generateRandomEmail());
        loginPage.insertPassword("1234");

        loginPage.clickLogin();

        String actualMessage = loginPage.getLoginAlertMessage();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void maximumExceededAttemptsTest() {
        loginPage.insertEmail(TestUtil.generateRandomEmail());
        loginPage.insertPassword("1234");
        loginPage.clickLogin();
        loginPage.clickLogin();
        loginPage.clickLogin();
        loginPage.clickLogin();
        loginPage.clickLogin();

        loginPage.clickLogin();

        String actualMessage = loginPage.getLoginAlertMessage();
        String expectedMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void forgottenPasswordTest() {
        String emailAddress = TestUtil.generateRandomEmail();
        String password = "123abc";
        System.out.println("Go to " + registerPageURL);
        driver.get(registerPageURL);
        RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(emailAddress);
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword(password);
        registerAccountPage.setPasswordConfirm(password);
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickLogout();
        driver.get(loginPageURL);
        loginPage.clickForgottenPassword();
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        forgottenPasswordPage.insertEmailAddress(emailAddress);

        forgottenPasswordPage.clickContinueButton();

        String expectedText = "An email with a confirmation link has been sent your email address.";
        String actualText = loginPage.getPasswordResetConfirmationAlertMessage();
        Assert.assertEquals(actualText,expectedText);
    }
}
