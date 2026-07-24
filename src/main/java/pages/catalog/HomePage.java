package pages.catalog;

import org.openqa.selenium.By;
import pages.BasePage;

public class HomePage extends BasePage {

    // ============================
    // Locators
    // ============================

    private final By heroBanner =
            By.cssSelector(".hero-banner");

    private final By featuredProducts =
            By.cssSelector(".featured-products");

    private final By newArrivals =
            By.cssSelector(".new-products");

    // ============================
    // Validation
    // ============================

    public boolean isHomePageLoaded() {

        return isDisplayed(heroBanner);

    }

    public boolean isFeaturedProductsVisible() {

        return isDisplayed(featuredProducts);

    }

    public boolean isNewArrivalsVisible() {

        return isDisplayed(newArrivals);

    }

    public String getPageTitle() {

        return super.getPageTitle();

    }

}