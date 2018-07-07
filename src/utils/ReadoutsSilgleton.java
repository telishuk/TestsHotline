package utils;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ReadoutsSilgleton {
    private static volatile ReadoutsSilgleton instance;
    private static Properties properties = new Properties();
    private static volatile Map<String, String> extractData;


  /*  private ReadoutsSilgleton(){
        extractData = new HashMap<>();
        loadData();
        for (final  Map.Entry<Object, Object> entry: properties.entrySet()) {
            extractData.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static Properties loadData() {
        File file = new File(PropertyLoader)
    }
*/

    public static synchronized ReadoutsSilgleton getInstance() {
        if (instance == null) {
            //log.info("\t ReadoutsSilgleton getInstance() class A ");
            instance = new ReadoutsSilgleton();
            //log.info("\t Object - " + instance + " ");
            return instance;
        }
        //log.info("\t ReadoutsSilgleton getInstance() class B ");
        //log.info("\t Object - " + instance + " ");
        return instance;
    }

    public static By ui(String key) throws IOException, CloneNotSupportedException, IllegalAccessException, InstantiationException, NoSuchLocatorException {
        String[] partsOfLocator = extractData.get(key).split("\"");
        System.out.println("Before parsing:");
        System.out.println(partsOfLocator[0]);
        System.out.println(partsOfLocator[1]);

        String findLocator = partsOfLocator[0].substring(0, partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];

        System.out.println("After parsing:");
        System.out.println(partsOfLocator[0]);
        System.out.println(partsOfLocator[1]);
        System.out.println(findLocator);
        System.out.println(target);

        switch (findLocator){
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
                throw new NoSuchLocatorException("Locator not found");
        }

    }

}
