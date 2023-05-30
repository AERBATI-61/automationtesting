package AdvancedSubject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://automationtesting.co.uk/");
    }
}
