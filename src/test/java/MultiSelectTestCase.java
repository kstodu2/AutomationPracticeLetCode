import PageObjects.HomePage;
import PageObjects.MultiSelectPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class MultiSelectTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private MultiSelectPage multiSelectPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        multiSelectPage = new MultiSelectPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickSelectablePageTest() {
        homePage.clickMultiSelect();
    }
    @Test(priority = 3)
    public void selectAllBoxesTest() {
        multiSelectPage.selectAllBoxes();
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
