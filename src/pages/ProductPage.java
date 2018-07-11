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

    public void switchToMainPage() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickLink("LogoMainPage");
    }

    public void openProductMobile() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.moveToElementAndClick("ProductMenuMobile", "Mobile&Smartphone");

    }

    public void openProductAuto() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ProductMenuAuto");
    }

    public void selectManufacturer() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ManufacturerApple");
        log.info("Product is filtered manufacturer");
    }

    public void selectProductAuto() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException, InterruptedException {
        web.moveToElementAndClick("Tires&Disk", "TiresCar");
    }

    public void clickImgProductAuto() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ImageProductAuto");
    }

    public void clickImgProductMobile() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ImageProductMobile");
    }


    public void clickBuyProduct() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.doFocusToElement("ListShops");
        web.doFocusToElementAndClick("FocusSeller", "ButtonBuyProduct");
    }


    public boolean checkCorrectProductInBasket(){
        return false;
    }


    public void closeStageBorder() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        if (web.isElementPresent("StageBorder")){
            web.clickElement("StageBorderClose");
        }
    }

}
