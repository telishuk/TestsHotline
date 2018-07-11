package tests;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;


import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;
import utils.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.JVM)
public class TestProduct {

    public WebDriver driver = RunnerTests.driver;
    public WebElementActions web = new WebElementActions(driver);
    public static final String mainUrl = "https://hotline.ua/";

    public static final String email = "telishuk@mail.ru";
    public static final String password = "gfhjkm100";


    @Test
    @Ignore
    public void loginCustomer() throws Exception, NoSuchLocatorException{
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAgreeLocation();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();

        assertTrue("Customer is not login", web.isElementPresent("ButtonLogin"));

    }

    @Test
    @Ignore
    public void checkBasketIsEmpty() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.checkEmptyBasket();
        assertTrue("In the basket there is a product", web.isElementPresent("BasketEmpty"));
        mainPage.closeEmpryBasket();
    }

    @Test
    @Ignore
    public void checkFilterPhone() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        ProductPage productPage = new ProductPage(driver);
        productPage.openProductMobile();
        productPage.closeStageBorder();
        productPage.selectManufacturer();
        assertTrue("Phones not filtered", web.isElementPresent("ManufacturerApple"));
    }


    @Test
    @Ignore
    public void selectProductAuto() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        ProductPage productPage = new ProductPage(driver);
        productPage.openProductAuto();
        productPage.selectProductAuto();
        productPage.clickImgProductAuto();
        assertTrue("Product not selected", web.isElementPresent("ImageProductAuto"));
    }

    @Test
   // @Ignore
    public void addProductToBasket() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        ProductPage productPage = new ProductPage(driver);
        productPage.openProductMobile();
        productPage.closeStageBorder();
        productPage.clickImgProductMobile();
        productPage.clickBuyProduct();
    }







}
