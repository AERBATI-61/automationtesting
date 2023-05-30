package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/buttons.html");
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]/span")).click();

        /*   // By.id()   By.name()   By.linkText()   By.cssSelector()   By.xpath()
        driver.findElement(By.id("btn_one")).click();
        driver.findElement(By.name("first_name")).sendKeys("Arafat");
        driver.findElement(By.linkText("ACTIONS")).click();
        driver.findElement(By.cssSelector("button#btn_one")).click();
        driver.findElement(By.xpath("/html//button[@id='btn_one']")).click();
         */

        driver.findElement(By.xpath("/html//button[@id='btn_one']")).click();


        Thread.sleep(1000);
        driver.quit();
        driver.close();






    }
}
