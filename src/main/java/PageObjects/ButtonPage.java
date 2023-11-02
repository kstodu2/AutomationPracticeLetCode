package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import javax.swing.text.Position;
import java.util.concurrent.TimeUnit;

public class ButtonPage {

    public WebDriver driver;

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @FindBy(id = "home")
    private WebElement goHomeButton;

    @FindBy(id = "position")
    private WebElement buttonPosition;
    @FindBy(id = "color")
    private WebElement buttonColor;

    @FindBy(id = "property")
    private WebElement buttonProperties;
    @FindBy(id = "isDisabled")
    private WebElement buttonDisable;

    @FindBy(xpath ="//button[@id='isDisabled']/div")
    private WebElement clickHoldButton;


    public void clickGoHomeButton(){
        goHomeButton.click();
    }

    public void goBackToPreviousPage(){
        driver.navigate().back();
    }
    public String checkCurrentPage(){
        return driver.getCurrentUrl();
    }
    public double[] getButtonPosition(){
        Point position = buttonPosition.getLocation();
        double[] location = new double[2];
        location[0]= position.getX();
        location[1]= position.getY();
        return location;
    }

    public String getButtonColor(){
        return buttonColor.getCssValue("background-color");
    }
    public Dimension getButtonProperties(){
        return buttonProperties.getSize();
    }
    public boolean isButtonDisabled(){
        return !buttonDisable.isEnabled();
    }
    public void clickHoldButton(){
        Actions clickHold = new Actions(driver);
        clickHold.clickAndHold(clickHoldButton).perform();
        if(clickHoldButton.getText().equals("Button has been long pressed")){
            clickHold.release().perform();
        }

    }


}
