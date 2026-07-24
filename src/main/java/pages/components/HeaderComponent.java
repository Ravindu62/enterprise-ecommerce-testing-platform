package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;

public class HeaderComponent extends BasePage {

    private final By logo =
            By.cssSelector("img.logo");

    private final By searchTextbox =
            By.id("search");

    private final By searchButton =
            By.cssSelector("button.search");

    private final By accountButton =
            By.cssSelector(".account");

    private final By wishlistButton =
            By.cssSelector(".wishlist");

    private final By cartButton =
            By.cssSelector(".cart");

    public boolean isLogoDisplayed() {

        return isDisplayed(logo);

    }

    public void search(String keyword) {

        sendKeys(searchTextbox, keyword);

        click(searchButton);

    }

    public void openMyAccount() {

        click(accountButton);

    }

    public void openWishlist() {

        click(wishlistButton);

    }

    public void openCart() {

        click(cartButton);

    }

}