import PageObjects.DragPage;
import PageObjects.DropPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class DropTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private DropPage dropPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        dropPage = new DropPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickDropPageTest() {
        homePage.clickDrop();
    }
    @Test(priority = 3)
    public void dragBoxToTargetTest() {
        dropPage.dragToTarget();
    }
    @Test(priority = 4)
    public void verifyProperDrop() {
        Assert.assertEquals(dropPage.verifyDropped(), "Dropped!");
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}