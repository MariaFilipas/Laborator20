import org.openqa.selenium.WebElement;
import org.pages.account.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.util.TestUtil.generateRandomEmail;

public class AccountPageTests extends BaseTest {

    private String accountPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    private AccountPage accountPage;

    @BeforeMethod
    public void beforeMethod() {
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

    @AfterMethod
    public void afterMethod(){
        accountPage.clickLogout();
    }

    @Test
    public void verifyDashboardFirstSection() {
        String expectedFirstSectionHeaderText = "My Account";
        String expectedEditAccountElementText = "Edit your account information";
        String expectedChangePasswordElementText = "Change your password";
        String expectedModifyAddressElementText = "Modify your address book entries";
        String expectedModifyWishlistElementText = "Modify your wish list";
        String expectedNewsletterElementText = "Subscribe / unsubscribe to newsletter";

        Assert.assertEquals(accountPage.getFirstSectionHeaderText(), expectedFirstSectionHeaderText,
                "First section header text is not the expected one");
        Assert.assertEquals(accountPage.getEditAccountElementText(), expectedEditAccountElementText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(accountPage.getChangePasswordElementText(), expectedChangePasswordElementText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(accountPage.getModifyAddressElementText(), expectedModifyAddressElementText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(accountPage.getMyWishlistElementText(), expectedModifyWishlistElementText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(accountPage.getNewsletterElementText(), expectedNewsletterElementText,
                "Edit account element text is not the expected one");
    }

    @Test
    public void editAccountInformationTest() {
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
    public void subscribeUnsubscribeToNewsletterTest() {
        accountPage.clickSubscribeUnuscribeButton();
        AccountSubscribeNewsletterPage accountSubscribeNewsletterPage = new AccountSubscribeNewsletterPage(driver);

        accountSubscribeNewsletterPage.setClickContinueButton();

        String actualResult = accountPage.getSuccessAlterMessage();
        String expectedResult = "Success: Your newsletter subscription has been successfully updated!";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void addNewAddressTest() throws InterruptedException {
        accountPage.clickModifyAddressEntitiesButton();
        AccountModifyAddressPage accountModifyAddressPage = new AccountModifyAddressPage(driver);
        accountModifyAddressPage.clickNewAddressButton();
        AddressAddPage addressAddPage = new AddressAddPage(driver);
        addressAddPage.insertFirstName("John");
        addressAddPage.insertLastName("Doe");
        addressAddPage.insertAddressOne("Street one");
        addressAddPage.insertCity("Cluj-Napoca");
        addressAddPage.insertPostcode("400");
        addressAddPage.selectCountry("Romania");
        Thread.sleep(1000);
        addressAddPage.selectRegion("Cluj");

        addressAddPage.clickContinueButton();

        String expectedMessage = "Your address has been successfully added";
        String actualMessage = accountModifyAddressPage.getAlertMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void addNewAddressAndDeleteTest() throws InterruptedException {
        accountPage.clickModifyAddressEntitiesButton();
        AccountModifyAddressPage accountModifyAddressPage = new AccountModifyAddressPage(driver);
        accountModifyAddressPage.clickNewAddressButton();
        AddressAddPage addressAddPage = new AddressAddPage(driver);
        addressAddPage.insertFirstName("John");
        addressAddPage.insertLastName("Doe");
        addressAddPage.insertAddressOne("Street one");
        addressAddPage.insertCity("Cluj-Napoca");
        addressAddPage.insertPostcode("400");
        addressAddPage.selectCountry("Romania");
        Thread.sleep(1000);
        addressAddPage.selectRegion("Cluj");
        addressAddPage.clickContinueButton();
        List<WebElement> deleteButtons = accountModifyAddressPage.getDeleteButtons();

        deleteButtons.get(0).click();

        String expectedMessage = "Warning: You must have at least one address!";
        String actualMessage = accountModifyAddressPage.getAlertMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void addMultipleNewAddressAndDeleteTest() throws InterruptedException {
        accountPage.clickModifyAddressEntitiesButton();
        AccountModifyAddressPage accountModifyAddressPage = new AccountModifyAddressPage(driver);
        for(int i =0; i<5; i++) {
            accountModifyAddressPage.clickNewAddressButton();
            AddressAddPage addressAddPage = new AddressAddPage(driver);
            addressAddPage.insertFirstName("John");
            addressAddPage.insertLastName("Doe");
            addressAddPage.insertAddressOne("Street one");
            addressAddPage.insertCity("Cluj-Napoca");
            addressAddPage.insertPostcode("400");
            addressAddPage.selectCountry("Romania");
            Thread.sleep(1000);
            addressAddPage.selectRegion("Cluj");
            addressAddPage.clickContinueButton();
        }
        List<WebElement> deleteButtons = accountModifyAddressPage.getDeleteButtons();

        deleteButtons.get(0).click();

        String expectedMessage = "Your address has been successfully deleted";
        String actualMessage = accountModifyAddressPage.getAlertMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}