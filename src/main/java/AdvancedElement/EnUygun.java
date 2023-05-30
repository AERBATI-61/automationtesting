package AdvancedElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EnUygun {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.enuygun.com/");


        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#CookieAlert svg")));
        driver.findElement(By.cssSelector("#CookieAlert svg")).click();

        driver.findElement(By.cssSelector("input#OriginInput")).click();
        driver.findElement(By.cssSelector("input#OriginInput")).sendKeys("istanbul");
        Thread.sleep(3000);

        List<WebElement> origins = driver.findElements(By.cssSelector(".react-autosuggest__suggestions-list li>div>div>div>span"));


        System.out.println(origins.size());
        for(WebElement origin: origins){
            System.out.println(origin.getText());
            if (origin.getText().contains("Sabiha Gökçen Havalimanı")){
                origin.click();
                break;
            }
        }
        Thread.sleep(3000);


        driver.findElement(By.cssSelector("input#DestinationInput")).click();
        driver.findElement(By.cssSelector("input#DestinationInput")).sendKeys("ankara");
        Thread.sleep(3000);
        List<WebElement> toOrigins = driver.findElements(By.cssSelector(".react-autosuggest__suggestions-list li>div>div>div>span"));

        System.out.println(toOrigins.size());
        for(WebElement origin: toOrigins){
            System.out.println(origin.getText());
            if (origin.getText().contains("Esenboğa Havalimanı")){
                origin.click();
                Thread.sleep(3000);
                break;
            }
        }


        driver.findElement(By.cssSelector(".block.primary-btn > span:nth-of-type(1)")).click();

        Thread.sleep(5000);




        breakBrowser();
    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}

