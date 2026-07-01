package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static ConfigReader instance;

    private final Properties properties;

    private ConfigReader() {

        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {

                throw new RuntimeException("config.properties not found.");

            }

            properties.load(input);

        }

        catch (IOException e) {

            throw new RuntimeException("Unable to load config.properties", e);

        }

    }

    public static ConfigReader getInstance() {

        if (instance == null) {

            instance = new ConfigReader();

        }

        return instance;

    }

    public String getProperty(String key) {

        return properties.getProperty(key);

    }

    public int getIntProperty(String key) {

        return Integer.parseInt(properties.getProperty(key));

    }

}