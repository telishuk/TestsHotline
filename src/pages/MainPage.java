package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementActions;

import java.io.IOException;

public class MainPage {
    WebElementActions web;
    private static final Logger log = Logger.getLogger(ProductPage.class);

    public MainPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void clickMainLogo() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("LogoMainPage");
    }

    public void clickLoginButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ButtonLogin");
    }


    /*
     * Locate request menu and choice of action
     */
    public void clickCloseLocationMenu() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.closeLocationMenu("CloseLocationMenu");
    }

    public void clickAgreeLocation() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.agreeConfirmLocation("ButtonAgreeLocation");
    }

    public void clickCity() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButtonCity("ButtonCity");
    }

    public void selectAnotherCity() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButtonCity("CityOdessa");
    }


    /*
     * Add or change some data in Customer form
     */
    public void clickCustomerDataForm() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("CustomerMenu");
        web.clickLink("CustomerDataLink");
    }

    public void fillCustomerData(String name, String lastName) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.input("CustomerFirstNameField", name);
        web.input("CustomerLastNameField", lastName);
    }

    public void fillCustomerBirthDay(String day, String month, String year) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.selectFromList("BirthdayDay", day);
        web.selectFromList("BirthdayMonth", month);
        web.selectFromList("BirthdayYear", year);
    }

    public void clickButtonSaveChanges() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("ButtonSaveChanges");
    }

    public void clickRadioButtonMale() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("RadioButtonMale");
    }

    public void clickRadioButtonFeMale() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("RadioButtonFemale");
    }


    /*
     * Enter to customer menu and click Customer data
     */
    public void clickLogoutButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("CustomerMenu");
        web.clickButton("ButtonLogout");
    }


    public void goToTheBasket() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("GoToBasket");
    }
    public void checkBasket() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ButtonBasket");
        if (web.isElementPresent("BasketForm")){
            log.info("Basket is empty");
        }
    }

    public void closeBasket() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("BasketFormClose");
    }




}
