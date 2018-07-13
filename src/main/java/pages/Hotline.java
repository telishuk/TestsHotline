package pages;

import org.openqa.selenium.WebDriver;


public class Hotline {
    public MainPage mainPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public ProductPage productPage;

    public Hotline(WebDriver driver) {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        productPage = new ProductPage(driver);

    }


}
