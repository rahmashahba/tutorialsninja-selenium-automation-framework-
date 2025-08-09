package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
public class P04_selectRandomCategory {

    public P04_selectRandomCategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private WebDriver driver; //  Store driver as a class variable
    private JavascriptExecutor jsExecutor;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']")
    List<WebElement> categoryLinks;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "(//button)[5]")
    WebElement searchButton;

    @FindBy(xpath = "//div/h2")
    WebElement categoryName;

    @FindBy(css = ".nav.navbar-nav > li > a")
    List<WebElement> topLevelCategories;

    //@FindBy(css = ".dropdown-menu a")
    @FindBy(css = ".dropdown-menu .list-unstyled > li > a")
    private List<WebElement> subCategoryItems;

    /**
     * Selects a random currency by clicking one of the currency buttons.
     */
    public void selectRandomCategory() throws InterruptedException {
        // Check if the list of buttons is populated and not empty.
        if (categoryLinks != null) {
            Random random = new Random();
            int randomIndex = random.nextInt(categoryLinks.size());

            WebElement randomButton = categoryLinks.get(randomIndex);
            randomButton.click();
            Thread.sleep(3000);


            System.out.println("Successfully selected category: " + this.categoryName.getText());
        } else {
            System.out.println("No category buttons were found or they are not currently visible.");
        }


    }
    public void searchClick(String searchKey ) throws InterruptedException {
        this.search.sendKeys(searchKey);
        Thread.sleep(3000);
        this.searchButton.click();
        Thread.sleep(10000);
    }



    public WebElement hoverRandomTopLevelCategory() throws InterruptedException {
        if (topLevelCategories == null || topLevelCategories.isEmpty()) {
            System.out.println("No top-level categories found.");
            return null;
        }

        int numberOfCategoriesToSelectFrom = Math.min(3, topLevelCategories.size());
        if (numberOfCategoriesToSelectFrom == 0) {
            System.out.println("Fewer than 1 category tab found.");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(numberOfCategoriesToSelectFrom);

        WebElement randomCategory = topLevelCategories.get(randomIndex);

        // ✅ Use the stored driver

        Actions actions = new Actions(driver);
        actions.moveToElement(randomCategory).perform();

        Thread.sleep(3000);

        System.out.println("Hovered over random top-level category: " + randomCategory.getText());
        return randomCategory;
    }

    public WebElement hoverRandomSubLevelCategory(WebElement SubLevelCategory ) throws InterruptedException {
        if (subCategoryItems == null || subCategoryItems.isEmpty()) {
            System.out.println("No top-level categories found.");
            return null;
        }

        int numberOfCategoriesToSelectFrom = Math.min(1, subCategoryItems.size());
        if (numberOfCategoriesToSelectFrom == 0) {
            System.out.println("Fewer than 1 category tab found.");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(numberOfCategoriesToSelectFrom);

        WebElement randomCategory = subCategoryItems.get(randomIndex);

        // ✅ Use the stored driver

        Actions actions = new Actions(driver);
        actions.moveToElement(randomCategory).perform();

        Thread.sleep(3000);

        System.out.println("Hovered over random top-level category: " + randomCategory.getText());
        return randomCategory;
    }

    public String selectRandomSubCategoryFromMenu(String Cat) throws InterruptedException {
        // Check if the list of buttons is populated and not empty.
        switch (Cat) {
            case "Desktops":
                String[] supCategory1 = {
                        "PC (0)",
                        "Mac (1)"
                };

                Random random1 = new Random();
                int index_1 = random1.nextInt(supCategory1.length);
                WebElement randomButton = subCategoryItems.get(index_1);
                randomButton.click();
                return supCategory1[index_1];
            case "Laptops & Notebooks":
                String[] supCategory2 = {
                        "Macs (0)",
                        "Windows (0)"
                };

                Random random2 = new Random();
                int index_2 = random2.nextInt(supCategory2.length);

                WebElement randomButton_2 = subCategoryItems.get(index_2);
                randomButton_2.click();
                return supCategory2[index_2];
            case "Components":
                String[] supCategory3 = {
                        "Mice and Trackballs (0)",
                        "Monitors (2)",
                        "Scanners (0)",
                        "Web Cameras (0)"
                };

                Random random3 = new Random();
                int index_3 = random3.nextInt(supCategory3.length);
                WebElement randomButton_3 = subCategoryItems.get(index_3);
                randomButton_3.click();
                return supCategory3[index_3];

            case "MP3 Players":
                String[] supCategory9 = {
                        "test 7 (0)",
                        "test 8 (0)",
                        "test 9 (0)",
                        "test 10 (0)"
                };

                Random random9 = new Random();
                int index_9 = random9.nextInt(supCategory9.length);
                WebElement randomButton_9 = subCategoryItems.get(index_9);
                randomButton_9.click();
                return supCategory9[index_9];
        }
        return "Can't Find Cat !";

    }

    // GITHUB

}
