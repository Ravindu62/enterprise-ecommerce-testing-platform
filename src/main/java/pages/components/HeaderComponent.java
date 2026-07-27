package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;

public class HeaderComponent extends BasePage {

    // ==========================================================
    // Locators (Replace with actual Maho Commerce locators)
    // ==========================================================

    private final By logo = By.cssSelector("img[src='https://demo.mahocommerce.com/skin/frontend/base/default/images/logo.svg']");

    private final By homeLogo = By.cssSelector(".navbar-brand");

    private final By searchTextbox = By.id("search");

    private final By searchButton = By.id("search-button");

    private final By myAccountButton = By.id("my-account");

    private final By loginLink = By.linkText("Login");

    private final By registerLink = By.linkText("Register");

    private final By wishlistButton = By.id("wishlist");

    private final By shoppingCartButton = By.id("shopping-cart");

    private final By checkoutButton = By.id("checkout");

    private final By currencyDropdown = By.id("currency");

    private final By languageDropdown = By.id("language");

    // ==========================================================
    // Logo
    // ==========================================================

    public boolean isLogoDisplayed() {

        return isDisplayed(logo);

    }

    public void clickLogo() {

        click(homeLogo);

    }

    // ==========================================================
    // Search
    // ==========================================================

    public void enterSearchKeyword(String keyword) {

        sendKeys(searchTextbox, keyword);

    }

    public void clickSearchButton() {

        click(searchButton);

    }

    public void searchProduct(String keyword) {

        enterSearchKeyword(keyword);

        clickSearchButton();

    }

    // ==========================================================
    // My Account
    // ==========================================================

    public void openMyAccount() {

        click(myAccountButton);

    }

    public void clickLogin() {

        click(loginLink);

    }

    public void clickRegister() {

        click(registerLink);

    }

    // ==========================================================
    // Wishlist
    // ==========================================================

    public void openWishlist() {

        click(wishlistButton);

    }

    // ==========================================================
    // Shopping Cart
    // ==========================================================

    public void openShoppingCart() {

        click(shoppingCartButton);

    }

    // ==========================================================
    // Checkout
    // ==========================================================

    public void openCheckout() {

        click(checkoutButton);

    }

    // ==========================================================
    // Currency
    // ==========================================================

    public void changeCurrency(String currency) {

        selectDropdownByVisibleText(
                currencyDropdown,
                currency
        );

    }

    // ==========================================================
    // Language
    // ==========================================================

    public void changeLanguage(String language) {

        selectDropdownByVisibleText(
                languageDropdown,
                language
        );

    }

    // ==========================================================
    // Validations
    // ==========================================================

    public boolean isSearchBoxDisplayed() {

        return isDisplayed(searchTextbox);

    }

    public boolean isMyAccountDisplayed() {

        return isDisplayed(myAccountButton);

    }

    public boolean isWishlistDisplayed() {

        return isDisplayed(wishlistButton);

    }

    public boolean isShoppingCartDisplayed() {

        return isDisplayed(shoppingCartButton);

    }

}