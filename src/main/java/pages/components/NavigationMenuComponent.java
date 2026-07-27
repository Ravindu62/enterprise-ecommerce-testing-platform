package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavigationMenuComponent extends BasePage {

    // ==========================================================
    // Locators
    // ==========================================================

    private final By navigationMenu =
            By.id("header-nav");

    private final By menuItems =
            By.xpath("//ol[contains(@class,'nav-primary')]/li");

    private final By subMenuItems =
            By.cssSelector(".dropdown-menu .dropdown-item");

    // ==========================================================
    // Validation
    // ==========================================================

    public boolean isNavigationMenuDisplayed() {

        return isDisplayed(navigationMenu);

    }

    public int getMenuCount() {

        return driver.findElements(menuItems).size();

    }

    public List<String> getMenuNames() {

        List<String> menuNames = new ArrayList<>();

        List<WebElement> menus =
                driver.findElements(menuItems);

        for (WebElement menu : menus) {

            menuNames.add(
                    menu.getText().trim()
            );

        }

        return menuNames;

    }

    public boolean verifyMenuItemsDisplayed() {

        return getMenuCount() > 0;

    }

    // ==========================================================
    // Navigation
    // ==========================================================

    public void clickMenu(int index) {

        driver.findElements(menuItems)
                .get(index)
                .click();

    }

    public void clickMenu(String menuName) {

        List<WebElement> menus =
                driver.findElements(menuItems);

        for (WebElement menu : menus) {

            if (menu.getText()
                    .trim()
                    .equalsIgnoreCase(menuName)) {

                menu.click();

                return;

            }

        }

        throw new RuntimeException(
                "Menu not found : " + menuName
        );

    }

    // ==========================================================
    // Hover
    // ==========================================================

    public void hoverOverMenu(String menuName) {

        List<WebElement> menus =
                driver.findElements(menuItems);

        for (WebElement menu : menus) {

            if (menu.getText()
                    .trim()
                    .equalsIgnoreCase(menuName)) {

                actions.moveToElement(menu)
                        .perform();

                return;

            }

        }

        throw new RuntimeException(
                "Menu not found : " + menuName
        );

    }

    // ==========================================================
    // Sub Menu
    // ==========================================================

    public int getSubMenuCount() {

        return driver.findElements(subMenuItems)
                .size();

    }

    public List<String> getSubMenuNames() {

        List<String> subMenus =
                new ArrayList<>();

        List<WebElement> elements =
                driver.findElements(subMenuItems);

        for (WebElement element : elements) {

            subMenus.add(
                    element.getText().trim()
            );

        }

        return subMenus;

    }

    public void clickSubMenu(String submenuName) {

        List<WebElement> elements =
                driver.findElements(subMenuItems);

        for (WebElement element : elements) {

            if (element.getText()
                    .trim()
                    .equalsIgnoreCase(submenuName)) {

                element.click();

                return;

            }

        }

        throw new RuntimeException(
                "Sub Menu not found : "
                        + submenuName
        );

    }

    // ==========================================================
    // Verification
    // ==========================================================

    public boolean verifyNavigationLinks() {

        List<WebElement> menus =
                driver.findElements(menuItems);

        for (WebElement menu : menus) {

            String href =
                    menu.getAttribute("href");

            if (href == null ||
                    href.trim().isEmpty()) {

                return false;

            }

        }

        return true;

    }

}