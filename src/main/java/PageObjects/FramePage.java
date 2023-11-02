package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FramePage {
    public WebDriver driver;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id = "firstFr")
    private WebElement firstFrame;

    @FindBy(name = "fname")
    private WebElement firstName;
    @FindBy(name = "lname")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='content mt-4']/p")
    private WebElement enteredName;
    @FindBy(xpath = "//iframe[@src='innerFrame']")
    private WebElement innerFrame;

    @FindBy(name = "email")
    private WebElement email;

//    @FindBy(id = "testing")
//    private WebElement testingButton;

    public void setFirstName(String fName){
        driver.switchTo().frame(firstFrame);
        firstName.sendKeys(fName);
        //driver.switchTo().defaultContent();
    }
    public void setLastName(String lName){
        lastName.sendKeys(lName);
        //driver.switchTo().defaultContent();
    }
    public String verifyFullName(){
        String[] arrFullName = enteredName.getText().split(" ");
        String fname = arrFullName[arrFullName.length-2] + " " + arrFullName[arrFullName.length-1];
        return fname;
    }
    public void setEmail(String Email){
        driver.switchTo().frame(innerFrame);
        email.sendKeys(Email);
        driver.switchTo().defaultContent();
    }
//    public void testProperSwitchTo(){
//        testingButton.click();
//    }
}
