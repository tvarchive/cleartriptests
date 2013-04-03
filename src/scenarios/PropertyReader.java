package scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Sukeshk
 * Date: 03/04/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyReader {

    Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    private void loadAllProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public String readItem(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
