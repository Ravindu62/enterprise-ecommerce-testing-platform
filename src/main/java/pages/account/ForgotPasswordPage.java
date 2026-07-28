package pages.account;

import org.openqa.selenium.By;
import pages.BasePage;

public class ForgotPasswordPage extends BasePage {

    // ==========================================================
    // Locators
    // Replace these with actual Maho Commerce locators
    // ==========================================================

    private final By emailField =
            By.id("email_address");

    private final By resetPasswordButton =
            By.xpath("//button[contains(.,'Reset My Password')]");

    private final By successMessage =
            By.cssSelector(".message-success");

    private final By errorMessage =
            By.cssSelector(".message-error");

    private final By emailValidationMessage =
            By.id("email_address-error");

    // ==========================================================
    // Actions
    // ==========================================================

    public void enterEmail(String email) {

        sendKeys(emailField, email);

    }

    public void clickResetPassword() {

        click(resetPasswordButton);

    }

    public void requestPasswordReset(String email) {

        enterEmail(email);

        clickResetPassword();

    }

    // ==========================================================
    // Validations
    // ==========================================================

    public boolean isSuccessMessageDisplayed() {

        return isDisplayed(successMessage);

    }

    public boolean isErrorMessageDisplayed() {

        return isDisplayed(errorMessage);

    }

    public boolean isEmailValidationDisplayed() {

        return isDisplayed(emailValidationMessage);

    }

    public String getSuccessMessage() {

        return getText(successMessage);

    }

    public String getErrorMessage() {

        return getText(errorMessage);

    }

}