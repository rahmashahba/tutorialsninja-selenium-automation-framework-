package testcases;

import Pages.P01_Home_Page;
import Pages.P03_account;
import Pages.P04_selectRandomCategory;
//import Pages.P07_rondomly_categories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Utilty;

import java.util.List;
import java.util.Random;

import static drivers.DriverHolder.getDriver;
import static util.Utilty.generateRandomInt;

public class TC03_selectRandomCategory extends testbase {

  P01_Home_Page homePage;
  P03_account account ;
  P04_selectRandomCategory e2e ;
    int index = generateRandomInt(8);


    @Test
    public void hoverByMouseAndSelectRandomCategory() throws InterruptedException {
        homePage = new P01_Home_Page(getDriver());
        //loginPage = new P02_LoginPage(getDriver());
        account = new P03_account(getDriver());
       //account.clickOnHomePageIcon();

        List<WebElement> categoryElements = homePage.categoriesMenuListLi;
        System.out.println("Category elements are " + categoryElements.size());
        Random random = new Random();
        int randomIndex = random.nextInt(categoryElements.size());
        System.out.println("random index is " + randomIndex);
        WebElement randomCategory = categoryElements.get(randomIndex);
        System.out.println("random category is " + randomCategory.getText());
        Actions actions = new Actions(getDriver());
        Thread.sleep(1000);
        actions.moveToElement(randomCategory).perform();


    }

    @Test
    public void hoverByMouseAndSelectRandomCategory_P() {
        homePage = new P01_Home_Page(getDriver());
        homePage.hoverToRandomCategory(index);

    }





   int indexSub = generateRandomInt(3);
    int a = generateRandomInt(2);  // Generates a random number between 0 and 1, then adds 1
    int b = generateRandomInt(2) + 2;  // Generates a random number between 0 and 1, then adds 3
    int c = generateRandomInt(5) + 5;  // Generates a random number between 0 and 4, then adds 5

    @Test
    public void hoverByMouseAndSelectRandomSubCategory_P() {
        homePage = new P01_Home_Page(getDriver());
        homePage.hoverToRandomCategory(indexSub);
        //homePage.hoverToSubRandomCategory(indexsub);
        switch (indexSub) {
            case 1:
                homePage.hoverToSubRandomCategory(a);
                System.out.println("a: " + a);//code to be executed
                break; //optional
            case 2:
                homePage.hoverToSubRandomCategory(b);
                System.out.println("b: " + b);//code to be executed
                break;
            case 3:
                homePage.hoverToSubRandomCategory(c);
                System.out.println("c: " + c);

                break;


        }


    }




































    /*@Test(priority = 1 , description = "randomly Choose Category successfully!")
    public void randomlyChooseCategory_successfully( ) throws InterruptedException {

        homePage = new P01_Home_Page(getDriver());
        e2e = new P04_selectRandomCategory(getDriver());
        Thread.sleep(3100);

        e2e.selectRandomCategory();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("route=product"), "randomly Choose Category successfully");
    }

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
*/

}
