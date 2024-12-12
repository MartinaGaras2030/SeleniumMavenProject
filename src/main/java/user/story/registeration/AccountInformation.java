package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformation {

    WebDriver driver;
    private String url = "https://automationexercise.com/signup";
    private By gender = By.id("id_gender2");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter = By.id("newsletter");
    private By SpecialOffer = By.id("optin");

    private By firstname = By.id("first_name");
    private By SecondName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobilenumber = By.id("mobile_number");
    private By CreateAccountButton = By.xpath("//button[@data-qa='create-account']");

    public AccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }
@Step("Fill details: Title, Name, Email, Password, Date of birth,Select checkbox 'Sign up for our newsletter, Select checkbox 'Receive special offers from our partners")
    public AccountInformation accountInfo(String pass, String day, String month, String year) {
        driver.findElement(gender).click();
        driver.findElement(password).sendKeys(pass);
        new Select(driver.findElement(days)).selectByValue(day);
        new Select(driver.findElement(months)).selectByValue(month);
        new Select(driver.findElement(years)).selectByValue(year);
        driver.findElement(newsletter).click();
        driver.findElement(SpecialOffer).click();
        return this;
    }
    @Step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void addressInformation(String FirstName, String LastName, String Company, String Addressone, String Addresstwo, String Country, String State, String City, String Zipcode, String MobileNumber) {
        driver.findElement(firstname).sendKeys(FirstName);
        driver.findElement(SecondName).sendKeys(LastName);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(Addressone);
        driver.findElement(address2).sendKeys(Addresstwo);
        new Select(driver.findElement(country)).selectByValue(Country);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(Zipcode);
        driver.findElement(mobilenumber).sendKeys(MobileNumber);

        driver.findElement(CreateAccountButton).click();

    }


}
