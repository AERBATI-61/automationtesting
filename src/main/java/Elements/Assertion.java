package Elements;






import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assertion {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]/span")).click();

        Thread.sleep(1000);

        String title = driver.getTitle();
        Assert.assertEquals("Homepage", title);

        driver.close();
        driver.quit();


    }
}
