package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementsPage {
    public WebDriver driver;
    private List<String> windowHandles;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(name = "username")
    private WebElement githubUserName;
    @FindBy(id = "search")
    private WebElement githubSearchButton;
    @FindBy(xpath = "//img[@alt='Placeholder image']")
    private WebElement profilePicture;
    @FindBy(css = "div[class='block'] ol[type='1'] li")
    private List<WebElement> profilePublicRepo;

    public void enterUserName(String username){
        githubUserName.sendKeys(username);
    }
    public void clickSearch(){
        githubSearchButton.click();
    }
    public boolean checkProfilePicture(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement porfileLoad = wait.until(ExpectedConditions.visibilityOf(profilePicture));
        if(profilePicture.getAttribute("src").isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public int checkNumPublicRepos(){

        int i = 0;
        for(WebElement repo: profilePublicRepo){
            i++;
        }
        return i;
    }

}
