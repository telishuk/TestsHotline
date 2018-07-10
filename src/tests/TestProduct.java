package tests;

import org.junit.Test;


import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;

import java.util.concurrent.TimeUnit;


public class TestProduct extends Fixture {


    @Test
    public void test1() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");

        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickCustomerDataForm();
        driver.findElement(By.xpath(".//div[@class = 'cell-6 cell-sm']/label[1]")).click();

    }

    @Test
    public void test2() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);

    }



}
