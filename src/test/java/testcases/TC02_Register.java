package testcases;

import Pages.P01_Home_Page;
import Pages.P02_Register_Page;
import Pages.P03_account_Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Utilty;

import static drivers.DriverHolder.getDriver;
import static util.Utilty.RandomDataGenerator.generateRandomString;


public class TC02_Register extends testbase {


    P01_Home_Page homePage;
    P02_Register_Page registerPage;
    P03_account_Page accountPage;
    String first_name = generateRandomString(20, 30);
    String last_name = generateRandomString(20, 30);
    String email = generateRandomString(20, 25) + "@" + generateRandomString(5, 10) + ".com";
    String phone = generateRandomString(20, 30); // Note: For real phone numbers, you might want a different approach
    String password = generateRandomString(20, 30);
    String password_Confirm = password; // Making sure they match

    @Test(priority = 1, description = "reg new account with vailed data")
    public void reg_new_acc_with_vailed_data_Passed_P() throws InterruptedException {

        homePage = new P01_Home_Page(getDriver());
        registerPage = new P02_Register_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());

        homePage.Click_my_acount();
        homePage.Click_Register();
        registerPage.new_register_acc(first_name, last_name, email, phone, password, password_Confirm);

        // Store credentials for login test
        Utilty.RandomDataGenerator.CredentialsHolder.email = email;
        Utilty.RandomDataGenerator.CredentialsHolder.password = password;
        System.out.println("Using credentials: " +
                Utilty.RandomDataGenerator.CredentialsHolder.email);

        System.out.println(Utilty.RandomDataGenerator.CredentialsHolder.password);
        // hard asseration
        Assert.assertFalse(!registerPage.is_register_success("Your Account Has Been Created!"));


        //Soft asseration
     /* softAssert = new SoftAssert();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/success", "Should be redirected to success page after registration");
        Assert.assertFalse(!registerPage.is_register_success("Your Account Has Been Created!"));
        softAssert.assertAll();
        */
    }

    @Test(priority = 2, description = "reg new account with vailed data")
    public void reg_new_acc_with_vailed_data_Passed_N() throws InterruptedException {

        homePage = new P01_Home_Page(getDriver());
        registerPage = new P02_Register_Page(getDriver());
        accountPage = new P03_account_Page(getDriver());
        homePage.Click_my_acount();
        homePage.Click_Register();
        registerPage.new_register_acc(first_name, last_name, email, phone, password, password_Confirm);

        // Store credentials for login test
        Utilty.RandomDataGenerator.CredentialsHolder.email = email;
        Utilty.RandomDataGenerator.CredentialsHolder.password = password;

        System.out.println("Using credentials: " +
                Utilty.RandomDataGenerator.CredentialsHolder.email);

        System.out.println(Utilty.RandomDataGenerator.CredentialsHolder.password);

        softAssert = new SoftAssert();

        Assert.assertFalse(registerPage.is_register_success("Warning: E-Mail Address is already registered!"));

        softAssert.assertAll();
        registerPage.unsuccessRegister_msg();

    }
}
