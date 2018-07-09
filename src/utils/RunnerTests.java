package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.TestLoginForm;
import tests.TestMainForm;
import tests.TestRegistrationForm;

import java.util.concurrent.TimeUnit;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMainForm.class,
        TestLoginForm.class,
        TestRegistrationForm.class
})
public class RunnerTests extends Fixture{

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
        driver.quit();
    }



}

