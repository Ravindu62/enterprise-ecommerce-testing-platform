package pages.account;

import org.openqa.selenium.By;
import pages.BasePage;
import models.User;

public class RegisterPage extends BasePage {


    // ==========================================================
    // Locators
    // Replace these with actual Maho Commerce locators
    // ==========================================================


    private final By firstNameField =
            By.id("firstname");

    private final By middleNameField =
            By.id("middlename");

    private final By lastNameField =
            By.id("lastname");


    private final By emailField =
            By.id("email_address_register");


    private final By passwordField =
            By.id("password_register");


    private final By confirmPasswordField =
            By.id("confirmation_register");


    private final By createAccountButton =
            By.cssSelector("button[title='Register']");


    private final By firstNameError =
            By.id("firstname-error");


    private final By lastNameError =
            By.id("lastname-error");


    private final By emailError =
            By.id("email-error");


    private final By passwordError =
            By.id("password-error");


    private final By confirmPasswordError =
            By.id("password-confirmation-error");


    private final By existingEmailMessage =
            By.cssSelector(".message-error");


    private final By accountDashboard =
            By.cssSelector(".dashboard");


    private final By successMessage =
            By.cssSelector(".message-success");



    // ==========================================================
    // Actions
    // ==========================================================


    public void enterFirstName(String firstName){

        sendKeys(
                firstNameField,
                firstName
        );

    }

    public void enterMiddleName(String middleName){

        sendKeys(
                middleNameField,
                middleName
        );

    }


    public void enterLastName(String lastName){

        sendKeys(
                lastNameField,
                lastName
        );

    }



    public void enterEmail(String email){

        sendKeys(
                emailField,
                email
        );

    }



    public void enterPassword(String password){

        sendKeys(
                passwordField,
                password
        );

    }



    public void enterConfirmPassword(String password){

        sendKeys(
                confirmPasswordField,
                password
        );

    }



    public void clickCreateAccount(){

        click(
                createAccountButton
        );

    }



    public void registerUser(User user){

        enterFirstName(user.getFirstName());

        enterMiddleName(user.getMiddleName());

        enterLastName(user.getLastName());

        enterEmail(user.getEmail());

        enterPassword(user.getPassword());

        enterConfirmPassword(user.getConfirmPassword());

        clickCreateAccount();

    }




    // ==========================================================
    // Validation Methods
    // ==========================================================


    public boolean isFirstNameErrorDisplayed(){

        return isDisplayed(firstNameError);

    }



    public boolean isLastNameErrorDisplayed(){

        return isDisplayed(lastNameError);

    }



    public boolean isEmailErrorDisplayed(){

        return isDisplayed(emailError);

    }



    public boolean isPasswordErrorDisplayed(){

        return isDisplayed(passwordError);

    }



    public boolean isConfirmPasswordErrorDisplayed(){

        return isDisplayed(confirmPasswordError);

    }



    public boolean isExistingEmailMessageDisplayed(){

        return isDisplayed(existingEmailMessage);

    }



    public boolean isAccountCreated(){

        return isDisplayed(accountDashboard);

    }



    public boolean isSuccessMessageDisplayed(){

        return isDisplayed(successMessage);

    }



}