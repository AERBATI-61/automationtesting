package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProviders {
    public static WebDriver driver;


    @BeforeSuite
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];

        data[0][0] = "test2@test.com";
        data[0][1] = "test12345";

        data[1][0] = "test@test.com";
        data[1][1] = "test123";

        data[2][0] = "doesntexist@test.com";
        data[2][1] = "xxxxxxx";


        return data;

    }

    @Test(dataProvider = "getData")
    public void login(String email, String password) throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
        Thread.sleep(3000);

    }







    @AfterSuite
    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }
}
