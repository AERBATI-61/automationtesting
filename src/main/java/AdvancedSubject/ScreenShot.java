package AdvancedSubject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://teststore.automationtesting.co.uk/");

//        takeSnapShot(driver);
        takeSectionShot(driver);

        driver.close();
    }

    public static void takeSnapShot(WebDriver webDriver) throws IOException {
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        File destincationFile = new File("/Users/arafat/RepeatSeleniumUdemy/files/screenShotFiles/" + timestamp() + ".png");
        FileUtils.copyFile(file, destincationFile);
    }



    public static void takeSectionShot(WebDriver webDriver) throws IOException {
        WebElement section = webDriver.findElement(By.xpath("//section[@id='content']/a/img"));
        File file = section.getScreenshotAs(OutputType.FILE);
        File destincationFile = new File("/Users/arafat/RepeatSeleniumUdemy/files/screenShotFiles/" + timestamp() + ".png");
        FileUtils.copyFile(file, destincationFile);
    }


    public static String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
