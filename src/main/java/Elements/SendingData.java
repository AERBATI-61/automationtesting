package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Elements.Buttons.breakBrowser;

public class SendingData {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/contactForm.html");

        driver.findElement(By.cssSelector("form#contact_form > input[name='first_name']")).sendKeys("test");
        driver.findElement(By.cssSelector("form#contact_form > input[name='last_name']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("form#contact_form > input[name='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("form#contact_form > textarea[name='message']")).sendKeys("sen kim ?");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Thread.sleep(3000);


        breakBrowser();



    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }

}
