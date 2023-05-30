package TestPageObjects;

import POM.*;
import Parametrisation.BasePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(Parametrisation.Listeners.class)

public class OrderCompleteTest extends BasePage {

    public OrderCompleteTest() throws IOException {
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
        Thread.sleep(3000);
        shopContentPanel.getCheckoutBtn().click();


        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.getHavePromo().click();
        shoppingCart.getPromoTextbox().sendKeys("20OFF");
        shoppingCart.getPromoAddBtn().click();
        Thread.sleep(2000);
        shoppingCart.getProceedCheckoutBtn().click();




        OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo(driver);
        orderFormPersInfo.getGenderMr().click();
        orderFormPersInfo.getFirstNameField().sendKeys("Jhon");
        orderFormPersInfo.getLastnameField().sendKeys("Smith");
        orderFormPersInfo.getEmailField().sendKeys("jhonsmith@test.com");
        orderFormPersInfo.getTermsConditionsCheckbox().click();
        Thread.sleep(2000);
        orderFormPersInfo.getContinueBtn().click();



        OrderFormDelivery orderFormDelivery = new OrderFormDelivery(driver);
        orderFormDelivery.getAddressField().sendKeys("Turkey");
        orderFormDelivery.getCityField().sendKeys("istanbul");
        Select state = new Select(orderFormDelivery.getStateDropdown());
        state.selectByVisibleText("New York");
        orderFormDelivery.getPostcodeField().sendKeys("77012");
        Thread.sleep(2000);
        orderFormDelivery.getContinueBtn().click();


        OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod(driver);
        orderFormShippingMethod.getDeliveryMsgTextbox().sendKeys("If you would like to add a comment.");
        Thread.sleep(2000);
        orderFormShippingMethod.getContinueBtn().click();


        OrderFormPayment orderFormPayment = new OrderFormPayment(driver);
        orderFormPayment.getPayByCheckRadioBtn().click();
        orderFormPayment.getTermsConditionsCheckbox().click();
        Thread.sleep(2000);
        orderFormPayment.getOrderBtn().click();


        Thread.sleep(5000);



    }



//    @AfterSuite
//    public void teamDown(){
//        driver.close();
//        driver = null;
//    }


}
