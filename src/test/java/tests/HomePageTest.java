package tests;


import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {



    @Test
    public void verifyHomePageTitle(){


        String title =
                DriverManager.getDriver()
                        .getTitle();


        System.out.println(
                "Page Title : "
                        + title
        );


        Assert.assertNotNull(title);


    }

}