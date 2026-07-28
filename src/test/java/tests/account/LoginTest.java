package tests.account;

import base.BaseTest;
import driver.DriverManager;
import factories.UserFactory;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.account.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void navigateToLoginPage() {

        DriverManager.getDriver().get(
                "https://demo.mahocommerce.com/customer/account/login/"
        );

        loginPage = new LoginPage();

    }

    @Test(
            priority = 1,
            description = "TC-LOGIN-001 Verify login with valid credentials"
    )
    public void verifyValidLogin() {

        User user = UserFactory.createExistingUser();

        loginPage.login(user);

        Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Dashboard was not displayed."
        );

    }

    @Test(
            priority = 2,
            description = "TC-LOGIN-002 Verify login with invalid password"
    )
    public void verifyInvalidPassword() {

        User user = UserFactory.createPasswordMismatchUser();

        loginPage.login(user);

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed(),
                "Expected login error was not displayed."
        );

    }

    @Test(
            priority = 3,
            description = "TC-LOGIN-003 Verify login with invalid email"
    )
    public void verifyInvalidEmail() {

        User user = UserFactory.createInvalidEmail();

        loginPage.login(user);

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed()
        );

    }

    @Test(
            priority = 4,
            description = "TC-LOGIN-004 Verify email is mandatory"
    )
    public void verifyEmptyEmail() {

        User user = UserFactory.emptyEmailUser();

        loginPage.login(user);

        Assert.assertTrue(
                loginPage.isEmailValidationDisplayed()
        );

    }

    @Test(
            priority = 5,
            description = "TC-LOGIN-005 Verify password is mandatory"
    )
    public void verifyEmptyPassword() {

        User user = UserFactory.emptyPasswordUser();

        loginPage.login(user);

        Assert.assertTrue(loginPage.isRequiredAlertMessageDisplayed());


    }

    @Test(
            priority = 6,
            description = "TC-LOGIN-006 Verify empty login form"
    )
    public void verifyEmptyCredentials() {

        User user = UserFactory.createEmptyUser();

        loginPage.login(user);

        Assert.assertTrue(loginPage.isEmailValidationDisplayed());

        Assert.assertTrue(loginPage.isPasswordValidationDisplayed());

    }

    @Test(
            priority = 7,
            description = "TC-LOGIN-007 Verify Forgot Password navigation"
    )
    public void verifyForgotPasswordNavigation() {

        loginPage.clickForgotPassword();

        Assert.assertTrue(loginPage.isRetrieveYourPasswordBoxDisplayed());

    }

    @Test(
            priority = 8,
            description = "TC-LOGIN-008 Verify Create Account navigation"
    )
    public void verifyCreateAccountNavigation() {

        loginPage.clickCreateAccount();

        Assert.assertTrue(loginPage.isRegisterButtonDisplayed());

    }

}