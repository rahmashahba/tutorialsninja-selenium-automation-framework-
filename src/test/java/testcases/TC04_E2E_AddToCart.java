package testcases;

import Pages.*;
//import Pages.P08_searchElements;
import org.testng.annotations.Test;
import util.Utilty;

import static drivers.DriverHolder.getDriver;
import static util.Utilty.RandomDataGenerator.generateRandomString;

public class TC04_E2E_AddToCart extends testbase{
    P01_Home_Page homePage;
    P04_selectRandomCategory e2e ;
  P05_E2E_AddToCart e2EAddToCart ;
  P03_account account;
  P02_Register_Page registerPage ;

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
    @Test(priority = 1 , description = "search successfully!")
    public void searchSuccessfully( ) throws InterruptedException {



        registerPage = new P02_Register_Page(getDriver());
        homePage = new P01_Home_Page(getDriver());
        e2EAddToCart = new P05_E2E_AddToCart(getDriver());

        homePage.Click_my_acount();
        homePage.Click_Register();

        registerPage.new_register_acc(first_name, last_name, email, phone, password, password_Confirm);


        e2e = new P04_selectRandomCategory(getDriver());

        Thread.sleep(3100);

        e2e.searchClick("HP LP3065");
        e2EAddToCart.successfully_addToWishList();
        Thread.sleep(3000);
        e2EAddToCart.successfully_productComparison();
        Thread.sleep(3000);
        e2EAddToCart.successfully_AddToMyCart();

        e2EAddToCart.new_register_acc(first_name , last_name, address1,  city,  postCode );



    }
}
