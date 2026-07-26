package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class FooterComponent extends BasePage {

    // ==========================================================
    // Locators
    // ==========================================================

    private final By footer =
            By.tagName("footer");

    private final By footerLinks =
            By.cssSelector("footer a");

    private final By informationSection =
            By.id("footer-information");

    private final By customerServiceSection =
            By.id("footer-customer-service");

    private final By extrasSection =
            By.id("footer-extras");

    private final By accountSection =
            By.id("footer-account");

    private final By contactInformation =
            By.cssSelector(".footer-contact");

    private final By newsletterEmail =
            By.id("newsletter-email");

    private final By subscribeButton =
            By.id("newsletter-subscribe");

    private final By copyrightText =
            By.cssSelector(".copyright");

    // ==========================================================
    // Validation
    // ==========================================================

    public boolean isFooterDisplayed() {

        scrollToBottom();

        return isDisplayed(footer);

    }

    public boolean isInformationSectionDisplayed() {

        return isDisplayed(informationSection);

    }

    public boolean isCustomerServiceSectionDisplayed() {

        return isDisplayed(customerServiceSection);

    }

    public boolean isExtrasSectionDisplayed() {

        return isDisplayed(extrasSection);

    }

    public boolean isAccountSectionDisplayed() {

        return isDisplayed(accountSection);

    }

    public boolean isContactInformationDisplayed() {

        return isDisplayed(contactInformation);

    }

    public boolean isCopyrightDisplayed() {

        return isDisplayed(copyrightText);

    }

    // ==========================================================
    // Footer Links
    // ==========================================================

    public int getFooterLinkCount() {

        return driver.findElements(footerLinks).size();

    }

    public List<String> getFooterLinkNames() {

        List<String> names = new ArrayList<>();

        List<WebElement> links =
                driver.findElements(footerLinks);

        for (WebElement link : links) {

            names.add(
                    link.getText().trim()
            );

        }

        return names;

    }

    public boolean verifyFooterLinks() {

        return getFooterLinkCount() > 0;

    }

    public void clickFooterLink(String linkName) {

        List<WebElement> links =
                driver.findElements(footerLinks);

        for (WebElement link : links) {

            if (link.getText()
                    .trim()
                    .equalsIgnoreCase(linkName)) {

                scrollToElement(footer);

                link.click();

                return;

            }

        }

        throw new RuntimeException(
                "Footer link not found : " + linkName
        );

    }

    // ==========================================================
    // Newsletter
    // ==========================================================

    public void enterNewsletterEmail(String email) {

        sendKeys(newsletterEmail, email);

    }

    public void clickSubscribe() {

        click(subscribeButton);

    }

    public void subscribeToNewsletter(String email) {

        enterNewsletterEmail(email);

        clickSubscribe();

    }

    // ==========================================================
    // Copyright
    // ==========================================================

    public String getCopyrightText() {

        return getText(copyrightText);

    }

}