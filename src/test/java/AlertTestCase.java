import PageObjects.AlertPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class AlertTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private AlertPage alertPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        alertPage = new AlertPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest(){
        homePageTest();
    }
    @Test(priority = 2)
    public void clickAlertPageTest(){
        homePage.clickAlert();
    }
    @Test(priority = 3)
    public void clickConfirmAlertTest(){
        alertPage.clickConfirmAlert();
    }
    @Test(priority = 4)
    public void grabConfirmAlertTextTest(){
        System.out.println(alertPage.grabAlertText());
    }
    @Test(priority = 5)
    public void dissmissConfirmAlertTest(){
        alertPage.dismissConfirmAlert();
    }
    @Test(priority = 6)
    public void clickPromptAlertTest(){
        alertPage.clickPromptAlert();
    }
    @Test(priority = 7)
    public void enterPromptAlertNameTest(){
        alertPage.enterNamePrompt("James Smith");
    }
    @Test(priority = 8)
    public void acceptPromptAlertTest(){
        alertPage.acceptPromptAlert();
    }

    @Test(priority = 9)
    public void enteredPrompNameTest(){
        Assert.assertTrue(alertPage.enteredPromptName().contains("James Smith"));
    }

    @Test(priority = 10)
    public void clickModernAlertTest(){
        alertPage.clickModernAlert();
    }
    @Test(priority = 11)
    public void dissmissModernAlert(){
        alertPage.dissmissModernAlert();
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
