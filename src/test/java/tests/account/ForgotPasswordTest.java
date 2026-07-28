package tests.account;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.account.ForgotPasswordPage;
import pages.account.LoginPage;

public class ForgotPasswordTest extends BaseTest {

    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        DriverManager.getDriver().get(
                "https://demo.mahocommerce.com/customer/account/login/"
        );

        loginPage = new LoginPage();
        forgotPasswordPage = new ForgotPasswordPage();

    }

    @Test(
            priority = 1,
            description = "TC-FP-001 Verify navigation to Forgot Password page"
    )
    public void verifyNavigationToForgotPasswordPage() {

        loginPage.clickForgotPassword();

        Assert.assertTrue(loginPage.isRetrieveYourPasswordBoxDisplayed());

    }

    @Test(
            priority = 2,
            description = "TC-FP-002 Verify password reset using registered email"
    )
    public void verifyPasswordResetUsingRegisteredEmail() {

        loginPage.clickForgotPassword();

        forgotPasswordPage.requestPasswordReset(
                "ravindu@gmail.com"
        );

        Assert.assertTrue(
                forgotPasswordPage.isSuccessMessageDisplayed(),
                "Success message was not displayed."
        );

    }

    @Test(
            priority = 3,
            description = "TC-FP-003 Verify password reset using unregistered email"
    )
    public void verifyPasswordResetUsingUnregisteredEmail() {

        loginPage.clickForgotPassword();

        forgotPasswordPage.requestPasswordReset(
                "unknown.user@test.com"
        );

        /*
         * Some applications intentionally show the same
         * success message for both registered and
         * unregistered email addresses.
         *
         * Replace this assertion according to the
         * application's actual behavior.
         */

        Assert.assertTrue(

                forgotPasswordPage.isSuccessMessageDisplayed()
                        || forgotPasswordPage.isErrorMessageDisplayed(),

                "Expected response was not displayed."

        );

    }

    @Test(
            priority = 4,
            description = "TC-FP-004 Verify invalid email format validation"
    )
    public void verifyInvalidEmailFormat() {

        loginPage.clickForgotPassword();

        forgotPasswordPage.requestPasswordReset(
                "invalid-email"
        );

        Assert.assertTrue(
                forgotPasswordPage.isEmailValidationDisplayed(),
                "Email validation message was not displayed."
        );

    }

    @Test(
            priority = 5,
            description = "TC-FP-005 Verify password reset confirmation message"
    )
    public void verifyPasswordResetConfirmationMessage() {

        loginPage.clickForgotPassword();

        forgotPasswordPage.requestPasswordReset(
                "john.doe@test.com"
        );

        Assert.assertTrue(
                forgotPasswordPage.isSuccessMessageDisplayed(),
                "Confirmation message was not displayed."
        );

        Assert.assertFalse(
                forgotPasswordPage.getSuccessMessage().trim().isEmpty(),
                "Confirmation message text is empty."
        );

    }

}