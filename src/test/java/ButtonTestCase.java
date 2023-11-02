import PageObjects.ButtonPage;
import PageObjects.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class ButtonTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private ButtonPage buttonPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        buttonPage = new ButtonPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest(){
        homePageTest();
    }
    @Test(priority = 2)
    public void clickButtonTest(){
        homePage.clickButton();
    }
    @Test(priority = 3)
    public void clickGoHomeButtonTest(){
        buttonPage.clickGoHomeButton();
    }
    @Test(priority = 4)
    public void goBackToPreviousPageTest(){
        buttonPage.goBackToPreviousPage();
    }
    @Test(priority = 5)
    public void verifyPageTest(){
        Assert.assertEquals(buttonPage.checkCurrentPage(),"https://letcode.in/buttons");
    }
    @Test(priority = 6)
    public void verifyButtonLocationTest(){
        double[] result = buttonPage.getButtonPosition();

        Assert.assertEquals(result[0], 367.0);
        Assert.assertEquals(result[1], 338.0);

    }
    @Test(priority = 7)
    public void verifyButtonColorTest(){
        String color = buttonPage.getButtonColor();
        Assert.assertEquals(color,"rgba(138, 77, 118, 1)");

    }
    @Test(priority = 8)
    public void verifyButtonPropertiesTest(){
        Dimension expected = new Dimension(176, 40);
        Assert.assertEquals(buttonPage.getButtonProperties(), expected);
    }
    @Test(priority = 9)
    public void verifyButtonDisabledTest(){
        Assert.assertTrue(buttonPage.isButtonDisabled());

    }

    @Test(priority = 9)
    public void clickHoldButtonTest(){
        buttonPage.clickHoldButton();

    }
    @AfterClass
    public void close(){
        driver.close();
    }

}
