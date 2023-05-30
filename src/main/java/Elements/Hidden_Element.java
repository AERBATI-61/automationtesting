package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Hidden_Element {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/hiddenElements.html");

        String hiddenText = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(2)")).getText();
        System.out.println(hiddenText);

        Thread.sleep(1);

        boolean isDisplayedItem1 = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(2)")).isDisplayed();
        System.out.println(isDisplayedItem1);

        Thread.sleep(1);


        String visibleText = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(3)")).getText();
        System.out.println(visibleText);

        Thread.sleep(1);

        boolean isDisplayedItem2 = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(3)")).isDisplayed();
        System.out.println(isDisplayedItem2);


        boolean itsNotHidden = false;
        try{
            String hidden_Text = driver.findElement(By.cssSelector("div#myDIV")).getText();
            System.out.println(hidden_Text);

        }
        finally {
            System.out.println("Boyle bir element Yok!");
            itsNotHidden = true;
        }

        System.out.println("itsNotHidden: " + itsNotHidden);


        driver.findElement(By.cssSelector("button")).click();
        String hidden_Text_clicked = driver.findElement(By.cssSelector("div#myDIV")).getText();
        System.out.println(hidden_Text_clicked);
        System.out.println("Boyle bir element Var!");


        Thread.sleep(3);




        driver.close();
    }
}
