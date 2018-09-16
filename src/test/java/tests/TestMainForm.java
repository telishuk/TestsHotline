package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestMainForm extends Fixture {

    @Test(groups = "positive")
    public void switchToMainURL() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickMainLogo();
    }

    @Test(enabled = false)
    public void clickCloseLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        Assert.assertTrue(hotline.web.isElementPresent("CloseLocationMenu"), "Button not found");
        hotline.mainPage.clickCloseLocationMenu();
        Assert.assertFalse(hotline.web.isElementPresent("LocationMenu"), "Location menu is displayed");
    }

    @Test(enabled = false)
    public void clickAgreeLocation() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        Assert.assertTrue(hotline.web.isElementPresent("ButtonAgreeLocation"), "Button not found");
        hotline.mainPage.clickAgreeLocation();
        Assert.assertFalse(hotline.web.isElementPresent("LocationMenu"), "Location menu is displayed");
    }

    @Test
    public void clickAnotherCity() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickCloseLocationMenu();
        hotline.mainPage.clickCity();
        Assert.assertTrue(hotline.web.isElementPresent("CityOdessa"), "City is not selected");
        hotline.mainPage.selectAnotherCity();
    }

    @Test(groups = "positive")
    @Parameters({"*******@mail.ru", "*******"})
    public void fillCustomerData(String email, String password) throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickCloseLocationMenu();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        hotline.mainPage.clickCustomerDataForm();
        hotline.mainPage.fillCustomerData("*******", "*******");
        hotline. mainPage.clickRadioButtonMale();
        hotline.mainPage.clickButtonSaveChanges();
        Assert.assertEquals(hotline.web.getValueOfElement("CustomerFirstNameField"), "Taras", "Data was NOT added!");
        hotline.mainPage.clickMainLogo();
        hotline.mainPage.clickLogoutButton();
    }


    @Test
    @Parameters({"*******@mail.ru", "*******"})
    public void fillCustomerBirthday(String email, String password) throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm(email, password);
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        hotline.mainPage.clickCustomerDataForm();
        hotline.mainPage.fillCustomerBirthDay("*******", "*******", "*******");
        hotline.mainPage.clickButtonSaveChanges();
        hotline.mainPage.clickMainLogo();
        hotline.mainPage.clickLogoutButton();
        Assert.assertTrue(hotline.web.isElementPresent("ButtonLogin"), "Customer is not logout");
    }

    @Test(groups = "positive")
    public void logoutCustomer() throws Exception, NoSuchLocatorException {
        hotline.mainPage.openPage();
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm("*******@mail.ru", "*******");
        hotline.loginPage.clickLoginButton();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        hotline.mainPage.clickLogoutButton();
        Assert.assertTrue(hotline.web.isElementPresent("ButtonLogin"), "Customer is not logout");
    }


}
