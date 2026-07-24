package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private ConfigReader() {
    }


    public static void loadProperties() {

        properties = new Properties();

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/main/resources/config.properties"
                    );

            properties.load(file);

            file.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load configuration file",
                    e
            );
        }
    }


    public static String getProperty(String key) {

        if (properties == null) {

            loadProperties();

        }

        return properties.getProperty(key);
    }


    public static String getBrowser() {

        return getProperty("browser");

    }


    public static String getBaseUrl() {

        return getProperty("base.url");

    }


    public static int getExplicitWait() {

        return Integer.parseInt(
                getProperty("explicit.wait")
        );

    }


    public static boolean isHeadless() {

        return Boolean.parseBoolean(
                getProperty("headless")
        );

    }

}