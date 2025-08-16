package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static drivers.DriverHolder.getDriver;

import static Pages.PageBase.hoverAndClickONAWebElement;
import static Pages.PageBase.hoverToWebElement;

public class P01_Home_Page {

    //constractor
    public P01_Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    //locators
    @FindBy(xpath = "//ul/li/a[@title=\"My Account\"]")
    WebElement my_Account;

    @FindBy(xpath = "//ul/li/a[text()=\"Register\"]")
    WebElement register;

    @FindBy(xpath = "//ul/li/a[text()=\"Login\"]")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li")
    public List<WebElement> categoriesMenuListLi;


    //public action method

    public void Click_my_acount() {
        my_Account.click();
    }

    public void Click_Register() throws InterruptedException {
        Thread.sleep(3000);
        register.click();
    }

    public void Click_Login() {
        login.click();
    }

    public boolean isLoginLinkDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        try {
            return this.login.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void hoverToRandomCategory(int index) {
        WebElement category = getDriver().findElement(By.xpath("(//div/ul[@class=\"nav navbar-nav\"]/li)[" + index + "]"));
        hoverToWebElement(getDriver(), category);

    }

    public void hoverToSubRandomCategory(int indexsub) {
        WebElement subCategory = getDriver().findElement(By.xpath("(//div/ul[@class=\"list-unstyled\"]/li)[" + indexsub + "]"));
        hoverAndClickONAWebElement(getDriver(), subCategory);
    }
}
