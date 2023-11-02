package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioPage {
    public WebDriver driver;

    public RadioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//input[@id='yes']")
    private WebElement firstRadioButtonYes;

    @FindBy(xpath = "//input[@id='one']")
    private WebElement secondRadioButtonYes;
    @FindBy(xpath = "//input[@id='two']")
    private WebElement secondRadioButtonNo;

    @FindBy(xpath = "//input[@id='nobug']")
    private WebElement thirdRadioButtonYes;

    @FindBy(xpath = "//input[@id='bug']")
    private WebElement thirdRadioButtonNo;

    @FindBy(xpath = "//input[@name='foobar']")
    private List<WebElement> fourthRadioButtons;
    @FindBy(xpath = "//input[@name='plan']")
    private List<WebElement> fifthRadioButtons;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private WebElement firstCheckBox;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement secondCheckBox;

    public void clickFirstOptionYes(){
        firstRadioButtonYes.click();
    }
    public void clickSecondOptionYes(){
        secondRadioButtonYes.click();
    }
    public boolean isSecondOptionSelectedYes(){
        return secondRadioButtonYes.isSelected();
    }
    public void clickSecondOptionNo(){
        secondRadioButtonNo.click();
    }
    public boolean isSecondOptionSelectedNo(){
        return secondRadioButtonNo.isSelected();
    }

    public void clickThirdOptionYes(){
        thirdRadioButtonYes.click();
    }
    public boolean isThirdOptionSelectedYes(){
        return thirdRadioButtonYes.isSelected();
    }
    public void clickThirdOptionNo(){
        thirdRadioButtonNo.click();
    }
    public boolean isThirdOptionSelectedNo(){
        return thirdRadioButtonNo.isSelected();
    }

    public String whichFourtOptionSelected(){;
        for(WebElement radioButton: fourthRadioButtons){
            if(radioButton.isSelected()){
                return radioButton.findElement(By.xpath("..")).getText();
            }
        }
        return null;
    }
    public boolean FifthRadioLastOneDisabled(){;
        return !fifthRadioButtons.get(fifthRadioButtons.size()-1).isEnabled();
    }
    public boolean firstCheckBoxSelected(){;
        return firstCheckBox.isSelected();
    }
    public void clickSecondCheckBox(){;
        secondCheckBox.click();
    }

}
