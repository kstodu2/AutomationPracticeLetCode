import PageObjects.HomePage;
import PageObjects.WindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class WindowsTestCase1 extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private WindowPage windowPage;

    @BeforeClass
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        windowPage = new WindowPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickWindowTest() {
        homePage.clickWindow();
    }

    @Test(priority = 3)
    public void clickOpenHomePageTest() {
        windowPage.clickOpenHomePageButton();
    }
    @Test(priority = 4)
    public void getCurrentPageTitleTest() {
        System.out.println(windowPage.curentPageTitle());
    }
    @Test(priority = 5)
    public void closeParentWindowTest() {
        windowPage.closeParentWindow();
    }
    @Test(priority = 6)
    public void closeFirstChildWindowTest() {
        windowPage.closeFirstChildWindow();
    }




}
