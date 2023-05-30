package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_Button {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/dropdown.html");


        driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[for='demo-priority-normal']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();
        Thread.sleep(1000);

        breakBrowser();
    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
