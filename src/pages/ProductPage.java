package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

public class ProductPage {
    WebElementActions web;

    public ProductPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }


}
