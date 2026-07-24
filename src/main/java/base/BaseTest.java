package base;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void setUp(){


        // Initialize browser
        DriverFactory.initializeDriver();


        // Navigate to application
        DriverManager.getDriver()
                .get(
                        ConfigReader.getBaseUrl()
                );

    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){


        // Close browser
        DriverFactory.quitDriver();

    }


}