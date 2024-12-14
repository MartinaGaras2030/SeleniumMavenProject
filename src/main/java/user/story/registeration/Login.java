package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    private String url = "https://automationexercise.com/login";
    private By email_input = By.xpath("//input[@data-qa='login-email']");
    private By password_input = By.xpath("//input[@data-qa='login-password']");
    private By login_button = By.xpath("//button[@data-qa='login-button']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }
@Step(" Enter correct email address and password")
    public Login login(String username, String password) {
        driver.findElement(email_input).sendKeys(username);
        driver.findElement(password_input).sendKeys(password);
        driver.findElement(login_button).click();
        return this;
    }
}

