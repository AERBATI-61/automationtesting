package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/buttons.html");

        driver.findElement(By.cssSelector("button#btn_three")).click();

        Thread.sleep(3000);


        breakBrowser();
    }


    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
