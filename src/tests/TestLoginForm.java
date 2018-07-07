package tests;

import org.junit.*;
import org.openqa.selenium.*;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.util.concurrent.TimeUnit;

public class TestLoginForm extends Fixture{

    @Test
    public void returnToMainPage() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        mainPage.clickMainLogo();
    }

    @Test
    public void showLoginForm() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginInButton();
        System.out.println(web.isElementPresent("LoginErrorsMassages"));
        //loginPage.displayedMassageErrors();
    }

    @Test
    public void fillUserLogin() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillDataClickEnter("telishuk@mail.ru");

        System.out.println(web.isElementPresent("EmptyFieldError"));
    }

    @Test
    public void fillUserPassword() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearPasswordField();
        loginPage.fillPasswordField(randomData.getRandomString());
        loginPage.clickLoginInButton();

        //loginPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("EmptyFieldError"));
    }

    @Test
    public void fillUserData() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");

        loginPage.clickLoginInButton();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        mainPage.clickLogoutButton();
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
    public void testTermOfUseLink() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickTermOfUseLink();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
        driver.switchTo().defaultContent();
    }


}
