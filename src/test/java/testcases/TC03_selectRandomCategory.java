package testcases;

import Pages.P01_Home_Page;
import Pages.P04_selectRandomCategory;
//import Pages.P07_rondomly_categories;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC03_selectRandomCategory extends testbase {

  P01_Home_Page homePage;
  P04_selectRandomCategory e2e ;
  String Pageurl = "https://tutorialsninja.com/demo/index.php?route=product/category&path=57";

    @Test(priority = 1 , description = "randomly Choose Category successfully!")
    public void randomlyChooseCategory_successfully( ) throws InterruptedException {



        homePage = new P01_Home_Page(getDriver());
        e2e = new P04_selectRandomCategory(getDriver());
        Thread.sleep(3100);

        e2e.selectRandomCategory();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("route=product"), "randomly Choose Category successfully");

    }

  /*  @Test(priority = 2 , description = "search successfully!")
    public void searchSuccessfully( ) throws InterruptedException {



        homePage = new P01_Home_Page(driver);
        e2e = new P04_selectRandomCategory(driver);
        Thread.sleep(3100);

       // e2e.searchClick("mac");
    }*/

    //String Pageurl1 = "https://tutorialsninja.com/demo/index.php?route=product/category&path=18_46";
    String Pageurl1 = "https://tutorialsninja.com/demo/index.php?route=product/category&path=57";

    @Test(priority = 2 , description = "search tags successfully!")
    public void searchTagsSuccessfully( ) throws InterruptedException {



        homePage = new P01_Home_Page(getDriver());
        e2e = new P04_selectRandomCategory(getDriver());
        Thread.sleep(3100);


        WebElement topCategory =  e2e.hoverRandomTopLevelCategory();
        Thread.sleep(3000);

        e2e.hoverRandomSubLevelCategory(topCategory);

        Thread.sleep(3000);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("tutorialsninja"), "can not choise category");

    }


}
