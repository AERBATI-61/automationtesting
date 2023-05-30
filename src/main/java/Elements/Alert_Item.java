package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Item {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/popups.html");

        driver.findElement(By.xpath("//div[@id='main']/div[@class='inner']//button[.='Trigger Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


        breakBrowser();
    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
