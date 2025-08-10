package testcases;

import Pages.*;
//import Pages.P08_searchElements;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Utilty;

import static drivers.DriverHolder.getDriver;
import static util.Utilty.RandomDataGenerator.generateRandomString;

public class TC04_E2E_AddToCart extends testbase {
    P01_Home_Page homePage;
    P04_selectRandomCategory selectRandomCategory;
    P05_E2E_AddToCart e2EAddToCart;
    P03_account account;
    P02_Register_Page registerPage;

    String first_name = generateRandomString(20, 30);
    String last_name = generateRandomString(20, 30);
    String email = generateRandomString(20, 25) + "@" + generateRandomString(5, 10) + ".com";
    String phone = generateRandomString(20, 30); // Note: For real phone numbers, you might want a different approach
    String password = generateRandomString(20, 30);
    String password_Confirm = password; // Making sure they match
    String address1 = Utilty.RandomDataGenerator.generateRandomString(3, 128);
    String city = Utilty.RandomDataGenerator.generateRandomString(2, 3);
    String postCode = Utilty.RandomDataGenerator.generateRandomString(2, 10);
    String country = "United Kingdom"; // Preset
    String region = "Greater London"; // Example region/state

    @Test(priority = 1, description = "successfully_addToWishList !")
    public void successfully_addToWishList() throws InterruptedException {

        registerPage = new P02_Register_Page(getDriver());
        homePage = new P01_Home_Page(getDriver());
        e2EAddToCart = new P05_E2E_AddToCart(getDriver());
        selectRandomCategory = new P04_selectRandomCategory(getDriver());
        account = new P03_account(getDriver());

        homePage.Click_my_acount();
        homePage.Click_Register();

        registerPage.new_register_acc(first_name, last_name, email, phone, password, password_Confirm);

        // Store credentials for login test
        Utilty.RandomDataGenerator.CredentialsHolder.email = email;
        Utilty.RandomDataGenerator.CredentialsHolder.password = password;
        System.out.println("Using credentials: " +
                Utilty.RandomDataGenerator.CredentialsHolder.email);
        Thread.sleep(1000);

        selectRandomCategory.searchClick("HP LP3065");
        e2EAddToCart.successfully_addToWishList();
        Thread.sleep(3000);
        softAssert = new SoftAssert();
        softAssert.assertTrue(e2EAddToCart.successfully_addToWishListMsg().contains("Success: You have added"),
                "Wish list success message not found!"
        );
        softAssert.assertAll();
        e2EAddToCart.successfullyGoT0_myWishList();
        Thread.sleep(500);

    }

    @Test(priority = 2, description = "successfully_productComparison!")
    public void successfully_productComparison() throws InterruptedException {


        registerPage = new P02_Register_Page(getDriver());
        homePage = new P01_Home_Page(getDriver());
        e2EAddToCart = new P05_E2E_AddToCart(getDriver());
        selectRandomCategory = new P04_selectRandomCategory(getDriver());
        account = new P03_account(getDriver());

        System.out.println("Using credentials: " + Utilty.RandomDataGenerator.CredentialsHolder.email + " " + Utilty.RandomDataGenerator.CredentialsHolder.password);
        homePage.Click_my_acount();
        homePage.Click_Login();
        account.new_login(Utilty.RandomDataGenerator.CredentialsHolder.email, Utilty.RandomDataGenerator.CredentialsHolder.password);

        Thread.sleep(500);
        account.clickOnHomePageIcon();
        Thread.sleep(1000);

        e2EAddToCart.clickOn_macbookaddtoCompareList();
        Thread.sleep(1000);
        //e2EAddToCart.getSuccessMessageText();
        e2EAddToCart.productComparisonMessageText();
        e2EAddToCart.clickOn_iphoneAddtoCompareList();
        Thread.sleep(1000);
       // e2EAddToCart.getSuccessMessageText();
        e2EAddToCart.productComparisonMessageText();
        
        Thread.sleep(1000);
        softAssert.assertTrue(e2EAddToCart.getSuccessMessageText().contains("Success: You have added product to comparison"));


        e2EAddToCart.productComparisonCheck();

    }

    @Test(priority = 3, description = "SuccessfullyAddToCar!")
    public void SuccessfullyAddToCar() throws InterruptedException {


        registerPage = new P02_Register_Page(getDriver());
        homePage = new P01_Home_Page(getDriver());
        e2EAddToCart = new P05_E2E_AddToCart(getDriver());
        selectRandomCategory = new P04_selectRandomCategory(getDriver());
        account = new P03_account(getDriver());

        /*homePage.Click_my_acount();
        homePage.Click_Register();

        registerPage.new_register_acc(first_name, last_name, email, phone, password, password_Confirm);
   */
        System.out.println("Using credentials: " + Utilty.RandomDataGenerator.CredentialsHolder.email + " " + Utilty.RandomDataGenerator.CredentialsHolder.password);
        homePage.Click_my_acount();
        homePage.Click_Login();
        account.new_login(Utilty.RandomDataGenerator.CredentialsHolder.email, Utilty.RandomDataGenerator.CredentialsHolder.password);

        Thread.sleep(500);

        selectRandomCategory.searchClick("HP LP3065");
        e2EAddToCart.successfully_addToWishList();
        Thread.sleep(3000);
        e2EAddToCart.successfully_AddToMyCart();

        e2EAddToCart.new_register_acc(first_name, last_name, address1, city, postCode);


        //softAssert = new SoftAssert();
        softAssert.assertTrue(e2EAddToCart.success_your_order_has_been_placed().contains("Success: your_order_has_been_placed"));

       // softAssert.assertAll();



    }
}
