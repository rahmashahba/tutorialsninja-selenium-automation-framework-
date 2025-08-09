package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class testbase {


    //static WebDriver driver;
    // Actions actions;
    SoftAssert softAssert;

    // This method will run once before all test methods in the class
    //@BeforeTest

    @Parameters("browsername")
    @BeforeMethod
    public void setup_driver( String browsername ) {
        setDriver(getNewInstance(browsername));
        // Launch a new Chrome browser instance
        //   driver = new ChromeDriver();

        // actions = new Actions(driver);
//driver.manage().window().maximize();
        getDriver().get("https://tutorialsninja.com/demo/");

    }

    // This method will run once after all test methods in the class
    // @AfterTest
    @AfterMethod
    public void tearDown_driver() throws InterruptedException {
        if (getDriver() != null) {
            // Close all tabs and kill driver
            getDriver().quit();
        }

    }


}
