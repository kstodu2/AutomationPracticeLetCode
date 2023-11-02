package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DragPage {
    public WebDriver driver;

    public DragPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(css="#sample-box")
    private WebElement sampleBox;


    public void dragEverywhere(){

        Actions clickNDrag = new Actions(driver);
        clickNDrag.clickAndHold(sampleBox).moveByOffset(150,150).moveByOffset(50,50).release().build().perform();
    }
}
