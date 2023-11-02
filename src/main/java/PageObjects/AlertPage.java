package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AlertPage {
    public WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(id = "accept")
    private WebElement simpleAlert;

    @FindBy(id = "confirm")
    private WebElement confirmAlert;

    @FindBy(id = "prompt")
    private WebElement promptAlert;
    @FindBy(id = "modern")
    private WebElement moderAlert;

    @FindBy(id = "myName")
    private WebElement enteredName;


    public void clickSimpleAlert() {
        simpleAlert.click();
    }
    public void acceptSimpleAlert() {
        driver.switchTo().alert().accept();
    }
    public void clickConfirmAlert() {
        confirmAlert.click();
    }
    public String grabAlertText() {
        return driver.switchTo().alert().getText();
    }
    public void dismissConfirmAlert() {
        driver.switchTo().alert().dismiss();
    }
    public void clickPromptAlert() {
        promptAlert.click();
    }
    public void enterNamePrompt(String name) {
        driver.switchTo().alert().sendKeys(name);
    }
    public void acceptPromptAlert() {
        driver.switchTo().alert().accept();
    }
    public String enteredPromptName() {
       return enteredName.getText();
    }
    public void clickModernAlert() {
        moderAlert.click();
    }
    public void dissmissModernAlert() {

        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        By closeClick = By.xpath("//button[@aria-label='close']");
        shortWait.until(ExpectedConditions.elementToBeClickable(closeClick)).click();

    }
}



