package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Asserts {
    public static WebDriver driver;


    @BeforeSuite
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://teststore.automationtesting.co.uk/");
        Thread.sleep(1000);
    }



    @Test
    public void enterEmailPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        Thread.sleep(1000);


//        Assert used
        Assert.fail();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        Thread.sleep(1000);
    }




    @Test(dependsOnMethods = {"enterEmailPassword"})
    public void clickButton() throws InterruptedException {
        WebElement element =  driver.findElement(By.xpath("/html//button[@id='submit-login']"));
        System.out.println(element.getText());
        element.click();

    }







    @AfterSuite
    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
