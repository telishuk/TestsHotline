package tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestMainForm extends Fixture{

    private static final Logger log = Logger.getLogger(Fixture.class);

    @Test
    public void switchToMainURL() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMainLogo();
    }

    @Test
    //@Ignore
    public void clickCloseLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("Button not found", web.isElementPresent("CloseLocationMenu"));
        mainPage.clickCloseLocationMenu();
        Assert.assertFalse("Location menu is displayed", web.isElementPresent("LocationMenu"));

    }

    @Test
    //@Ignore
    public void clickAgreeLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("Button not found", web.isElementPresent("ButtonAgreeLocation"));
        mainPage.clickAgreeLocation();
        Assert.assertFalse("Location menu is displayed", web.isElementPresent("LocationMenu"));
    }

    @Test
    public void clickAnotherCity() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        mainPage.clickCity();
        Assert.assertTrue("City is not selected", web.isElementPresent("CityOdessa"));
        mainPage.selectAnotherCity();
    }

    @Test
    public void fillCustomerData() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        //log.info("<---------- Start test filling customer data ---------->");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage.clickCustomerDataForm();
        mainPage.fillCustomerData("Taras", "Telischuk");
        mainPage.clickRadioButtonMale();
        mainPage.clickButtonSaveChanges();
        Assert.assertEquals("Data was NOT added!", "Taras", web.getValue("CustomerFirstNameField"));
        // log.info("<---------- Finished test ---------->");
    }


    @Test
    public void fillCustomerBirthday() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        //log.info("<---------- Start test filling customer data ---------->");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.clickCustomerDataForm();
        mainPage.fillCustomerBirthDay("6", "5", "1965");
        mainPage.clickButtonSaveChanges();
       // log.info("<---------- Finished test ---------->");

    }

    @Test
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        mainPage.clickLogoutButton();

        //Assert.assertFalse("Customer is logout", web.isElementPresent("LoginForm"));
        Assert.assertTrue("Customer is not logout", web.isElementPresent("ButtonLogin"));
    }


}
