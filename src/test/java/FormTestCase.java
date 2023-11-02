import PageObjects.FormPage;
import PageObjects.HomePage;
import PageObjects.WaitPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.baseTest;

import java.io.IOException;

public class FormTestCase extends baseTest {

    public WebDriver driver;
    private HomePage homePage;
    private FormPage formPage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        formPage = new FormPage(driver);
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void clickForms() {
        homePage.clickForms();
    }
    @Test(dataProvider = "formData", priority = 2 )
    public void setFillForm(String firstName, String lastName, String email, String countryCodes, String phoneNumber,
                            String addressLine, String state, String postalCode,
                            String country, String dateOfBirth, String gender) {
        formPage.setFirstName(firstName);
        formPage.setLastName(lastName);
        formPage.setEmail(email);
        formPage.setCountryCode(countryCodes);
        formPage.setPhoneNumber(phoneNumber);
        formPage.setAddressLine(addressLine);
        formPage.setState(state);
        formPage.setPostalCode(postalCode);
        formPage.setCountry(country);
        formPage.setGender(gender);
        formPage.setDateOfBirth(dateOfBirth);
        formPage.clickTermsAndConditions();
        formPage.clickSubmit();

    }
    @AfterClass
    public void close() {
        driver.close();
    }



    @DataProvider(name = "formData")
    public Object[][] testData() {

        Object[][] data = new Object[1][11];
        data[0][0] = "John"; // First Name
        data[0][1] = "Doe"; // Last Name
        data[0][2] = "JohnDoe@Email.com"; // Email
        data[0][3] = "Kazakhstan (+7)"; // Country Code
        data[0][4] = "1234567890"; // Phone Number
        data[0][5] = "5225 Washington St."; // Address-Line
        data[0][6] = "Alaska"; // State
        data[0][7] = "22222"; // Postal Code
        data[0][8] = "United States"; // Country
        data[0][9] = "11-11-1911"; // DateofBirth mm-dd-yyyy
        data[0][10] = "Male"; //Gender

        return data;
    }
}
