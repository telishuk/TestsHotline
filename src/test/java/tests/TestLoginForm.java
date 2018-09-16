package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import utils.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class TestLoginForm extends Fixture{

    private RandomData randomData = new RandomData();

    @Test
    public void switchToMainPage() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.mainPage.clickMainLogo();
        assertTrue(hotline.web.isElementPresent("LogoMainPage"), "Not switch to main page");
    }

    @Test
    public void loginFormEmpty() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickLoginButton();
        assertTrue(hotline.web.isElementPresent("LoginErrorsMessages"), "All fields don't empty ");
    }

    @Test
    @Parameters("*******@mail.ru")
    public void fillCustomerLogin(String email) throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.fillDataClickEnter(email);
        assertTrue(hotline.web.isElementPresent("EmptyFieldError"), "Field password is don't empty ");
    }

    @Test
    @Parameters("*******@mail.ru")
    public void fillCustomerPassword(String email) throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, randomData.getRandomString());
        hotline.loginPage.clickLoginButton();
        assertTrue(hotline.web.isElementPresent("LoginErrorsMessages"), "Password is correct");
    }

    @Test
    @Parameters({"*******@mail.ru", "*******"})
    public void loginCustomer(String email, String password) throws Exception, NoSuchLocatorException{
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();
        assertTrue(hotline.web.isElementPresent("ButtonLogin"), "Customer is login");
    }

    @Test
    @Parameters({"*******@mail.ru", "*******"})
    public void logoutCustomer(String email, String password) throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        hotline.mainPage.clickLogoutButton();
        assertTrue(hotline.web.isElementPresent("ButtonLogout"), "Customer is not logout");
    }

    @Test
    public void testRegistrationLink() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickRegisterLink();
        assertTrue(hotline.web.isElementPresent("RegistrationForm"), "Registration form is not displayed");
    }

    @Test
    public void testForgotPasswordLink() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickForgotLink();
        assertTrue(hotline.web.isElementPresent("ForgotPasswordForm"), "I remember the password");
    }

    @Test
    //@Ignore
    public void testTermOfUseLink() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clickTermOfUseLink();
        //Why don't work???
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.TAB);
    }

}
