package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Browser_Tabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/browserTabs.html");

        for (int i=0; i<=2; i++){
            driver.findElement(By.cssSelector("form[target='_blank'] > input[value='Open Tab']")).click();
        }

        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());

        for (String handle: handles){
            Thread.sleep(1000);
            driver.switchTo().window(handle);

        }
        driver.switchTo().window(handles.get(1));
        driver.findElement(By.id("APjFqb")).sendKeys("Youtube");
        driver.findElement(By.className("CcAdNb")).click();

        Thread.sleep(3000);

        driver.close();



    }
}
