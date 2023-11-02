import PageObjects.HomePage;
import PageObjects.SelectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;
import java.util.List;

public class SelectTestCase extends baseTest {


    public WebDriver driver;
    private HomePage homePage;
    private SelectPage selectPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        selectPage = new SelectPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickInputTest() {
        homePage.clickSelect();
    }

    @Test(priority = 3)
    public void selectAppleDropDownTest() {
        String fruit = "Apple";
        selectPage.setFruitDropDownByText(fruit);
        Assert.assertTrue(selectPage.getSelectedFruit().contains(fruit));
    }
    @Test(priority = 4)
    public void selectSuperHeroTest() {
        String hero = "The Shadow";
        selectPage.setHeroDropDownByText(hero);
        Assert.assertTrue(selectPage.getSelectedHero().contains(hero));
    }

    @Test(priority = 5)
    public void selectLastLanguageTest() {
        selectPage.selectLastLanguage();
        List<WebElement> options = selectPage.selectLastLanguage();
        for(WebElement lang : options){
            System.out.println(lang.getText());
        }

    }
    @Test(priority = 5)
    public void selectIndia() {
        selectPage.selectIndia("India");

    }
    @AfterClass
    public void close() {
        driver.close();
    }


}
