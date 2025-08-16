package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.DriverHolder.getDriver;

public class P04_E2E_AddToCart {


    public P04_E2E_AddToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "(//button)[5]")
    WebElement searchButton;
    @FindBy(xpath = "(//button[@type='button'])[10]")
    WebElement addToWishList;

    @FindBy(xpath = "//button[3]")
    WebElement productComparison;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement productComparisonMsg;

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

    @FindBy(xpath = "//a[normalize-space()='product comparison']")
    WebElement productComparisonbutton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement addToWishListMsg;


    @FindBy(xpath = "(//div/div/button)[2]")
    WebElement macbookProduct;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
    WebElement iphoneProduct;

    @FindBy(xpath = "(//i[@class='fa fa-exchange'])[1]")
    public WebElement macbookaddtoCompareList;

    @FindBy(xpath = "(//i[@class='fa fa-exchange'])[2]")
    public WebElement iphoneAddtoCompareList;

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
    WebElement regions;

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
    private WebElement your_order_has_been_placed;


    @FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
    public WebElement successmessage;


    public void searchClick(String searchKey) throws InterruptedException {
        this.search.sendKeys(searchKey);
        Thread.sleep(3000);
        this.searchButton.click();
        Thread.sleep(10000);
    }

    public void successfully_addToWishList() throws InterruptedException {
        Thread.sleep(3000);
        this.addToWishList.click();
        Thread.sleep(3000);
        System.out.println(this.addToWishListMsg.getText());

    }


    public String successfully_addToWishListMsg() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToWishListMsg));
        return addToWishListMsg.getText();
    }

    public void successfullyGoT0_myWishList() throws InterruptedException {
        this.myWishList.click();
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


    public void clickOn_macbookaddtoCompareList() {
        this.macbookaddtoCompareList.click();
    }

    public void clickOn_iphoneAddtoCompareList() {
        this.iphoneAddtoCompareList.click();
    }

    public void productComparisonMessageText() {
        System.out.println(this.productComparisonMsg.getText());
    }

    public String getSuccessMessageText() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productComparisonMsg));
        return productComparisonMsg.getText();
    }

    public void productComparisonCheck() throws InterruptedException {
        Thread.sleep(3000);
        this.productComparisonbutton.click();
        Thread.sleep(3000);

    }

    public void new_register_acc(String first_name, String last_name, String address1, String city, String postCode) throws InterruptedException {

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
        System.out.println(this.your_order_has_been_placed.getText());
    }

    public String success_your_order_has_been_placed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(your_order_has_been_placed));
        return your_order_has_been_placed.getText();
    }

}





