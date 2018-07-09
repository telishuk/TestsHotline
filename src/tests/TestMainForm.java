package tests;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
    @Ignore
    public void clickCloseLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
    }

    @Test
    public void clickAgreeLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAgreeCurrentLocation();
    }

    @Test
    public void clickCheckChoseAnotherCity() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        mainPage.clickCity();
        mainPage.chooseAnotherCity();
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
        mainPage.fillCustomerBirthDay("7", "2", "1988");
        mainPage.clickRadioButtonMale();
        mainPage.clickButtonSaveChanges();
       // log.info("<---------- Finished test ---------->");

    }

    @Test
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        mainPage.clickLogoutButton();
        //System.out.println(web.isElementPresent("ButtonLogout"));

    }


}
