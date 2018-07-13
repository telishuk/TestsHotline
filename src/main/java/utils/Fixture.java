package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Hotline;

import java.util.concurrent.TimeUnit;

public class Fixture{

    public static Hotline hotline;
    public static WebDriver driver;
    public static WebElementActions web;
    private static final Logger log = Logger.getLogger(Fixture.class);


    @BeforeSuite
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        hotline = new Hotline(driver);
        log.info("<--------- Start tests --------->");
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        log.info("<--------- Finished tests --------->");
        log.info("<--------- Close browser --------->");
        driver.quit();
    }


}
