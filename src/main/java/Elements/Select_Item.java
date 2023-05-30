package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Select_Item {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/dropdown.html");

        Select item = new Select(driver.findElement(By.xpath("/html//select[@id='cars']")));
//        item.selectByVisibleText("Jeep");
        item.selectByValue("jeep");


        breakBrowser();



    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }


}
