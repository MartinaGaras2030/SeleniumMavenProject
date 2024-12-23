package test.cases;

import utilities.JsonFileManger;
import utilities.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import user.story.registeration.*;

import static utilities.DriverFactory.initiateDriver;


public class Register_User {
//    private JsonFileManger jsonFileManger;
    private WebDriver driver;
    private JsonFileManger testData;
    @BeforeClass
    public void setup() {
        driver = initiateDriver(System.getProperty("browserName"), Boolean.parseBoolean(System.getProperty("headlessExecution")),true);
       // driver = new ChromeDriver()
       // driver.manage().window().maximize();
        testData=new JsonFileManger("src/test/resources/TestDataJsonFile/TestData.json");
    }

    @Test
    @Description("Test case 1 Registration")
    @Severity(SeverityLevel.CRITICAL)
    public void TC1Register_User() {
        new HomePage(driver)
                .navigatetohome();
        new MainMenu(driver).signupLink();
        new NewUserSignup(driver)
               .signup(testData.getTestData("username"),testData.getTestData("email"));
        // Enter Account Information
        new AccountInformation(driver)
                .accountInfo("1234567890", "28", "11", "2001")
                //  Address Information
                .addressInformation("Martina", "Ibrahim", "Giza Systems", "Hadyek el zayton", "cairo", "Canada", "N/A", "cairo", "11725", "068689990");
        new AccountCreated(driver)
                .assertionOnCreateAccount("ACCOUNT CREATED!")
                .continueButton();

       new MainMenu(driver).delete_account();
        new AccountDeleted(driver)
                .assertionOnDEleteAccount()
                .continueButton();
    }
    @Test
    @Description("Test case 1 Login")
    public void TC2_Login_User(){
        new HomePage(driver).navigatetohome();
        new MainMenu(driver).signupLink();
        new Login(driver)
                .login(testData.getTestData("registereduser"),testData.getTestData("password"));
        new MainMenu(driver)
                .assertOnLoggedUser()
                .delete_account();
        new AccountDeleted(driver)
                .assertionOnDEleteAccount()
                .continueButton();

    }
    @AfterClass
    public void close_browser() {
        driver.quit();
    }
    @BeforeSuite
    public void beforeSuit(){
        PropertiesReader.loadProperties();
    }
}
