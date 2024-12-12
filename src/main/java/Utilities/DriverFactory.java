package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    @Step("Launch browser")
    public static WebDriver initiateDriver(String browserName, boolean maximize) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        if (maximize) {
            driver.manage().window().maximize();
        }
        return driver;

    }
}