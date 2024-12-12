package user.story.registeration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public String homeurl = "https://automationexercise.com/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
@Step("Navigate to url 'http://automationexercise.com'")
    public HomePage navigatetohome() {
        driver.navigate().to(homeurl);
        return this;
    }





}
