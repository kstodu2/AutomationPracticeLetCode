import PageObjects.HomePage;
import PageObjects.RadioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class RadioTestCase extends baseTest {


    public WebDriver driver;
    private HomePage homePage;
    private RadioPage radioPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        radioPage = new RadioPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }
    @Test(priority = 2)
    public void clickRadioPageTest() {
        homePage.clickRadio();
    }
    @Test(priority = 3)
    public void clickFirstOptionYes() {
        radioPage.clickFirstOptionYes();
    }

    @Test(priority = 4)
    public void SecondRadioWorkingTest() {
        radioPage.clickSecondOptionYes();
        radioPage.clickSecondOptionNo();
        boolean firstOption = radioPage.isSecondOptionSelectedNo();
        boolean secondOption = radioPage.isSecondOptionSelectedYes();
        Assert.assertFalse(firstOption == secondOption);
    }
    @Test(priority = 5)
    public void ThirdRadioWorkingTest() {
        radioPage.clickThirdOptionYes();
        radioPage.clickThirdOptionNo();
        boolean firstOption = radioPage.isThirdOptionSelectedYes();
        boolean secondOption = radioPage.isThirdOptionSelectedNo();
        Assert.assertFalse(firstOption == secondOption);
    }
    @Test(priority = 6)
    public void FourthRadioSelectedTest() {
        System.out.println("The selected checkBox is " + radioPage.whichFourtOptionSelected());

    }
    @Test(priority = 7)
    public void FifthRadioLastOptionDisabledTest() {
        Assert.assertTrue(radioPage.FifthRadioLastOneDisabled());
    }

    @Test(priority = 8)
    public void firstCheckBoxSelectedTest() {
        Assert.assertTrue(radioPage.firstCheckBoxSelected());
    }

    @Test(priority = 9)
    public void clickSecondCheckBoxTest() {
        radioPage.clickSecondCheckBox();
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}