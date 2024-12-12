package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserSignup {
    WebDriver driver;
    private String url = "https://automationexercise.com/login";
    private By nameField = By.name("name");
    private By emailField = By.cssSelector("input[data-qa='signup-email']");
    private By SignUpButtom = By.xpath("//button[@data-qa='signup-button']");

    public NewUserSignup(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }
@Step("Enter name and email address ")
    public NewUserSignup signup(String username, String email) {

        driver.findElement(nameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(SignUpButtom).click();
        return this;

    }


}
