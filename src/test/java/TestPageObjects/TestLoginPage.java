package TestPageObjects;

import POM.LoginPage;
import Parametrisation.BasePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestLoginPage extends BasePage{


    public TestLoginPage() throws IOException {
        super();
    }

    @Test
    public void login(){
        driver = getDriver();
        driver.get(getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys("test@test.com");
        loginPage.getPassword().sendKeys("test123");
        loginPage.getLoginBtn().click();
    }



    @AfterSuite
    public static void breakBrowser() {
        driver.close();
        driver.quit();
    }


}
