package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.MainPage;
import utils.Fixture;
import utils.NoSuchLocatorException;
import utils.RandomData;


public class TestProduct extends Fixture {
    private RandomData randomData = new RandomData();
    @Test
    public void test() throws Exception, NoSuchLocatorException {
        web.openPage(mainUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCloseLocationMenu();
        driver.findElement(By.xpath(".//*[@class='city-link']")).click();
        driver.findElement(By.xpath(".//*[@data-id='458']")).click();

    }

    @Test
    public void test1() throws Exception, NoSuchLocatorException {
        System.out.println(randomData.getRandomString());

    }



}
