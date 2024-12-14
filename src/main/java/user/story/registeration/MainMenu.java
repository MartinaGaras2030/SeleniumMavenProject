package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainMenu {
    WebDriver driver;

    private By signUpAndsignInLink = By.xpath("//a[@href='/login']");
    private By DeleteAccountLink = By.xpath("//a[@href='/delete_account']");
    private By LoggedUserText = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By logouLink = By.xpath("//a[contains(text(), 'Logout')]");

    public MainMenu(WebDriver driver) {

        this.driver = driver;
    }

    @Step(" Click on 'Signup / Login' button")
    public void signupLink() {

        driver.findElement(signUpAndsignInLink).click();
    }

    @Step(" Click 'Delete Account' button")
    public void delete_account() {

        driver.findElement(DeleteAccountLink).click();
    }

    @Step("Verify that 'Logged in as username' is visible")
    public MainMenu assertOnLoggedUser() {
        Assert.assertTrue(driver.findElement(LoggedUserText).getText().contains("Martina"), "excpected  Logged in as Martina but found " + driver.findElement(LoggedUserText).getText());
        return this;
    }

    public MainMenu logout() {
        driver.findElement(logouLink).click();
        return this;
    }

}
