import PageObjects.DragPage;
import PageObjects.ElementsPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class DragTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private DragPage dragPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        dragPage = new DragPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickDragPageTest() {
        homePage.clickDrag();
    }
    @Test(priority = 3)
    public void dragBoxEverywhereTest() {
        dragPage.dragEverywhere();
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
