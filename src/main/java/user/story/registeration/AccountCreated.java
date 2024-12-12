package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreated {

    WebDriver driver;
    private String url = "https://automationexercise.com/";
    private By AccountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }
@Step("Verify that 'ACCOUNT CREATED!' is visible")
    public AccountCreated assertionOnCreateAccount(String ExcpectedText) {
        Assert.assertEquals(driver.findElement(AccountCreatedText).getText(), ExcpectedText);
        return this;
    }
@Step("Click 'Continue' button")
    public void continueButton() {
        driver.findElement(ContinueButton).click();
    }


}
