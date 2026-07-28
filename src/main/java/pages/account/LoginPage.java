package pages.account;

import models.User;
import org.openqa.selenium.By;
import pages.BasePage;

public class LoginPage extends BasePage {

    // ==========================================================
    // Locators
    // Replace with actual Maho Commerce locators
    // ==========================================================

    private final By emailField =
            By.id("email");

    private final By passwordField =
            By.id("pass");

    private final By signInButton =
            By.id("send2");

    private final By forgotPasswordLink =
            By.cssSelector("#show-forgot-password");

    private final By createAccountLink =
            By.cssSelector("label[for='tab-register']");

    private final By dashboard =
            By.id("main-content");

    private final By loginErrorMessage =
            By.cssSelector("li[class='error-msg'] ul li span");

    private final By emailValidation =
            By.id("advice-required-entry-email");

    private final By passwordValidation =
            By.id("advice-required-entry-pass");

    private final By requiredAlertMessage =
            By.cssSelector(".error-msg");

    private final By forgotPasswordDialogBox =
            By.id("forgot-password-dialog");

    private final By registerButton =
            By.cssSelector("button[title='Register']");
    // ==========================================================
    // Actions
    // ==========================================================

    public void enterEmail(String email) {

        sendKeys(emailField, email);

    }

    public void enterPassword(String password) {

        sendKeys(passwordField, password);

    }

    public void clickSignIn() {

        click(signInButton);

    }

    public void login(User user) {

        enterEmail(user.getEmail());

        enterPassword(user.getPassword());

        clickSignIn();

    }

    public void clickForgotPassword() {

        click(forgotPasswordLink);

    }

    public void clickCreateAccount() {

        click(createAccountLink);

    }

    // ==========================================================
    // Validations
    // ==========================================================

    public boolean isDashboardDisplayed() {

        return isDisplayed(dashboard);

    }

    public boolean isLoginErrorDisplayed() {

        return isDisplayed(loginErrorMessage);

    }

    public boolean isEmailValidationDisplayed() {

        return isDisplayed(emailValidation);

    }

    public boolean isPasswordValidationDisplayed() {

        return isDisplayed(passwordValidation);

    }

    public boolean isRetrieveYourPasswordBoxDisplayed() {
        return isDisplayed(forgotPasswordDialogBox);
    }

    public boolean isRegisterButtonDisplayed() {
        return isDisplayed(registerButton);
    }

    public boolean isRequiredAlertMessageDisplayed() {
        return isDisplayed(requiredAlertMessage);
    }
}