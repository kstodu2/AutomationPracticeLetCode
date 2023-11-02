import PageObjects.HomePage;
import PageObjects.TablePage;
import PageObjects.WaitPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class WaitTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private WaitPage waitPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        waitPage = new WaitPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickWaitTest() {
        homePage.clickWait();
    }

    @Test(priority = 3)
    public void clickSimpleAltert() {
        waitPage.clickSimpleAlertButton();
    }
    @Test(priority = 4)
    public void acceptSimpleAlert() {
        waitPage.acceptAlert();
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
