package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormPage {
    public WebDriver driver;
    private List<String> windowHandles;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lasttname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement Email;
    @FindBy(xpath = "(//div[@class='select'])[1]/select")
    private WebElement countryCode;
    @FindBy(id = "Phno")
    private WebElement phoneNumber;
    @FindBy(id = "Addl1")
    private WebElement addressLine;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "postalcode")
    private WebElement postalCode;
    @FindBy(xpath = "(//div[@class='select'])[2]/select")
    private WebElement setCountry;
    @FindBy(id = "Date")
    private WebElement DateOfBirths;

    @FindBy(id = "male")
    private WebElement genderMale;
    @FindBy(id = "female")
    private WebElement genderFemale;
    @FindBy(id = "trans")
    private WebElement genderTransgender;
    @FindBy(xpath ="//input[@type='checkbox']")
    private WebElement termsCheckbox;

    @FindBy(xpath ="//input[@type='submit']")
    private WebElement submitButton;


    public void setFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void setLastName(String lname){
        lastName.sendKeys(lname);
    }
    public void setEmail(String email){
        Email.clear();
        Email.sendKeys(email);
    }
    public void setPhoneNumber(String phoneNum){
        phoneNumber.sendKeys(phoneNum);
    }
    public void setAddressLine(String address){
        addressLine.sendKeys(address);
    }
    public void setState(String State){
        state.sendKeys(State);
    }
    public void setPostalCode(String zipcode){
        postalCode.sendKeys(zipcode);
    }

    public void setGender(String gender){
        switch(gender.toLowerCase()){
            case "male":
                genderMale.click();
                break;
            case "female":
                genderFemale.click();
                break;
            case "transgender":
                genderTransgender.click();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    public void setCountryCode(String countryCodes) {
        Select country = new Select(countryCode);
        country.selectByVisibleText(countryCodes);
    }
    public void setCountry(String country) {
        Select countrySelect = new Select(setCountry);
        countrySelect.selectByVisibleText(country);
    }
    public void setDateOfBirth(String dOB){

        DateOfBirths.sendKeys(dOB);
    }
    public void clickTermsAndConditions(){

        termsCheckbox.click();
    }
    public void clickSubmit(){

        submitButton.click();
    }

}
