package pages;

import utils.WebDriverWrapper;
import utils.WebElementActions;


public class Hotline {
    public WebElementActions web;
    public MainPage mainPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public ProductPage productPage;

    public Hotline(WebDriverWrapper driver) {
        web = new WebElementActions(driver);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        productPage = new ProductPage(driver);

    }


}
