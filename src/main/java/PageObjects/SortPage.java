package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortPage {
    public WebDriver driver;


    public SortPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(xpath ="//div[@id='cdk-drop-list-0']/div")
    private List<WebElement> toDoBoxes;
    @FindBy(id="cdk-drop-list-1")
    private WebElement doneBoxGetUp;

    public void moveToDoBoxesToDone() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement box : toDoBoxes) {
            // Couldn't get Selenium methods (clickandHold,drag/drop) to work, worth looking into it after.
            js.executeScript("arguments[1].insertBefore(arguments[0], arguments[1].firstChild);", box, doneBoxGetUp);
        }

    }

}
