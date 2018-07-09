package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.util.concurrent.TimeUnit;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestLoginForm extends Fixture{

    @Test
    public void switchToMainPage() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickMainLogo();
    }

    @Test
    public void loginFormEmpty() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        System.out.println(web.isElementPresent("LoginErrorsMessages"));
        //loginPage.displayedMassageErrors();
    }

    @Test
    public void fillCustomerLogin() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillDataClickEnter("telishuk@mail.ru");

        System.out.println(web.isElementPresent("EmptyFieldError"));
    }

    @Test
    public void fillCustomerPassword() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearPasswordField();
        loginPage.fillPasswordField(randomData.getRandomString());
        loginPage.clickLoginButton();

        //loginPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("EmptyFieldError"));
    }


    /*
     * Test login Customer and don't logout with @BeforeClass used
     */
    @Test
    public void loginCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();

        //System.out.println(web.isElementPresent("ButtonLogin"));
        //Assert.assertFalse("", web.isElementPresent("ButtonLogin"));

    }


    /*
     * If browser don't close and Customer is logged in
     * Else you must open page and login Customer, then only logout
     */
    @Test
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        mainPage.clickLogoutButton();
        //System.out.println(web.isElementPresent("ButtonLogout"));

    }

    @Test
    public void testRegistrationButton() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

    }

    @Test
    public void testForgotPasswordLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotLink();
    }

    @Test
    //@Ignore
    public void testTermOfUseLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickTermOfUseLink();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "W");
        driver.switchTo().defaultContent();
    }


}
