package tests.smoke;

import base.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.catalog.HomePage;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;
import pages.components.NavigationMenuComponent;

public class HomePageTest extends BaseTest {

    private HomePage homePage;
    private HeaderComponent header;
    private NavigationMenuComponent navigation;
    private FooterComponent footer;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage();
        header = new HeaderComponent();
        navigation = new NavigationMenuComponent();
        footer = new FooterComponent();
    }

    @Test(
            priority = 1,
            description = "TC-HOME-001 - Verify homepage loads successfully"
    )
    public void verifyHomepageLoadsSuccessfully() {

        Assert.assertTrue(
                homePage.isHomePageLoaded(),
                "Homepage failed to load."
        );

        Assert.assertTrue(
                homePage.isHeroSliderDisplayed(),
                "Hero slider is not displayed."
        );

        Assert.assertEquals(
                DriverManager.getDriver().getCurrentUrl(),
                "https://demo.mahocommerce.com/"
        );

    }

    @Test(
            priority = 2,
            description = "TC-HOME-002 - Verify company logo is displayed"
    )
    public void verifyCompanyLogoDisplayed() {

        Assert.assertTrue(
                header.isLogoDisplayed(),
                "Company logo is not displayed."
        );

    }

    @Test(
            priority = 3,
            description = "TC-HOME-003 - Verify navigation menu is displayed"
    )
    public void verifyNavigationMenuDisplayed() {

        Assert.assertTrue(
                navigation.isNavigationMenuDisplayed(),
                "Navigation menu is not displayed."
        );

        Assert.assertTrue(
                navigation.verifyMenuItemsDisplayed(),
                "One or more navigation menu items are missing."
        );

    }

    @Test(
            priority = 4,
            description = "TC-HOME-004 - Verify featured products are displayed"
    )
    public void verifyFeaturedProductsDisplayed() {

        Assert.assertTrue(
                homePage.isFeaturedProductsDisplayed(),
                "Featured products section is not displayed."
        );

        Assert.assertTrue(
                homePage.verifyFeaturedProducts(),
                "Featured products are incomplete."
        );

    }

    @Test(
            priority = 5,
            description = "TC-HOME-005 - Verify promotional banners are displayed"
    )
    public void verifyPromotionalBannersDisplayed() {

        Assert.assertTrue(
                homePage.isHeroSliderDisplayed(),
                "Promotional banner is not displayed."
        );

    }

    @Test(
            priority = 6,
            description = "TC-HOME-006 - Verify footer section is displayed"
    )
    public void verifyFooterSectionDisplayed() {

       // footer.scrollToFooter();

        Assert.assertTrue(
                footer.isFooterDisplayed(),
                "Footer is not displayed."
        );

        Assert.assertTrue(
                footer.verifyFooterLinks(),
                "Footer links are missing."
        );

    }

    @Test(
            priority = 7,
            description = "TC-HOME-007 - Verify navigation links redirect correctly"
    )
    public void verifyNavigationLinksRedirectCorrectly() {

        navigation.verifyNavigationLinks();

    }

    @Test(
            priority = 8,
            description = "TC-HOME-008 - Verify homepage responsiveness"
    )
    public void verifyHomepageResponsiveness() {

        DriverManager.getDriver().manage().window()
                .setSize(new Dimension(1920,1080));

        Assert.assertTrue(homePage.isHomePageLoaded());

        DriverManager.getDriver().manage().window()
                .setSize(new Dimension(768,1024));

        Assert.assertTrue(homePage.isHomePageLoaded());

        DriverManager.getDriver().manage().window()
                .setSize(new Dimension(390,844));

        Assert.assertTrue(homePage.isHomePageLoaded());

    }

}