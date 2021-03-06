package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadoutsSilgleton {
    private static volatile ReadoutsSilgleton instance;
    private static Properties properties = new Properties();
    private static volatile Map<String, String> extractData;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /*private ReadoutsSilgleton(){
        extractData = new HashMap<>();
        loadData();
        for (final  Map.Entry<Object, Object> entry: properties.entrySet()) {
            extractData.put((String) entry.getKey(), (String) entry.getValue());
        }
        log.info("\t UIMappingSingleton creation time - " + (System.nanoTime() - start) + " (nanoseconds)");
    }
    */


    public static synchronized ReadoutsSilgleton getInstance() {
        if (instance == null) {
            instance = new ReadoutsSilgleton();
            return instance;
        }
        return instance;
    }

    public static By ui(String key) throws IOException, CloneNotSupportedException, IllegalAccessException, InstantiationException, NoSuchLocatorException {
        String[] partsOfLocator = extractData.get(key).split("\"");
        String findLocator = partsOfLocator[0].substring(0, partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];

        if (findLocator.equals("id")) {
            return By.id(target);
        } else if (findLocator.equals("xpath")) {
            return By.xpath(target);
        } else if (findLocator.equals("name")) {
            return By.name(target);
        } else if (findLocator.equals("class")) {
            return By.className(target);
        } else if (findLocator.equals("cssSelector")) {
            return By.cssSelector(target);
        } else {
            throw new NoSuchLocatorException("Locator not found");
        }

    }

}
