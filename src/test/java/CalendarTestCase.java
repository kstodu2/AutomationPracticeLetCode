import PageObjects.CalendarPage;
import PageObjects.HomePage;
import PageObjects.TablePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class CalendarTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private CalendarPage calendarPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        calendarPage = new CalendarPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickCalendarTest() {
        homePage.clickCalendar();
    }
    @Test(priority = 3)
    public void selectTodaysDateTest() {

        calendarPage.selectTodaysDate();
    }
    @AfterClass
    public void close() {
        driver.close();
    }

}
