package pages;

import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementActions;

import java.io.IOException;

public class RegistrationPage {
    WebElementActions web;

    public RegistrationPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void clickRegisterButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("RegistrationButton");
    }

    public void fillRegisterEmail(String email) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("RegistrationEmailField", email);
    }

    public void fillRegisterPassword(String password) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("RegistrationPasswordField", password);
    }

    public void clickCheckBox() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ShowPasswordCheckBox");
    }

    public void fillRegisterForm(String email, String login, String password) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("RegistrationEmailField",email);
        web.input("RegistrationLoginField",login );
        web.input("RegistrationPasswordField",password);
    }

    public void clickFbLogin() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("FaceBookLoginButton");
    }

    public void clickTwitterLogin() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("TwitterLoginButton");
    }

    public void clickGplusLogin() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("GplusLoginButton");
    }

    public void displayedMassageErrors() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        System.out.println(web.isElementPresent("RegistrationErrorsMassage"));
    }
}
