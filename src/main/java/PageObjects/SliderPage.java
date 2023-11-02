package PageObjects;

import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SliderPage {
    public WebDriver driver;


    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id ="generate")
    private WebElement slider;
    @FindBy(className ="has-text-primary-light")
    private WebElement selectedCountries;
    @FindBy(className = "has-text-info")
    private WebElement currentLimit;
    @FindBy(css="button.button.is-primary")
    private WebElement getCountriesButton;
    @FindBy(css="p.has-text-primary-light")
    private WebElement getCountries;

    private int theNumber;

    public void setSlider(int wordLimit){
        if(wordLimit < 1 || wordLimit > 51){
            System.out.println("Please chose between 1 and 50");
        }
        //lazy implementation, is supposed to click in the middle, might change in the future
        slider.click();
        String[] number = currentLimit.getText().split(" ");
        Actions actions = new Actions(driver);
        theNumber =Integer.parseInt(number[number.length-1]);
        while(true){
            number = currentLimit.getText().split(" ");
            theNumber =Integer.parseInt(number[number.length-1]);
            if(theNumber == wordLimit) break;

            if(theNumber > wordLimit){
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            else{
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }
    }
    public void clickGetCountries(){
        getCountriesButton.click();
    }
    public int getCountOfCountries(){
        String countries = getCountries.getText();
        String[] countriesList = countries.split("-");
        int count = 0;
        for(String country: countriesList){
            count += 1;
        }
        return count;
    }

}
