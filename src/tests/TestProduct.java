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

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProduct {

    public WebDriver driver = RunnerTests.driver;
    public WebElementActions web = new WebElementActions(driver);
    public static final String mainUrl = "https://hotline.ua/";

    public static final String email = "telishuk@mail.ru";
    public static final String password = "gfhjkm100";


    @Test
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
    public void selectProductAddToBasket() throws Exception, NoSuchLocatorException {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        ProductPage productPage = new ProductPage(driver);
        productPage.openProductMobile();
        productPage.selectManufacturer();
    }







}
