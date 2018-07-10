package tests;

import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.*;
import pages.LoginPage;
import pages.MainPage;
import utils.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestLoginForm {

    public WebDriver driver = RunnerTests.driver;
    public WebElementActions web = new WebElementActions(driver);
    private static final String mainUrl = "https://hotline.ua/";
    private RandomData randomData = new RandomData();
    public static final String email = "telishuk@mail.ru";
    public static final String password = "gfhjkm100";


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
        loginPage.fillDataClickEnter(email);

        assertTrue("Field password is don't empty ", web.isElementPresent("EmptyFieldError"));
    }

    @Test
    public void fillCustomerPassword() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm(email, randomData.getRandomString());
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
        loginPage.fillLoginForm(email, password);
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
