import PageObjects.ElementsPage;
import PageObjects.FramePage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class ElementsTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickElementsPageTest() {
        homePage.clickElements();
    }
    @Test(priority = 3)
    public void enterUserNameTest() {
        elementsPage.enterUserName("kstodu2");
        elementsPage.clickSearch();
    }
    @Test(priority = 4)
    public void checkProfilePictureTest() {
        Assert.assertTrue(elementsPage.checkProfilePicture());
    }
    @Test(priority = 5)
    public void checkNumberOfRepos() {
        //hard coded num of repos will differ based on profile
        int expected = 3;
        Assert.assertEquals(elementsPage.checkNumPublicRepos(), expected);
    }
    @AfterClass
    public void close(){
        driver.close();
    }

}
