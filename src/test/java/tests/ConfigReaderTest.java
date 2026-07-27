package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void verifyConfigReader() {

        String url = ConfigReader.getBaseUrl();

        System.out.println("URL: " + url);

        Assert.assertNotNull(url);
    }
}
