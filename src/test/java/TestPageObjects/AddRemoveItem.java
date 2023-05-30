package TestPageObjects;

import POM.*;
import Parametrisation.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
@Listeners(Parametrisation.Listeners.class)

public class AddRemoveItem extends BasePage {
    public AddRemoveItem() throws IOException {
        super();
    }

    @BeforeTest
    public void sutUp(){
        driver = getDriver();
        driver.get(getUrl());
    }

    @Test
    public void endToEndTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

//        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
//        jse.executeScript("arguments[0].scrollIntoView()", homePage.getTestStoreLink());

        homePage.getAlertBtn().click();
        homePage.getTestStoreLink().click();




        ShopHomepage shopHomepage = new ShopHomepage(driver);
        shopHomepage.getProdOne().click();


        ShopProductPage shopProductPage = new ShopProductPage(driver);
        Select size = new Select(shopProductPage.getSizeOption());
        size.selectByVisibleText("M");
        shopProductPage.getQuantIncrease().click();
        Thread.sleep(2000);
        shopProductPage.getAddToCartBtn().click();


        ShopContentPanel shopContentPanel = new ShopContentPanel(driver);
        Thread.sleep(2000);
        shopContentPanel.getContinueShopBtn().click();
        Thread.sleep(2000);
        shopProductPage.getHomepageLink().click();
        shopHomepage.getProdTwo().click();
        Thread.sleep(1000);
        shopProductPage.getAddToCartBtn().click();
        Thread.sleep(2000);
        shopContentPanel.getCheckoutBtn().click();



        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.getDeleteItemOne().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.getDeleteItemOne()));
        System.out.println(shoppingCart.getTotalAmount().getText());
        Assert.assertEquals(shoppingCart.getTotalAmount().getText(),"$35.72");

        Thread.sleep(5000);

    }



    @AfterSuite
    public void teamDown(){
        driver.close();
        driver = null;
    }
}
