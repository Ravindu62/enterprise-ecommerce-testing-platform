package tests;


import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.catalog.HomePage;
import pages.components.HeaderComponent;


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

    @Test
    public void verifyHomePageLoads() {

        HomePage homePage = new HomePage();

        HeaderComponent header = new HeaderComponent();

        Assert.assertTrue(homePage.isHomePageLoaded());

        Assert.assertTrue(header.isLogoDisplayed());

    }

}