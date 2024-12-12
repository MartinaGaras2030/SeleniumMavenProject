package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
    WebDriver driver;

    private By signUpAndsignInLink = By.xpath("//a[@href='/login']");
    private By DeleteAccountLink = By.xpath("//a[@href='/delete_account']");

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
}
