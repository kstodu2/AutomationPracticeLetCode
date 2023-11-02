package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiSelectPage {
    public WebDriver driver;


    public MultiSelectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(xpath ="//div[@id='container']/div")
    private List<WebElement> allBoxes;

    public void selectAllBoxes(){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL);
        for(WebElement box: allBoxes){
            actions.click(box);
        }
        actions.keyUp(Keys.LEFT_CONTROL);
        actions.build().perform();
    }
}
