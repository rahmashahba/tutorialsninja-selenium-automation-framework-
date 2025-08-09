package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_E2E_AddToCart {


    public P05_E2E_AddToCart(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='button'])[10]")
    WebElement addToWishList;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement addToWishListMsg;


    @FindBy(xpath = "//button[3]")
    WebElement productComparison;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement productComparisonMsg;

    @FindBy(xpath = "//i[@class='fa fa-heart']")
    WebElement myWishList;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement AddToMyCart;

    @FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
    WebElement myCart;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOut;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement AddProdToMyCart;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement step2Continue;


    public void successfully_productComparison() throws InterruptedException {
        Thread.sleep(3000);
        this.productComparison.click();
        Thread.sleep(3000);
        System.out.println( this.productComparisonMsg.getText());
    }


    public void successfully_addToWishList() throws InterruptedException {
        Thread.sleep(3000);
        this.addToWishList.click();
        Thread.sleep(3000);
       System.out.println( this.addToWishListMsg.getText());
    }
    public void successfully_AddToMyCart() throws InterruptedException {
        this.myWishList.click();
        Thread.sleep(3000);
        this.AddToMyCart.click();
        Thread.sleep(3000);
        this.AddProdToMyCart.click();
        Thread.sleep(3000);
        this.myCart.click();
        Thread.sleep(3000);
        this.checkOut.click();
        Thread.sleep(3000);
        this.step2Continue.click();
    }

    @FindBy(xpath = "//input[@placeholder=\"First Name\"]")
    WebElement first_name;

    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    WebElement last_name;

    @FindBy(xpath = "//input[@placeholder=\"Address 1\"]")
    WebElement address1;

    @FindBy(xpath = "//input[@placeholder=\"City\"]")
    WebElement city;

    @FindBy(xpath = "//input[@placeholder=\"Post Code\"]")
    WebElement postCode;

    @FindBy(xpath = "//select[@id=\"input-payment-country\"]")
    WebElement country;

    @FindBy(xpath = "//select[@id=\"input-payment-zone\"]")
    //List<WebElement> regions ;
    WebElement regions ;

    @FindBy(xpath = "//div/select/option[@value=\"3513\"]")
    WebElement region;

    @FindBy(xpath = "//input[@id=\"button-payment-address\"]")
    WebElement continue_Button;

    @FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']")
    WebElement shipping_address;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    WebElement shipping_Button;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement method_shipping_Button;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement button_payment_method;

    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement button_confirm;


    @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    WebElement your_order_has_been_placed;


    public void new_register_acc(String first_name ,String last_name,String address1, String city, String postCode ) throws InterruptedException {

        this.first_name.sendKeys(first_name);
        this.last_name.sendKeys(last_name);
        this.address1.sendKeys(address1);
        this.city.sendKeys(city);
        this.postCode.sendKeys(postCode);
        this.regions.click();
        Thread.sleep(3000);
        this.region.click();

        this.continue_Button.click();

        Thread.sleep(3000);
        this.shipping_address.click();
        Thread.sleep(3000);
        this.shipping_Button.click();
        Thread.sleep(3000);
        this.method_shipping_Button.click();
        Thread.sleep(3000);
        this.agree.click();
        Thread.sleep(3000);
        this.button_payment_method.click();
        Thread.sleep(3000);
        this.button_confirm.click();

        Thread.sleep(5000);
       System.out.println( this.your_order_has_been_placed.getText());
    }


}





