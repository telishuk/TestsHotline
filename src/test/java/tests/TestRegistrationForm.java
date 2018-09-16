package tests;

import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class TestRegistrationForm extends Fixture{

    private RandomData randomData = new RandomData();

    @Test
    public void emptyFieldsError() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.clickRegisterButton();
        assertTrue(hotline.web.isElementPresent("RegistrationErrorsMassage"), "Button was not click");
    }

    @Test
    public void inputUserRegistrationEmail() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.fillRegisterEmail("*******@gmail.com");
        hotline.registrationPage.clickRegisterButton();
        assertTrue(hotline.web.isElementPresent("RegistrationErrorsMassage"), "Button was not click");
    }

    @Test
    public void inputUserRegistrationPassword() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.fillRegisterPassword(randomData.getRandomString());
        hotline.registrationPage.clickRegisterButton();
        assertTrue(hotline.web.isElementPresent("RegistrationErrorsMassage"), "Button was not click");
    }

    @Test
    public void testShowPasswordCheckBox() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.fillRegisterPassword(randomData.getRandomString());
        hotline.registrationPage.clickCheckBox();
    }

    /*
    * Bug
    * Login always must be consist of Latin chars
    */
    @Test
    public void testIncorrectLogin() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.fillRegisterForm("tolik.morozov@mail.ru", "КАРАМЕЛЬ",randomData.getRandomString() );
        hotline.registrationPage.clickRegisterButton();
        assertTrue(hotline.web.isElementPresent("RegistrationErrorsMassage"), "Button was not click");
    }

    @Test
    public void testIncorrectEmail() throws Exception, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.fillRegisterForm("карамель@mail.ru", "Karamelka", randomData.getRandomString());
        hotline.registrationPage.clickRegisterButton();
        assertTrue(hotline.web.isElementPresent("RegistrationErrorsMassage"), "Button was not click");

    }

    @Test
    public void testButtonRegisterFaceBook() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        String parentHandle = driver.getWindowHandle();
        hotline.registrationPage.clickFbLogin();
        for (String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(parentHandle);
            }
        }
    }

    @Test
    public void testButtonRegisterTwitter() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.clickTwitterLogin();
    }

    @Test
    public void testButtonRegisterGplus() throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        hotline.registrationPage.openPage();
        hotline.registrationPage.clickGplusLogin();
    }

}
