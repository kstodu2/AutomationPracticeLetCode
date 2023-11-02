import PageObjects.FormPage;
import PageObjects.HomePage;
import PageObjects.UploadDownloadPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class UploadDownloadTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private UploadDownloadPage uploadDownloadPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        uploadDownloadPage = new UploadDownloadPage(driver);
    }

    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickFile() {
        homePage.clickFile();
    }
    @Test(priority = 3)
    public void uploadFileTest() {
        String filePath = "C:/Users/Kacper/Desktop/Design Pattern Practice/" +
                "letCodeinPractice/src/test/java/resources/Downloads/test.txt";
        uploadDownloadPage.uploadFile(filePath);
    }
    @AfterClass
    public void close() {
        driver.close();
    }
}
