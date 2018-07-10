package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tests.TestLoginForm;
import utils.NoSuchLocatorException;
import utils.WebElementActions;

import java.io.IOException;

public class LoginPage {

    WebElementActions web;
    private static final Logger log = Logger.getLogger(TestLoginForm.class);

    public LoginPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void clickLoginButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ButtonLoginIn");
    }

    public void clearEmailField() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clearField("LoginEmailField");
    }

    public void clearPasswordField() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clearField("LoginPasswordField");
    }

    public void clearAllField() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clearField("LoginEmailField");
        web.clearField("LoginPasswordField");
    }

    public void fillLoginForm(String email, String password) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("LoginEmailField", email);
        web.input("LoginPasswordField", password);
    }

    public void clickRegisterLink() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("RegistrationLink");
    }

    public void fillLoginField(String email) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("LoginEmailField", email);
    }

    public void fillPasswordField(String password) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("LoginPasswordField", password);
    }

    public void clickForgotLink() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("ForgotPasswordLink");
    }

    public void clickTermOfUseLink() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("TermOFUseLink");
    }

    public void fillDataClickEnter(String email) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.inputAndClickEnter("LoginEmailField", email);
    }



    /*
     * Errors messages
     */

    public void displayedMassageErrors() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        System.out.println(web.isElementPresent("LoginErrorsMessages"));
    }

    public boolean checkEmptyPasswordError() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        String actualError = web.getElementsText("EmptyFieldError");
        String expectedError = "Извините, вы ввели неправильный пароль. Если вы забыли свой пароль, вы можете его";
        log.info("Displayed error is: " + actualError);
        return expectedError.equals(actualError);
    }

    public boolean checkEmptyEmailError() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        String actualError = web.getElementsText("EmptyFieldError");
        String expectedError = "Поле логин не может быть пустым";
        log.info("Displayed error is: " + actualError);
        return expectedError.equals(actualError);
    }

    public boolean checkFailEmailError() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        String actualError = web.getElementsText("LoginErrorsMassages");
        String expectedError = "Извините, пользователь с указанным e-mail не зарегистрирован, пожалуйста, убедитесь в правильности написания адреса";
        log.info("Displayed error is: " + actualError);
        return expectedError.equals(actualError);
    }




}
