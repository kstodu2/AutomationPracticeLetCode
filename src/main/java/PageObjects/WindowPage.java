package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPage {
    public WebDriver driver;
    private List<String> windowHandles;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id = "home")
    private WebElement openHomePageButton;
    @FindBy(id = "multi")
    private WebElement openMultipleWindowsButton;


    public void clickOpenHomePageButton(){
        openHomePageButton.click();
    }

    public String curentPageTitle() {
        return driver.getTitle();
    }

    public void closeParentWindow() {
        windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(0)).close();
        windowHandles.remove(0);
    }


    public void closeFirstChildWindow() {
        driver.switchTo().window(windowHandles.get(0)).close();
        windowHandles.remove(0);
    }

    public void clickMultipleWindows() {
        openMultipleWindowsButton.click();
    }
    public void getOpenedWindowTitles(){
        windowHandles = new ArrayList<>(driver.getWindowHandles());
        for(String url : windowHandles){
            driver.switchTo().window(url);
            System.out.println(driver.getTitle());
        }
    }
}
