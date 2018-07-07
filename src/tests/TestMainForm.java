package tests;

import org.apache.log4j.Logger;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestMainForm extends Fixture{
    private static final Logger log = Logger.getLogger(Fixture.class);

    @Test
    public void switchToMainURL() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMainLogo();
    }

    @Test
    public void testCloseLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
    }

    @Test
    public void testAgreeLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAgreeCurrentLocation();
    }

    @Test
    public void testCheckChoseAnotherCity() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        mainPage.clickCity();
        mainPage.chooseAnotherCity();
    }


    @Test
    public void clickLogoutCustomer() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogoutButton();
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
        loginPage.clickLoginInButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage.clickUserDataForm();
        mainPage.fillCustomerData("Taras", "Telischuk");
        mainPage.clickRadioButtonMale();
        mainPage.fillCustomerBirthDay("7", "2", "1988");
        mainPage.clickRadioButtonMale();
        mainPage.clickButtonSaveChanges();
       // log.info("<---------- Finished test ---------->");

    }


}
