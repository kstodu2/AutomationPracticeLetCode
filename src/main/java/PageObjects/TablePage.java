package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TablePage {
    public WebDriver driver;


    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(xpath ="//table[@id='shopping']/tbody/tr/td[2]")
    private List<WebElement> itemPriceList;
    @FindBy(css ="table[id='shopping'] tfoot td b")
    private WebElement totalPrice;
    @FindBy(xpath ="//table[@id='simpletable']/tbody/tr/td[2]")
    private List<WebElement> studentLastNameTable;

    @FindBy(xpath ="//table[@id='simpletable']/tbody/tr/td[4]/input")
    private List<WebElement> studentPresentCheckBox;

    @FindBy(xpath ="//table[contains(@class, 'mat-sort')]/tr/td[6]")
    private List<WebElement> desertCholesterol;
    @FindBy(xpath ="//th[@mat-sort-header='Cholesterol']")
    private WebElement sortDesertCholesterol;


    public int getShoppingListPrice() {
        int price = 0;
        for(WebElement item: itemPriceList){
            price += Integer.parseInt(item.getText());
        }
        return price;
    }
    public int getTotalPrice(){
        int price = Integer.parseInt(totalPrice.getText());
        return price;
    }
    public int getStudentIndexFromLastName(String studentName){
        int index = 0;
        for(WebElement student:studentLastNameTable){
            if(student.getText().toLowerCase().equals(studentName.toLowerCase())){
                return index;
            }

                index +=1;

        }
        return -1;
    }
    public void checkStudentPresent(int studentIndex){
        int index = 0;
        for(WebElement student: studentPresentCheckBox){
            if(index == studentIndex){
                student.click();
            }
            index+=1;
        }
    }
    public void sortASCCholesterolTable() {
        String tableSort = sortDesertCholesterol.getAttribute("aria-sort");
        while (!tableSort.equals("ascending")) {
            if (tableSort.equals("none")) {
                sortDesertCholesterol.click();
                tableSort = sortDesertCholesterol.getAttribute("aria-sort");
            }
            if (tableSort.equals("descending")) {
                sortDesertCholesterol.click();
                tableSort = sortDesertCholesterol.getAttribute("aria-sort");
            }
        }
    }
    public boolean checkCholesterolSorting() {
        List<Integer> cholTable = new ArrayList<>();
        for(WebElement chol: desertCholesterol){
            cholTable.add(Integer.parseInt(chol.getText()));
        }
        List<Integer> sortedTable = cholTable;
        Collections.sort(sortedTable);

        return cholTable.equals(sortedTable);
    }
}
