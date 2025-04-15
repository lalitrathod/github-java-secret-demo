import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value != null && value.matches("\\$\\{.+\\}")) {
            String envKey = value.substring(2, value.length() - 1);
            return System.getenv(envKey);
        }
        return value;
    }
}
