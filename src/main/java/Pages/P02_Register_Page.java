package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_Register_Page {


    public P02_Register_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//div/input)[2]")
    WebElement first_name;

    @FindBy(xpath = "(//div/input)[3]")
    WebElement last_name;

    @FindBy(xpath = "(//div/input)[4]")
    WebElement email;

    @FindBy(xpath = "(//div/input)[5]")
    WebElement phone;

    @FindBy(xpath = "(//div/input)[6]")
    WebElement password;

    @FindBy(xpath = "(//div/input)[7]")
    WebElement password_Confirm;

    @FindBy(xpath = "(//div/input)[8]")
    WebElement privacy_Polic;

    @FindBy(xpath = "(//div/input)[9]")
    WebElement continue_Button;

    @FindBy(xpath = "//div/h1[text() =\"Your Account Has Been Created!\"]")
    WebElement successRegister_msg;

    @FindBy(xpath = "//div/div[text() =\"Warning: E-Mail Address is already registered!\"]")
    WebElement unsuccessRegister_msg;


    public void new_register_acc(String first_name, String last_name, String email, String phone, String password, String password_Confirm) {

        this.first_name.sendKeys(first_name);
        this.last_name.sendKeys(last_name);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.password.sendKeys(password);
        this.password_Confirm.sendKeys(password_Confirm);
        this.privacy_Polic.click();
        this.continue_Button.click();
    }

    //check if register success
    public boolean is_register_success(String register_success_msg) throws InterruptedException {

        Thread.sleep(3000);
        try {

            return this.successRegister_msg.getText().equals(register_success_msg);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void unsuccessRegister_msg() {
        System.out.println(this.unsuccessRegister_msg.getText());
    }


}
