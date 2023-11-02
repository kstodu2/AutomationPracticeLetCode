import PageObjects.DropPage;
import PageObjects.HomePage;
import PageObjects.SortPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class SortTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private SortPage sortPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        sortPage = new SortPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickSortTest() {
        homePage.clickSort();
    }
    @Test(priority = 3)
    public void moveToDoBoxesToDoneTest() {
        sortPage.moveToDoBoxesToDone();
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
