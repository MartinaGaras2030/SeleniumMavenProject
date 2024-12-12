package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeleted {
    WebDriver driver;
    private String url = "https://automationexercise.com/delete_account";
    private By AccountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountDeleted(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }

    @Step("Verify that 'ACCOUNT DELETED!' is visible ")
    public AccountDeleted assertionOnDEleteAccount() {
        Assert.assertTrue(driver.findElement(AccountDeletedText).getText().contains("DELETED"), "excpected ACCOUNT DELETED but found " + driver.findElement(AccountDeletedText).getText());
        return this;
    }

    @Step("Click 'Continue' button")
    public void continueButton() {
        driver.findElement(ContinueButton).click();
    }

}
