package automation.util;

import automation.io.exception.UnableToReadException;
import automation.io.impl.file.PropertyFileReader;

public class PropertyUtil {
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "\\src\\config.properties";
    private static final PropertyFileReader READER = new PropertyFileReader(CONFIG_FILE_PATH);
    static {
        try {
            READER.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Couldn't read config io! %s", CONFIG_FILE_PATH));
        }
    }

    public static String getValueByKey(String key) {
        return READER.getPropertyValue(key);
    }
}
