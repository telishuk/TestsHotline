package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.*;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

public class TestProduct extends Fixture{

    @Test
    @Parameters({"*******@mail.ru", "*******"})
    public void loginCustomer(String email, String password) throws Exception, NoSuchLocatorException{
        hotline.mainPage.openPage();
        hotline.mainPage.clickAgreeLocation();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();
        assertTrue(hotline.web.isElementPresent("ButtonLogin"), "Customer is not login");
    }

    @Test
    public void checkBasketIsEmpty() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.mainPage.checkBasket();
        assertTrue(hotline.web.isElementPresent("BasketEmpty"), "In the basket there is a product");
        hotline.mainPage.closeBasket();
    }

    @Test
    public void checkFilterPhone() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.productPage.openProductMobile();
        hotline.productPage.closeStageBorder();
        hotline.productPage.selectManufacturer();
        assertTrue(hotline.web.isElementPresent("ManufacturerApple"), "Phones not filtered");
    }


    @Test
    public void selectProductAuto() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.productPage.openProductAuto();
        hotline.productPage.selectProductAuto();
        hotline.productPage.clickImgProductAuto();
    }

    @Test
    public void addProductToBasket() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.productPage.openProductMobile();
        hotline.productPage.clickImgProductMobile();
        hotline.productPage.clickBuyProduct();
        assertTrue(hotline.web.isElementPresent("ButtonBuyProduct"), "Product was not added to basket");
    }

    @Test(enabled = false)
    public void checkCorrectPrice() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.mainPage.checkBasket();
        hotline.mainPage.goToTheBasket();
    }
}
