import PageObjects.HomePage;
import PageObjects.SortPage;
import PageObjects.TablePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class TableTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private TablePage tablePage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        tablePage = new TablePage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickTableTest() {
        homePage.clickTable();
    }
    @Test(priority = 3)
    public void correctTotalPriceTest() {
        Assert.assertEquals(tablePage.getShoppingListPrice(),tablePage.getTotalPrice());
    }
    @Test(priority = 4)
    public void markStudentPresentTest() {
        int index = tablePage.getStudentIndexFromLastName("Raj");
        tablePage.checkStudentPresent(index);
    }
    @Test(priority = 5)
    public void sortCholesterolTableASCTest() {
        tablePage.sortASCCholesterolTable();
        tablePage.checkCholesterolSorting();
    }
    @Test(priority = 6)
    public void checkCholesterolSortingTest() {
        Assert.assertTrue(tablePage.checkCholesterolSorting());
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
