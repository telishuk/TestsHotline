package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import utils.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class TestLoginForm extends Fixture{

    private static final String mainUrl = "https://hotline.ua/";
    private RandomData randomData = new RandomData();
    public static final String email = "telishuk@mail.ru";
    public static final String password = "gfhjkm100";


    @Test
    public void switchToMainPage() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.mainPage.clickMainLogo();
        assertTrue(web.isElementPresent("LogoMainPage"), "Not switch to main page");
    }

    @Test
    public void loginFormEmpty() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickLoginButton();
        assertTrue(web.isElementPresent("LoginErrorsMessages"), "All fields don't empty ");
    }

    @Test
    public void fillCustomerLogin() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.fillDataClickEnter(email);
        assertTrue(web.isElementPresent("EmptyFieldError"), "Field password is don't empty ");
    }

    @Test
    public void fillCustomerPassword() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, randomData.getRandomString());
        hotline.loginPage.clickLoginButton();
        assertTrue(web.isElementPresent("LoginErrorsMessages"), "Password is correct");
    }


    /*
     * Test login Customer and don't logout with @BeforeClass used
     */
    @Test
    public void loginCustomer() throws Exception, NoSuchLocatorException{
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();
        assertTrue(web.isElementPresent("ButtonLogin"), "Customer is login");
    }


    /*
     * If browser don't close and Customer is logged in
     * Else you must open page and login Customer, then only logout
     */
    @Test
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        hotline.mainPage.clickLogoutButton();
        assertTrue(web.isElementPresent("ButtonLogout"), "Customer is not logout");
    }

    @Test
    public void testRegistrationLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickRegisterLink();
        assertTrue(web.isElementPresent("RegistrationForm"), "Registration form is not displayed");
    }

    @Test
    public void testForgotPasswordLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickForgotLink();
        assertTrue(web.isElementPresent("ForgotPasswordForm"), "I remember the password");
    }

    @Test
    //@Ignore
    public void testTermOfUseLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickTermOfUseLink();
        //Why don't work???
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.TAB);
    }

}
