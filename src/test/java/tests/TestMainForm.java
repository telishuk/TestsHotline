package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestMainForm extends Fixture {

    private static final String mainUrl = "https://hotline.ua/";

    @Test(groups = "positive")
    public void switchToMainURL() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickMainLogo();
    }

    @Test(enabled = false)
    public void clickCloseLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        Assert.assertTrue(web.isElementPresent("CloseLocationMenu"), "Button not found");
        hotline.mainPage.clickCloseLocationMenu();
        Assert.assertFalse(web.isElementPresent("LocationMenu"), "Location menu is displayed");
    }

    @Test(enabled = false)
    public void clickAgreeLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        Assert.assertTrue(web.isElementPresent("ButtonAgreeLocation"), "Button not found");
        hotline.mainPage.clickAgreeLocation();
        Assert.assertFalse(web.isElementPresent("LocationMenu"), "Location menu is displayed");
    }

    @Test
    public void clickAnotherCity() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        hotline.mainPage.clickCloseLocationMenu();
        hotline.mainPage.clickCity();
        Assert.assertTrue(web.isElementPresent("CityOdessa"), "City is not selected");
        hotline.mainPage.selectAnotherCity();
    }

    @Test(groups = "positive")
    @Parameters({"telishuk@mail.ru", "gfhjkm100"})
    public void fillCustomerData(String email, String password) throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        hotline.mainPage.clickCloseLocationMenu();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        hotline.mainPage.clickCustomerDataForm();
        hotline.mainPage.fillCustomerData("Taras", "Telischuk");
        hotline. mainPage.clickRadioButtonMale();
        hotline.mainPage.clickButtonSaveChanges();
        Assert.assertEquals( web.getValueOfElement("CustomerFirstNameField"), "Taras", "Data was NOT added!");
    }


    @Test
    @Parameters({"telishuk@mail.ru", "gfhjkm100"})
    public void fillCustomerBirthday(String email, String password) throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        hotline.mainPage.clickCustomerDataForm();
        hotline.mainPage.fillCustomerBirthDay("3", "5", "1988");
        hotline. mainPage.clickButtonSaveChanges();
    }

    @Test(groups = "positive")
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        hotline.mainPage.clickLogoutButton();
        Assert.assertTrue(web.isElementPresent("ButtonLogin"), "Customer is not logout");
    }


}