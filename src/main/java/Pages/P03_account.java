package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class P03_account {
    public P03_account(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;


    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement submit;

    @FindBy(xpath = "//i[@class='fa fa-user']")
    WebElement my_Account_with_in;

    @FindBy(xpath = "//ul/li/a[text()=\"Logout\"]")
    WebElement Logout;


    @FindBy(xpath = "//div/a[text()=\"Forgotten Password\"]")
    WebElement forgotten_Password;

    @FindBy(xpath = "//input[@name =\"email\"]")
    WebElement email_after_frogetPassword;

   @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement accountLogout;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement email_confirmationMsg;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement emailFailedMsg;



    public void new_login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.submit.click();
    }


    public void my_Account_with_in() {
        this.my_Account_with_in.click();
    }

    public void setLogout() {
        this.Logout.click();
    }

    public boolean isLoginLinkDisplayed() {
        try {
            // Replace "loginLinkLocator" with your actual locator (ID, CSS, XPath, etc.)
            return this.Logout.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMyAccountVisible() {
        try {
            // Replace "myAccountLocator" with your actual locator
            return this.my_Account_with_in.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void click_forgotten_Password() {
        this.forgotten_Password.click();
    }

    public void input_email(String email_after_frogetPassword) {
        this.email.sendKeys(email_after_frogetPassword);
        this.submit.click();

    }
    public void accountLogout_confirmation_msg() {
        System.out.println(this.accountLogout.getText());
    }

    public void email_confirmation_msg() {
        System.out.println(this.email_confirmationMsg.getText());
    }
    public boolean getConfirmationMessageText() {
        return this.email_confirmationMsg.isDisplayed();
    }

    public boolean getUnfailedMessageText() {
        return this.emailFailedMsg.isDisplayed();
    }

    public void email_failed_msg() {
        System.out.println(this.emailFailedMsg.getText());
    }

    @FindBy(xpath = "//button[@class=\"currency-select btn btn-link btn-block\"]")
    List<WebElement> currencyButtons;

    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement currencyDropdown;


    /**
     * Clicks the currency dropdown to make the currency buttons visible.
     */
    public void openCurrencyDropdown() {

        this.currencyDropdown.click();

    }

    /**
     * Selects a random currency by clicking one of the currency buttons.
     */

    public String getElementPrice()
    {
        String elementPrice = this.currencyDropdown.getText();
        return elementPrice;
    }
    public void selectRandomCurrency() throws InterruptedException {
        // Check if the list of buttons is populated and not empty.
        if (currencyButtons != null) {
            Random random = new Random();
            int randomIndex = random.nextInt(currencyButtons.size());

            WebElement randomButton = currencyButtons.get(randomIndex);
            randomButton.click();
            Thread.sleep(3000);
            String currencyName = currencyDropdown.getText();// Assumes the currency name is the button's text


            System.out.println("Successfully selected currency: " + currencyName);
        } else {
            System.out.println("No currency buttons were found or they are not currently visible.");
        }
    }
}







