import org.openqa.selenium.NoSuchElementException;
import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.util.TestUtil.generateRandomEmail;

public class RegisterAccountTests extends BaseTest {

    private RegisterAccountPage registerAccountPage;
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + registerPageURL);
        driver.get(registerPageURL);
        registerAccountPage = new RegisterAccountPage(driver);
    }

    @Test
    public void registerNewAccountMandatoryFieldsTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void registerWithoutPrivacyPolicyTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutFirstNameTest() {
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getFirstNameErrorMessage();
        String expectedValue = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutLastNameTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getLastNameErrorMessage();
        String expectedValue = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutEmailTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getEmailErrorMessage();
        String expectedValue = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutTelephoneTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getTelephoneErrorMessage();
        String expectedValue = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutPasswordTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getPasswordErrorMessage();
        String expectedValue = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutPasswordConfirmationTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.checkPrivacyPolicy();

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getConfirmPasswordErrorMessage();
        String expectedValue = "Password confirmation does not match password!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutAnyFieldTest() {
        registerAccountPage.clickContinue();

        String actualValueFirstName = registerAccountPage.getFirstNameErrorMessage();
        String expectedValueFirstName = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValueFirstName, expectedValueFirstName, "Error message is not the expected one.");

        String actualValueLastName = registerAccountPage.getLastNameErrorMessage();
        String expectedValueLastName = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValueLastName, expectedValueLastName, "Error message is not the expected one.");

        String actualValueEmail = registerAccountPage.getEmailErrorMessage();
        String expectedValueEmail = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualValueEmail, expectedValueEmail, "Error message is not the expected one.");

        String actualValueTelephone = registerAccountPage.getTelephoneErrorMessage();
        String expectedValueTelephone = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualValueTelephone, expectedValueTelephone, "Error message is not the expected one.");

        String actualValuePassword = registerAccountPage.getPasswordErrorMessage();
        String expectedValuePassword = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValuePassword, expectedValuePassword, "Error message is not the expected one.");


    }

}

