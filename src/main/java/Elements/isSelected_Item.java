package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class isSelected_Item {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/dropdown.html");


        boolean isSelectedRed = driver.findElement(By.xpath("//*[@id=\"cb_red\"]")).isSelected();
        System.out.println(isSelectedRed);


        boolean isSelectedBlu = driver.findElement(By.id("cb_blue")).isSelected();
        System.out.println(isSelectedBlu);

        Thread.sleep(3000);

        breakBrowser();


    }

    public static void breakBrowser(){
        driver.close();
        driver.quit();
    }


}
