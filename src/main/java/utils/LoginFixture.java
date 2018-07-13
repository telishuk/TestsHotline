package utils;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

import java.io.IOException;

public class LoginFixture extends Fixture{
    private static final Logger log = Logger.getLogger(LoginFixture.class);

    @BeforeSuite
    public static void login() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("Login");
        hotline.mainPage.clickLoginButton();
        hotline.loginPage.clearAllField();
        hotline.loginPage.fillLoginForm("telishuk@mail.ru", "gfhjkm100");
        hotline.loginPage.clickLoginButton();
    }

    @AfterSuite
    public static void logout() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("Logout");
        hotline.mainPage.clickLogoutButton();
    }
}
