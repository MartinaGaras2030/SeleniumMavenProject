package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver initiateDriver(String browserName, boolean headlessExecution, boolean maximize) {
        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            if (headlessExecution) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            if (headlessExecution) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                driver = new EdgeDriver(options);
            } else {
                driver = new EdgeDriver();
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (headlessExecution) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            } else {
                driver = new FirefoxDriver();
            }
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        if (maximize) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}
