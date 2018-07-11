package utils;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.TestLoginForm;
import tests.TestMainForm;
import tests.TestProduct;
import tests.TestRegistrationForm;

import java.util.concurrent.TimeUnit;


@RunWith(Suite.class)
@Suite.SuiteClasses({
       //TestMainForm.class,
        //TestLoginForm.class,
        //TestRegistrationForm.class,
        TestProduct.class
})

public class RunnerTests {

    public static WebDriver driver;
    private static final Logger log = Logger.getLogger(RunnerTests.class);


    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
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

