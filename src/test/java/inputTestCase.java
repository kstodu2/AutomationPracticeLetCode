import PageObjects.HomePage;
import PageObjects.InputPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.baseTest;

import java.io.IOException;

public class inputTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private InputPage inputPage;


    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        inputPage = new InputPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest(){
        homePageTest();
    }
    @Test(priority = 2)
    public void clickInputTest(){
        homePage.clickInput();
    }
    @Test(priority = 3)
    public void enterFullNameTest(){

        inputPage.enterFullName("John", "Doe");
    }
    @Test(priority = 4)
    public void appendTextClickTabTest(){
        inputPage.setAppendTextTab("person");
    }
    @Test(priority = 5)
    public void getValueFromTextBoxTest(){
        String actual = inputPage.getValue();
        String expected = "ortonikc";

        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 6)
    public void setClearTextBoxTest(){
        inputPage.setClearTextBox();

    }
    @Test(priority = 6)
    public void getTextBoxDisabledTest(){
        Assert.assertFalse(inputPage.isTextBoxDisabled());
    }
    @Test(priority = 6)
    public void getTextBoxReadOnlyTest(){
        Assert.assertNotNull(inputPage.isTextBoxReadOnly());
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}


