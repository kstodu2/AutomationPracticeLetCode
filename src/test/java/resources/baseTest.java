package resources;


import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseTest {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Kacper\\Desktop\\Design Pattern Practice\\letCodeinPractice\\src\\test\\java\\resources\\data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        ChromeOptions options = new ChromeOptions();

        switch (browserName) {
            case "firefox":
                // Use WebDriverManager to set up Firefox driver
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                // Use WebDriverManager to set up Chrome driver
                WebDriverManager.chromedriver().setup();
                String adblockExtention = "C:\\Users\\Kacper\\Desktop\\web Drivers\\ublockOrgin_1_52_2_0.crx";
                options.addExtensions(new File(adblockExtention));
                driver = new ChromeDriver(options);
                break;
            case "IE":
                // Use WebDriverManager to set up Edge driver
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
        return driver;
    }
    @Test()
    public void homePageTest() {
        driver.get(prop.getProperty("url"));
        HomePage hp = new HomePage(driver);
        driver.manage().window().maximize();

    }
    @AfterClass
    public void close(){
        driver.close();
    }

}
