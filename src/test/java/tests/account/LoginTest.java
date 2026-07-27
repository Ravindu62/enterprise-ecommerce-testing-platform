package tests.account;

import base.BaseTest;
import driver.DriverManager;
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

        loginPage.login(
                "ravindu@gmail.com",
                "Ravindu@2001"
        );

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

        loginPage.login(
                "ravindu@gmail.com",
                "Invalid123"
        );

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

        loginPage.login(
                "invalid@test.com",
                "Ravindu@2001"
        );

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed()
        );

    }

    @Test(
            priority = 4,
            description = "TC-LOGIN-004 Verify email is mandatory"
    )
    public void verifyEmptyEmail() {

        loginPage.enterPassword("Test@1234");

        loginPage.clickSignIn();

        Assert.assertTrue(
                loginPage.isEmailValidationDisplayed()
        );

    }

    @Test(
            priority = 5,
            description = "TC-LOGIN-005 Verify password is mandatory"
    )
    public void verifyEmptyPassword() {

        loginPage.enterEmail("ravindu@gmail.com");

        loginPage.clickSignIn();

        Assert.assertTrue(
                loginPage.isPasswordValidationDisplayed()
        );

    }

    @Test(
            priority = 6,
            description = "TC-LOGIN-006 Verify empty login form"
    )
    public void verifyEmptyCredentials() {

        loginPage.clickSignIn();

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