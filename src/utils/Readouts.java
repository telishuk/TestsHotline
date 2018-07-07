package utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Readouts {
    public static String uiMappingFile = "src/UIMapping.Properties";
    //private static final Logger log = Logger.getLogger(Readouts.class);

    /*
     *  Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName);
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return(p.getProperty(key));
    }


    /*
     *  Return By class with finding method and target for WebElement from UI mapping file
     */
    public static By ui(String key) throws IOException, CloneNotSupportedException, IllegalAccessException, InstantiationException, NoSuchLocatorException {
        // Get WebElement's locator from UI mapping file and divide it to finding method and target
        String[] partsOfLocator = getValueFromFile(key, uiMappingFile).split("\"");
        //System.out.println("<--------- Before parsing: --------->");

        String findMethod = partsOfLocator[0].substring(0, partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];
        /*
        System.out.println("<--------- After parsing: --------->");

        System.out.println(partsOfLocator[0]);
        System.out.println(partsOfLocator[1]);
        System.out.println(findMethod);
        System.out.println(target);
        */

        switch (findMethod){
            case "id":
                return By.id(target);
            case "xpath":
                return By.xpath(target);
            case "name":
                return By.name(target);
            case "class":
                return By.className(target);
            case "cssSelector":
                return By.cssSelector(target);
            default:
                throw new NoSuchLocatorException("<--------- Locator not found --------->");
        }

    }

}
