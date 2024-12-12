//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.security.PrivateKey;
//
//public class TestNGDemo {
//    WebDriver driver;
//    // xpath has a benefit to get element by text and index but let it be the last option
//    private By signinLink = By.xpath("//a[@href='/login']");
//    private By nameField = By.name("name");
//    private By emailField = By.cssSelector("input[data-qa='signup-email']");
//    private By SignUpButtom = By.xpath("//button[@data-qa='signup-button']");
//
//    private By gender = By.id("id_gender2");
//    private By password = By.id("password");
//    private By days = By.id("days");
//    private By months = By.id("months");
//    private By years = By.id("years");
//    private By newsletter = By.id("newsletter");
//    private By SpecialOffer = By.id("optin");
//
//    private By firstname = By.id("first_name");
//    private By SecondName = By.id("last_name");
//    private By company = By.id("company");
//    private By address1 = By.id("address1");
//    private By address2 = By.id("address2");
//    private By country = By.id("country");
//    private By state = By.id("state");
//    private By city = By.id("city");
//    private By zipcode = By.id("zipcode");
//    private By mobilenumber = By.id("mobile_number");
//    private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");
//    private By CreateAccountButton = By.xpath("//button[@data-qa='create-account']");
//    private By AccountCreatedText = By.xpath("//h2[@data-qa='account-created']");
//    private By DeleteAccountLink = By.xpath("//a[@href='/delete_account']");
//    private By AccountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
//
//
//    @BeforeClass
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://automationexercise.com/");
//    }
//
//    @Test
//    public void TC1Register_User() {
//        signup("Martina", "martina575@gmail.com");
//        // Enter Account Information
//        AccountInfo("1234567890", "28", "11", "2001");
//        //  Address Information
//        AddressInformation("Martina", "Ibrahim", "Giza Systems", "Hadyek el zayton", "cairo", "Canada", "N/A", "cairo", "11725", "068689990");
//        AssertionOnCreateAccount("ACCOUNT CREATED!");
//        continueButton();
//        delete_account();
//        AssertionOnDEleteAccount();
//    }
//
////    @AfterMethod
////    public void delete_account() {
////        driver.findElement(DeleteAccountLink).click();
////        AssertionOnDEleteAccount();
////    }
//
//    @AfterClass
//    public void close_browser() {
//        driver.quit();
//    }
//
//    private void signup(String username, String email) {
//        driver.findElement(signinLink).click();
//        driver.findElement(nameField).sendKeys(username);
//        driver.findElement(emailField).sendKeys(email);
//        driver.findElement(SignUpButtom).click();
//
//    }
//
//    private void AccountInfo(String pass, String day, String month, String year) {
//        driver.findElement(gender).click();
//        driver.findElement(password).sendKeys(pass);
//        new Select(driver.findElement(days)).selectByValue(day);
//        new Select(driver.findElement(months)).selectByValue(month);
//        new Select(driver.findElement(years)).selectByValue(year);
//        driver.findElement(newsletter).click();
//        driver.findElement(SpecialOffer).click();
//    }
//
//    private void AddressInformation(String FirstName, String LastName, String Company, String Addressone, String Addresstwo, String Country, String State, String City, String Zipcode, String MobileNumber) {
//        driver.findElement(firstname).sendKeys(FirstName);
//        driver.findElement(SecondName).sendKeys(LastName);
//        driver.findElement(company).sendKeys(Company);
//        driver.findElement(address1).sendKeys(Addressone);
//        driver.findElement(address2).sendKeys(Addresstwo);
//        new Select(driver.findElement(country)).selectByValue(Country);
//        driver.findElement(state).sendKeys(State);
//        driver.findElement(city).sendKeys(City);
//        driver.findElement(zipcode).sendKeys(Zipcode);
//        driver.findElement(mobilenumber).sendKeys(MobileNumber);
//
//        driver.findElement(CreateAccountButton).click();
//
//    }
//
//    private void AssertionOnCreateAccount(String ExcpectedText) {
//        Assert.assertEquals(driver.findElement(AccountCreatedText).getText(), ExcpectedText);
//    }
//
//    private void continueButton() {
//        driver.findElement(ContinueButton).click();
//    }
//
//    private void delete_account() {
//        driver.findElement(DeleteAccountLink).click();
//    }
//
//    private void AssertionOnDEleteAccount() {
//        Assert.assertTrue(driver.findElement(AccountDeletedText).getText().contains("DELETED"), "excpected ACCOUNT DELETED but found " + driver.findElement(AccountDeletedText).getText());
//    }
//}
