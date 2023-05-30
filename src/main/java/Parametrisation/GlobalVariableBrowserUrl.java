package Parametrisation;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import java.io.IOException;
@org.testng.annotations.Listeners(Parametrisation.Listeners.class)

public class GlobalVariableBrowserUrl extends BasePage implements ITestListener {

    public GlobalVariableBrowserUrl() throws IOException {
        super();
    }

    @Test
    public void login() throws InterruptedException, IOException {
        driver = getDriver();
        driver.get(getUrl());

        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
        driver.findElement(By.cssSelector("button#submit-login")).click();


//        Assert.assertEquals("1", "2");   // takeSnapShot calismasi icin bu kod acilmali
        Thread.sleep(3000);
    }


    public void onTestFailure(ITestResult result) {
        try {
            takeSnapShot(result.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @AfterSuite
    public static void breakBrowser() {
        driver.close();
        driver.quit();
    }
}
