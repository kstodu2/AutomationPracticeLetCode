package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectPage {
    public WebDriver driver;

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(id = "fruits")
    private WebElement selectFruitDropDown;

    @FindBy(css = ".subtitle:nth-last-child(1)")
    private WebElement selectedFruit;

    @FindBy(id = "superheros")
    private WebElement selectHero;

    @FindBy(xpath = "(//div[@class='notification is-success'])[2]")
    private WebElement selectedHero;
    @FindBy(id = "lang")
    private WebElement selectLanguage;

    @FindBy(id = "country")
    private WebElement selectCountry;



    public void setFruitDropDownByIndex(int index){
        Select select = new Select(selectFruitDropDown);
        select.selectByIndex(index);
    }
    public void setFruitDropDownByText(String text){
        Select select = new Select(selectFruitDropDown);
        select.selectByVisibleText(text);
    }
    public void setFruitDropDownByValue(String value){
        Select select = new Select(selectFruitDropDown);
        select.selectByValue(value);
    }
    public String getSelectedFruit(){
        return selectedFruit.getText();
    }

    public void setHeroDropDownByIndex(int index){
        Select select = new Select(selectHero);
        select.selectByIndex(index);
    }
    public void setHeroDropDownByText(String text){
        Select select = new Select(selectHero);
        select.selectByVisibleText(text);
    }
    public void setHeroDropDownByValue(String value){
        Select select = new Select(selectHero);
        select.selectByValue(value);
    }
    public String getSelectedHero(){
        return selectedHero.getText();
    }
    public List<WebElement> selectLastLanguage(){
        Select select = new Select(selectLanguage);
        List<WebElement> options = select.getOptions();
        select.selectByIndex(options.size() -1);

        return options;
    }
    public void selectIndia(String country){
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }

}
