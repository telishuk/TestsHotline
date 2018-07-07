package tests;

import org.apache.log4j.Logger;
import org.junit.Test;
import pages.RegistrationPage;
import utils.Fixture;
import utils.NoSuchLocatorException;
import utils.RandomData;

import java.io.IOException;

public class TestRegistrationForm extends Fixture{

    private static final Logger log = Logger.getLogger(Fixture.class);

    @Test
    public void emptyFieldsError() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        //registrationPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }

    @Test
    public void inputUserRegistrationEmail() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterEmail("telishuk.t@gmail.com");
        registrationPage.clickRegisterButton();
        //registrationPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }

    @Test
    public void inputUserRegistrationPassword() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterPassword("sdfgsdfgsdfhg");
        registrationPage.clickRegisterButton();
        //registrationPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }

    @Test
    public void testShowPasswordCheckBox() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterPassword("sdfgsdfgsdfhg");
        registrationPage.clickCheckBox();
    }

    /*
    * Bug
    * Login always must be consist of Latin chars
    */
    @Test
    public void testIncorrectLogin() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm("tolik.morozov@mail.ru", "КАРАМЕЛЬ",randomData.getRandomString() );
        registrationPage.clickRegisterButton();
        //registrationPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }

    @Test
    public void testIncorrectEmail() throws Exception, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm("карамель@mail.ru", "Karamelka", randomData.getRandomString());
        registrationPage.clickRegisterButton();
        //registrationPage.displayedMassageErrors();
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }

    @Test
    public void testButtonRegisterFaceBook() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        web.openPage(registerUrl);
        String parentHandle = driver.getWindowHandle();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickFbLogin();
        for (String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(parentHandle);
            }
        }
    }

    @Test
    public void testButtonRegisterTwitter() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        web.openPage(registerUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickTwitterLogin();
    }

    @Test
    public void testButtonRegisterGplus() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        web.openPage(registerUrl);
        String parentHandle = driver.getWindowHandle();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickGplusLogin();
        for (String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(parentHandle);
            }
        }
    }

}
