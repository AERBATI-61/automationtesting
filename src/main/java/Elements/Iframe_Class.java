package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_Class {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/iframes.html");
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.cssSelector("strong")).getText());

//        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector(".toggle")).click();
        Thread.sleep(4000);
        driver.close();



    }
}
