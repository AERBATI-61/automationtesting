package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordion_Text {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/accordion.html");



        for (int i=1; i<=6; i++){
            for (int j=1; j<=24; j++){
                driver.findElement(By.xpath("//div[@id='main']/div[@class='inner']//div[@class='accordion']/div["+i+"]")).click();
            }
        }

        driver.close();



    }
}
