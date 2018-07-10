package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.RunnerTests;
import utils.WebElementActions;

import java.io.IOException;

public class ProductPage {

    WebElementActions web;
    private static final Logger log = Logger.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void openProductMobile() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.moveToElementAndClick("ProductMenuMobile", "Mobile&Smartphone");

    }

    public void selectManufacturer() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ManufacturerApple");
        log.info("Product is filtered manufacturer");

    }

    public void selectFilteredProduct() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ChoosePhone");
    }

    public void addToBasket() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("AddToBasketButton");
        //log.info("Add to basket button is clicked");
    }

}
