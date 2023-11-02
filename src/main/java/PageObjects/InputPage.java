package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class InputPage {

    public WebDriver driver;

    public InputPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id = "fullName")
    private WebElement setFullName;

    @FindBy(id = "join")
    private WebElement appendTextTab;

    @FindBy(id = "getMe")
    private WebElement valueInsideText;

    @FindBy(id = "clearMe")
    private WebElement clearTextBox;
    @FindBy(id = "noEdit")
    private WebElement textboxDisabled;
    @FindBy(id = "dontwrite")
    private WebElement textboxReadOnly;



    public void enterFullName(String fName, String lName){
        setFullName.sendKeys(fName + " " + lName);
    }

    public void setAppendTextTab(String append){
        appendTextTab.sendKeys(" " + append);
        appendTextTab.sendKeys(Keys.TAB);
    }
    public String getValue(){
        String valueInside = valueInsideText.getAttribute("value");
        return valueInside;
    }
    public void setClearTextBox(){
        clearTextBox.clear();
    }
    public boolean isTextBoxDisabled(){
        return textboxDisabled.isEnabled();
    }
    public String isTextBoxReadOnly(){
        return textboxReadOnly.getAttribute("readonly");
    }


}
