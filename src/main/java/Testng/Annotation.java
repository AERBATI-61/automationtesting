package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Annotation {
    public static WebDriver driver;


    @BeforeSuite
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    @BeforeMethod
    public void login() throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(3000);

    }


    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.linkText("CLOTHES")).click();
        Thread.sleep(3000);
    }


    @AfterMethod
    public void logout() throws InterruptedException {
        driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
        Thread.sleep(3000);
    }






    @AfterSuite
    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
