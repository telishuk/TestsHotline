package utils;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Fixture {
    protected static WebDriver driver;
    protected String mainUrl = "https://hotline.ua/";
    protected String registerUrl = "https://hotline.ua/register/";
    protected static WebElementActions web;
    protected RandomData randomData = new RandomData();
    private static final Logger log = Logger.getLogger(Fixture.class);

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        web = new WebElementActions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("<--------- Start tests --------->");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        log.info("<--------- Finished tests --------->");
        log.info("<--------- Close browser --------->");
        //driver.quit();
    }

}
