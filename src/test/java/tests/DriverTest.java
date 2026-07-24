package tests;


import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.Test;


public class DriverTest {



    @Test
    public void launchBrowser(){


        DriverFactory.initializeDriver();


        DriverManager.getDriver()
                .get(
                        "https://demo.mahocommerce.com/"
                );


        System.out.println(
                DriverManager.getDriver()
                        .getTitle()
        );


        DriverFactory.quitDriver();


    }

}