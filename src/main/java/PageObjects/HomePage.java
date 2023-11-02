package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(css = ".card-footer-item[href='/edit']")
    private WebElement inputTestButton;

    @FindBy(xpath = "//a[@href='/buttons']")
    private WebElement buttonTestButton;

    @FindBy(css = ".card-footer-item[href$='/dropdowns']")
    private WebElement dropdownTestButton;

    @FindBy(xpath = "//a[@href='/alert']")
    private WebElement alertTestButton;

    @FindBy(xpath = "//a[@href='/frame']")
    private WebElement frameTestButton;

    @FindBy(xpath = "//a[@href='/radio']")
    private WebElement radioTestButton;

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement windowTestButton;

    @FindBy(xpath = "//a[@href='/elements']")
    private WebElement elementsTestButton;

    @FindBy(xpath = "//a[@href='/draggable']")
    private WebElement dragTestButton;

    @FindBy(xpath = "//a[@href='/dropable']")
    private WebElement dropTestButton;

    @FindBy(xpath = "//a[@href='/sortable']")
    private WebElement sortTestButton;

    @FindBy(xpath = "//a[@href='/selectable']")
    private WebElement multiSelectTestButton;
    @FindBy(xpath = "//a[@href='/slider']")
    private WebElement sliderButton;
    @FindBy(xpath = "//a[@href='/table']")
    private WebElement tableButton;
    @FindBy(xpath = "//a[@href='/advancedtable']")
    private WebElement advanceTableButton;
    @FindBy(xpath = "//a[@href='/calendar']")
    private WebElement calendarButton;
    @FindBy(xpath = "//a[@href='/waits']")
    private WebElement waitButton;
    @FindBy(xpath = "//a[@href='/forms']")
    private WebElement formsButton;
    @FindBy(xpath = "//a[@href='/file']")
    private WebElement fileButton;
    @FindBy(xpath = "//a[@href='/shadow']")
    private WebElement shadowButton;
    @FindBy(xpath = "//a[@href='/game']")
    private WebElement snakeGameButton;


    public void clickInput() {
        inputTestButton.click();
    }

    public void clickButton() {
        buttonTestButton.click();
    }

    public void clickSelect() {
        dropdownTestButton.click();
    }

    public void clickAlert() {
        alertTestButton.click();
    }

    public void clickFrame() {
        frameTestButton.click();
    }

    public void clickRadio() {
        radioTestButton.click();
    }

    public void clickWindow() {
        windowTestButton.click();
    }

    public void clickElements() {
        elementsTestButton.click();
    }

    public void clickDrag() {
        dragTestButton.click();
    }

    public void clickDrop() {
        dropTestButton.click();
    }

    public void clickSort() {
        sortTestButton.click();
    }

    public void clickMultiSelect() {
        multiSelectTestButton.click();
    }

    public void clickSlider() {
        sliderButton.click();
    }

    public void clickTable() {
        tableButton.click();
    }

    public void clickAdvanceTable() {
        advanceTableButton.click();
    }

    public void clickCalendar() {
        calendarButton.click();
    }

    public void clickWait() {
        waitButton.click();
    }

    public void clickFile() {
        fileButton.click();
    }

    public void clickShadow() {
        shadowButton.click();
    }

    public void clickSnake() {
        snakeGameButton.click();
    }
    public void clickForms() {
        formsButton.click();
    }



}