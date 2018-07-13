package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.NoSuchLocatorException;
import utils.WebDriverWrapper;
import utils.WebElementActions;

import java.io.IOException;

public abstract class Page {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private String PAGE;
    public WebDriverWrapper webDriverWrapper;
    public WebElementActions web;


    public Page(WebDriverWrapper dr, String page) {
        webDriverWrapper = dr;
        PAGE = page;
        web = new WebElementActions(dr);
    }

    public Page(WebDriverWrapper dr) {
        webDriverWrapper = dr;
        web = new WebElementActions(dr);
    }


    /*
     * Open Page in a browser
     */
    public boolean openPage(){
        try{
            log.info("Start open page.");
            webDriverWrapper.get(PAGE);
            webDriverWrapper.getCurrentUrl();
        } catch (Exception e){
            log.error("Error in open page!\n");
            return false;
        }
        log.info("Page open successful.");
        return true;
    }

    /*
     * Verification Page open correct. Check on pageLocator
     */
    public boolean isOpenPage(String checkLocator) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        try {
            if (web.isElementPresent(checkLocator)) {
                log.info("Page: Check is page open. " + checkLocator + " is present!");
                log.info(ClassNameUtil.getCurrentClassName() + ": Page is open.");
                return true;
            } else {
                log.error("Page: Error with check page!\n");
                Assert.fail("Incorrect swatch");
            }
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.printStackTrace();
        }
        return false;
    }

    /*
     * Get page title for verification correct switch between pages
     */
    public String getTitle() {
        return webDriverWrapper.getTitle();
    }

    public String getCurrentPageURL() {
        return webDriverWrapper.getCurrentUrl();
    }

    public void deleteAllCookies() {
        webDriverWrapper.manage().deleteAllCookies();
    }
}
