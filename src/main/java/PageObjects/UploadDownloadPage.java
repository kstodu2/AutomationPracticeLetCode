package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class UploadDownloadPage {
    public WebDriver driver;


    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadButton;

    @FindBy(id = "xls")
    private WebElement downloadExcel;
    @FindBy(id = "pdf")
    private WebElement downloadPdf;
    @FindBy(id = "txt")
    private WebElement downloadText;

    public void uploadFile(String filePath){
        uploadButton.sendKeys(filePath);
    }
    public void downloadExcel(String filePath){
        uploadButton.sendKeys(filePath);
    }
    public void downloadPdf(String filePath){
        uploadButton.sendKeys(filePath);
    }
    public void downloadText(String filePath){
        uploadButton.sendKeys(filePath);
    }

}
