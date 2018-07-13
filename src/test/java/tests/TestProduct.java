package tests;

import org.testng.annotations.Test;
import utils.*;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

public class TestProduct extends Fixture{

    public static final String mainUrl = "https://hotline.ua/";
    public static final String email = "telishuk@mail.ru";
    public static final String password = "gfhjkm100";


    @Test(enabled = false)
    public void loginCustomer() throws Exception, NoSuchLocatorException{
        web.openPage(mainUrl);
        hotline.mainPage.clickAgreeLocation();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        assertTrue(web.isElementPresent("ButtonLogin"), "Customer is not login");
    }

    @Test
    public void checkBasketIsEmpty() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        hotline.mainPage.checkBasket();
        assertTrue(web.isElementPresent("BasketEmpty"), "In the basket there is a product");
        hotline.mainPage.closeBasket();
    }

    @Test
    public void checkFilterPhone() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.productPage.switchToMainPage();
        hotline.productPage.openProductMobile();
        hotline.productPage.closeStageBorder();
        hotline.productPage.selectManufacturer();
        assertTrue(web.isElementPresent("ManufacturerApple"), "Phones not filtered");
    }


    @Test
    public void selectProductAuto() throws Exception, NoSuchLocatorException {
        hotline.productPage.switchToMainPage();
        hotline.productPage.openProductAuto();
        hotline.productPage.selectProductAuto();
        hotline.productPage.clickImgProductAuto();
    }

    @Test
    public void addProductToBasket() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.productPage.switchToMainPage();
        hotline.productPage.openProductMobile();
        hotline.productPage.clickImgProductMobile();
        hotline.productPage.clickBuyProduct();
        assertTrue(web.isElementPresent("ButtonBuyProduct"), "Product was not added to basket");
    }

    @Test(enabled = false)
    public void checkCorrectPrice() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.productPage.switchToMainPage();
        hotline.mainPage.checkBasket();
        hotline.mainPage.goToTheBasket();
    }
}
