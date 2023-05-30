package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class isEnabled_Item {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/buttons.html");

        System.out.println(driver.findElement(By.xpath("/html//button[@id='btn_two']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("/html//button[@id='btn_four']")).isEnabled());


        breakBrowser();

    }


    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
