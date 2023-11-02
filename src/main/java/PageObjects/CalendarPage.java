package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CalendarPage {
    public WebDriver driver;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(xpath="//div[@class='datetimepicker-dummy-wrapper']/input[1]")
    private WebElement startDate;
    @FindBy(xpath="//div[@class='datetimepicker-dummy-wrapper']/input[2]")
    private WebElement endDate;

    //calendar on the website seems to be broken
    public void selectTodaysDate(){
        WebElement todayElement = driver.findElement(
                By.xpath("//button[@class='date-item is-today']"));
        todayElement.click();
    }


}
