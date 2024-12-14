package exercise.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseOne {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.name("name")).sendKeys("Martina");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("martina2090@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");
          // lw fe select tag name

//        WebElement dropdownListDays = driver.findElement(By.id("days"));
//        Select selectObjectDays = new Select(dropdownListDays);
//        selectObjectDays.selectByValue("28");
//        WebElement dropdownListMonths = driver.findElement(By.id("months"));
//        Select selectObjectMonths = new Select(dropdownListMonths);
//        selectObjectMonths.selectByValue("11");
//        WebElement dropdownListYears = driver.findElement(By.id("years"));
//        Select selectObjectYears = new Select(dropdownListYears);
//        selectObjectYears.selectByValue("2001");

        // enhancing by using anonymous class
        new Select(driver.findElement(By.id("days"))).selectByValue("28");
        new Select(driver.findElement(By.id("months"))).selectByValue("11");
        new Select(driver.findElement(By.id("years"))).selectByValue("2001");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //Address information
        driver.findElement(By.id("first_name")).sendKeys("Martina");
        driver.findElement(By.id("last_name")).sendKeys("Ibrahim");
        driver.findElement(By.id("company")).sendKeys("Giza Systems");
        driver.findElement(By.id("address1")).sendKeys("Hadyek el zayton");
        driver.findElement(By.id("address2")).sendKeys("cairo");

        new Select(driver.findElement(By.id("country"))).selectByValue("Canada");
        //selectObject.selectByIndex(1);
        //selectObject.selectByVisibleText("");

        // no need to use x path there is a class that deal with dropdown list if the element is select so use select class
        // driver.findElement(By.xpath("//select[@id='country']/option[@value='Canada']")).click();

        driver.findElement(By.id("state")).sendKeys("N/A");
        driver.findElement(By.id("city")).sendKeys("cairo");
        driver.findElement(By.id("zipcode")).sendKeys("11725");
        driver.findElement(By.id("mobile_number")).sendKeys("068689990");
        //create account
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //delete account
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        System.out.println(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText());
        driver.quit();

    }

}
