package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {

    public static void hoverToWebElement(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void hoverAndClickONAWebElement(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}
