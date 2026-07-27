package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    // ==========================================================
    // Locators
    // ==========================================================

    private final By pageContainer = By.cssSelector("main[role='main']");

    private final By heroBanner = By.cssSelector(".slideshow");

    private final By navigationMenu = By.cssSelector(".nav-primary");

    private final By featuredProductsSection = By.cssSelector(".widget.widget-new-products");

    private final By featuredProducts = By.cssSelector(".products-grid.products-grid--max-5-col-widget");

    private final By featuredProductImage = By.cssSelector(".product-image");

    private final By featuredProductName = By.cssSelector(".product-name");

    private final By featuredProductPrice = By.cssSelector(".price");

    private final By promotionalBanners = By.cssSelector(".promotion-banner");

    private final By footer = By.tagName("footer");

    private final By categoryLinks = By.cssSelector(".category-link");

    // ==========================================================
    // Page Validation
    // ==========================================================

    public boolean isHomePageLoaded() {
        return isDisplayed(pageContainer);
    }

    public boolean isHeroSliderDisplayed() {
        return isDisplayed(heroBanner);
    }

    public boolean isNavigationMenuDisplayed() {
        return isDisplayed(navigationMenu);
    }

    public boolean isFeaturedProductsDisplayed() {
        return isDisplayed(featuredProductsSection);
    }

    public boolean isFooterDisplayed() {
        scrollToBottom();
        return isDisplayed(footer);
    }

    // ==========================================================
    // Featured Products
    // ==========================================================

    public int getFeaturedProductCount() {
        return driver.findElements(featuredProducts).size();
    }

    public boolean verifyFeaturedProducts() {

        List<WebElement> products =
                driver.findElements(featuredProducts);

        if (products.isEmpty()) {
            return false;
        }

        for (WebElement product : products) {

            if (product.findElements(featuredProductImage).isEmpty()) {
                return false;
            }

            if (product.findElements(featuredProductName).isEmpty()) {
                return false;
            }

            if (product.findElements(featuredProductPrice).isEmpty()) {
                return false;
            }

        }

        return true;
    }

    public void openFeaturedProduct(int index) {

        List<WebElement> products =
                driver.findElements(featuredProducts);

        products.get(index).click();
    }

    // ==========================================================
    // Promotional Banners
    // ==========================================================

    public int getPromotionalBannerCount() {

        return driver.findElements(promotionalBanners).size();

    }

    public boolean verifyPromotionalBannersDisplayed() {

        return getPromotionalBannerCount() > 0;

    }

    // ==========================================================
    // Categories
    // ==========================================================

    public int getCategoryCount() {

        return driver.findElements(categoryLinks).size();

    }

    public void clickCategory(int index) {

        driver.findElements(categoryLinks)
                .get(index)
                .click();

    }

    public void clickCategory(String categoryName) {

        List<WebElement> categories =
                driver.findElements(categoryLinks);

        for (WebElement category : categories) {

            if (category.getText()
                    .trim()
                    .equalsIgnoreCase(categoryName)) {

                category.click();

                break;
            }
        }

    }

    // ==========================================================
    // Navigation
    // ==========================================================

    public void refreshHomePage() {

        refreshPage();

    }

    public String getCurrentPageTitle() {

        return getPageTitle();

    }

    public String getCurrentUrl() {

        return super.getCurrentUrl();

    }

}