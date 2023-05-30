package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Pop_Ups {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/popups.html");
        driver.findElement(By.cssSelector("div:nth-of-type(1) > .col-12.col-12-small > button")).click();

        Thread.sleep(1000);

        String mainWindow = driver.getWindowHandle();


        Set<String> handles  = driver.getWindowHandles();


        Iterator<String> iterators = handles.iterator();
        while (iterators.hasNext()){
            String iterate = iterators.next();
            if (!mainWindow.equalsIgnoreCase(iterate)){
                driver.switchTo().window(iterate);
                Thread.sleep(3000);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div:nth-of-type(2) > .col-12.col-12-small > button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        driver.close();

    }
}
