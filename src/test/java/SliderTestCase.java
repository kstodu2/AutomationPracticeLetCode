import PageObjects.HomePage;
import PageObjects.SelectPage;
import PageObjects.SliderPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class SliderTestCase extends baseTest {
    public WebDriver driver;
    private HomePage homePage;
    private SliderPage sliderPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        sliderPage = new SliderPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }
    @Test(priority = 2)
    public void clickSliderPageTest() {
        homePage.clickSlider();
    }
    @Test(priority = 3)
    public void setSliderTest() {
        sliderPage.setSlider(1);
    }
    @Test(priority = 4)
    public void clickGetCountriesTest() {
        sliderPage.clickGetCountries();
    }
    @Test(priority = 5)
    public void checkNumberOfCountriesTest() {
        Assert.assertEquals(sliderPage.getCountOfCountries(), 1);
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
