import PageObjects.FramePage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class FrameTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private FramePage framePage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        framePage = new FramePage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickFrameTest() {
        homePage.clickFrame();
    }

    @Test(priority = 3)
    public void setFirstNameTest() {
        String firstName = "John";
        framePage.setFirstName(firstName);
    }

    @Test(priority = 4)
    public void setLastNameTest() {
        String lastName = "Smith";
        framePage.setLastName(lastName);
    }

    @Test(priority = 5)
    public void verifyEnteredNameTest() {
        Assert.assertEquals(framePage.verifyFullName(), "John Smith");
    }

    @Test(priority = 6)
    public void setEmailTestTest() {
        framePage.setEmail("JohnSmith@email.com");
    }

    //    @Test(priority = 7)
//    public void backToDefaultWindowTets(){
//        framePage.testProperSwitchTo();
//    }

    @AfterClass
    public void close() {
        driver.close();
    }
}