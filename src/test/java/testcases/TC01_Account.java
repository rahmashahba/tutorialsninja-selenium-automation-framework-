package testcases;

import Pages.P01_Home_Page;
import Pages.P03_account_Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Utilty;

import static drivers.DriverHolder.getDriver;

public class TC01_Account extends testbase {

    P01_Home_Page homePage;
    P03_account_Page accountPage;

    @Test(priority = 1, description = "logout successfully!")
    public void logout_successfully() throws InterruptedException {
        Thread.sleep(10000);

        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());

        homePage.Click_my_acount();
        homePage.Click_Login();

        accountPage.new_login(Utilty.RandomDataGenerator.CredentialsHolder.email, Utilty.RandomDataGenerator.CredentialsHolder.password);
        Thread.sleep(3000);
        accountPage.my_Account_with_in();
        accountPage.setLogout();
        // Assert - Positive verification
        Assert.assertTrue(accountPage.isLoginLinkDisplayed(), "You have been logged off your account. It is now safe to leave the computer");

        // Optional negative assertion - verify user is no longer logged in
        Assert.assertTrue(accountPage.isMyAccountVisible(), "My Account should not be visible after logout");
        // Then verify logout was successful
        //Assert.assertTrue(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/logout","Login link should be visible after logout");
        Thread.sleep(1000);
        accountPage.accountLogout_confirmation_msg();

    }

    // Negative test case - verify logout when already logged out
    @Test(priority = 2, description = "Verify logout fails when user is not logged in")
    public void logout_whenNotLoggedIn_shouldFail() throws InterruptedException {
        // Arrange - ensure we're logged out
        P01_Home_Page homePage = new P01_Home_Page(getDriver());
        P03_account_Page account = new P03_account_Page(getDriver());

        // Act & Assert - verify logout throws appropriate exception or shows message
        try {
            account.my_Account_with_in(); // This should fail if not logged in
            account.setLogout();
            Assert.assertTrue(!homePage.isLoginLinkDisplayed(), "Logout should not be possible when not logged in");
        } catch (Exception e) {
            // Verify correct error message or state
            Assert.assertTrue(homePage.isLoginLinkDisplayed(), "App should handle logout attempt when not logged in");
        }
    }

    @Test(priority = 3, description = "login with vailed data")
    public void login_with_vailed_data_Passed() throws InterruptedException {

        Thread.sleep(3000);
        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());
        // Use the stored credentials
        System.out.println("Using credentials: " + Utilty.RandomDataGenerator.CredentialsHolder.email + " " + Utilty.RandomDataGenerator.CredentialsHolder.password);

        homePage.Click_my_acount();
        homePage.Click_Login();
        accountPage.new_login(Utilty.RandomDataGenerator.CredentialsHolder.email, Utilty.RandomDataGenerator.CredentialsHolder.password);
        Thread.sleep(3000);
        // Assert - Positive verification
        Assert.assertTrue(accountPage.isMyAccountVisible(), "My Account should be visible after successful login");
        Thread.sleep(300);
        // Assert - Negative verification (optional)
        Assert.assertFalse(!accountPage.isMyAccountVisible(), "Login link should not be visible after successful login");
    }

    // Negative test case - login with invalid data
    @Test(priority = 4, description = "Login with invalid credentials should fail")
    public void login_with_invalid_data_should_fail() {
        // Arrange
        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());

        // Act
        homePage.Click_my_acount();
        homePage.Click_Login();
        accountPage.new_login("invalid@email.com", "wrongpassword");

        // Assert - Verify error message is displayed
        Assert.assertTrue(!accountPage.isLoginLinkDisplayed(), " No match for E-Mail Address and/or Password");

        accountPage.email_failed_msg();
    }


    @Test(priority = 5, description = "Vailed forget Password successfully!")
    public void vailed_forget_Password_successfully() throws InterruptedException {
        Thread.sleep(3000);
        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());

        homePage.Click_my_acount();
        homePage.Click_Login();
        accountPage.click_forgotten_Password();
        accountPage.input_email(Utilty.RandomDataGenerator.CredentialsHolder.email);
        Thread.sleep(10000);
        accountPage.email_confirmation_msg();
        Assert.assertTrue(accountPage.getConfirmationMessageText(), "Confirmation message should be displayed");
    }

    @Test(priority = 5, description = "Invailed forget Password!")
    public void invailed_forget_Password() throws InterruptedException {
        Thread.sleep(3000);
        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());
        homePage.Click_my_acount();
        homePage.Click_Login();

        accountPage.click_forgotten_Password();
        accountPage.input_email("invalid@email.com");
        Thread.sleep(10000);
        Assert.assertFalse(!accountPage.getUnfailedMessageText(), "warning message should be displayed");
        accountPage.email_failed_msg();
    }


    @Test(priority = 6, description = "randomly Choose Currency successfully!")
    public void randomlyChooseCurrency_successfully() throws InterruptedException {

        homePage = new P01_Home_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());


        String elementpriceBeforeChange = accountPage.getElementPrice();
        accountPage.openCurrencyDropdown();
        Thread.sleep(3100);

        accountPage.selectRandomCurrency();

        String elementPriceAfterChange = accountPage.getElementPrice();

        System.out.println("the change in prices with currencies is " + elementPriceAfterChange + " in stead of  " + elementpriceBeforeChange);
        softAssert = new SoftAssert();
        softAssert.assertNotEquals(elementPriceAfterChange, elementpriceBeforeChange);
        softAssert.assertAll();
        Assert.assertFalse(getDriver().getCurrentUrl().contains("route=account"), "Change currancy successfully");



    }


}
