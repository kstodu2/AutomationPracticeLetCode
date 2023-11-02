package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DropPage {
    public WebDriver driver;

    public DropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id = "draggable")
    private WebElement sampleBox;

    @FindBy(id = "droppable")
    private WebElement targetBox;

    @FindBy(css = "div[id='droppable'] p")
    private WebElement verifyDropped;

    public void dragToTarget() {

        Actions clickNDrag = new Actions(driver);
        clickNDrag.clickAndHold(sampleBox).moveToElement(targetBox).release().build().perform();
    }
    public String verifyDropped() {

        return verifyDropped.getText();
    }
}