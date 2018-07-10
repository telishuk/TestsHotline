package tests;

import org.junit.*;
import org.openqa.selenium.*;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestLoginForm extends Fixture{

    @Test
    public void switchToMainPage() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickMainLogo();

        assertTrue("Not switch to main page", web.isElementPresent("LogoMainPage"));
    }

    @Test
    public void loginFormEmpty() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

        assertTrue("All fields don't empty ", web.isElementPresent("LoginErrorsMessages"));

    }

    @Test
    public void fillCustomerLogin() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillDataClickEnter("telishuk@mail.ru");

        assertTrue("Field password is don't empty ", web.isElementPresent("EmptyFieldError"));
    }

    @Test
    public void fillCustomerPassword() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", randomData.getRandomString());
        loginPage.clickLoginButton();
        //loginPage.displayedMassageErrors();

        assertTrue("Password is correct", web.isElementPresent("LoginErrorsMessages"));
    }


    /*
     * Test login Customer and don't logout with @BeforeClass used
     */
    @Test
    public void loginCustomer() throws Exception, NoSuchLocatorException{
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();

        assertTrue("Customer is login", web.isElementPresent("ButtonLogin"));

    }


    /*
     * If browser don't close and Customer is logged in
     * Else you must open page and login Customer, then only logout
     */
    @Test
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        mainPage.clickLogoutButton();

        assertTrue("Customer is not logout", web.isElementPresent("ButtonLogout"));

    }

    @Test
    public void testRegistrationLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        assertTrue("Registration form is not displayed", web.isElementPresent("RegistrationForm"));

    }

    @Test
    public void testForgotPasswordLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotLink();
        assertTrue("I remember the password", web.isElementPresent("ForgotPasswordForm"));
    }

    @Test
    //@Ignore
    public void testTermOfUseLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickTermOfUseLink();

        //Why don't work???
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.TAB);

    }


}
