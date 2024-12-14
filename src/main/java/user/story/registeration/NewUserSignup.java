package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserSignup {
    WebDriver driver;
    private String url = "https://automationexercise.com/login";
    private By nameField_input = By.name("name");
    private By emailField_input = By.cssSelector("input[data-qa='signup-email']");
    private By signUp_buttom = By.xpath("//button[@data-qa='signup-button']");

    public NewUserSignup(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }
@Step("Enter name and email address ")
    public NewUserSignup signup(String username, String email) {

        driver.findElement(nameField_input).sendKeys(username);
        driver.findElement(emailField_input).sendKeys(email);
        driver.findElement(signUp_buttom).click();
        return this;

    }


}
