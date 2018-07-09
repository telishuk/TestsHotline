package utils;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;

public class LoginFixture extends Fixture{

    @BeforeClass
    public static void login() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        System.out.println("Login");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearAllField();
        loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        loginPage.clickLoginButton();
    }

    @AfterClass
    public static void logout() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        System.out.println("Logout");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogoutButton();
    }
}
