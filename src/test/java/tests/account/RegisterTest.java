package tests.account;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.RegisterPage;
import driver.DriverManager;


public class RegisterTest extends BaseTest {


    private RegisterPage registerPage;



    private void openRegistrationPage(){

        registerPage = new RegisterPage();

        // Replace with actual registration URL
        DriverManager.getDriver().get(
                "https://demo.mahocommerce.com/customer/account/create/"
        );

    }



    @Test(
            description =
                    "TC-REG-001 Verify user registration with valid details"
    )
    public void verifyRegistrationWithValidDetails(){


        openRegistrationPage();


        registerPage.registerUser(
                "Chandima",
                "Pasan",
                "Nanayakkara",
                "chandima@gmail.com",
                "Chandima@2001"
        );


        Assert.assertTrue(
                registerPage.isAccountCreated(),
                "Customer account was not created"
        );


    }



    @Test(
            description =
                    "TC-REG-002 Verify First Name is mandatory"
    )
    public void verifyFirstNameMandatory(){


        openRegistrationPage();


        registerPage.enterLastName("Doe");

        registerPage.enterEmail(
                "john@test.com"
        );

        registerPage.enterPassword(
                "Test@1234"
        );

        registerPage.enterConfirmPassword(
                "Test@1234"
        );


        registerPage.clickCreateAccount();


        Assert.assertTrue(
                registerPage.isFirstNameErrorDisplayed(),
                "First name validation message not displayed"
        );


    }



    @Test(
            description =
                    "TC-REG-003 Verify Last Name is mandatory"
    )
    public void verifyLastNameMandatory(){


        openRegistrationPage();


        registerPage.enterFirstName(
                "John"
        );

        registerPage.enterEmail(
                "john@test.com"
        );

        registerPage.enterPassword(
                "Test@1234"
        );

        registerPage.enterConfirmPassword(
                "Test@1234"
        );


        registerPage.clickCreateAccount();


        Assert.assertTrue(
                registerPage.isLastNameErrorDisplayed(),
                "Last name validation message not displayed"
        );


    }



    @Test(
            description =
                    "TC-REG-004 Verify registration with existing email"
    )
    public void verifyExistingEmailRegistration(){


        openRegistrationPage();


        registerPage.registerUser(
                "Existing",
                "User",
                "Maho",
                "test@gmail.com",
                "Test@1234"
        );


        Assert.assertTrue(
                registerPage.isExistingEmailMessageDisplayed(),
                "Existing email error not displayed"
        );


    }




    @Test(
            description =
                    "TC-REG-005 Verify email format validation"
    )
    public void verifyInvalidEmailValidation(){


        openRegistrationPage();


        registerPage.registerUser(
                "John",
                "Doe",
                "User",
                "invalid-email",
                "Test@1234"
        );


        Assert.assertTrue(
                registerPage.isEmailErrorDisplayed(),
                "Email validation error not displayed"
        );


    }




    @Test(
            description =
                    "TC-REG-006 Verify password validation rules"
    )
    public void verifyPasswordValidation(){


        openRegistrationPage();


        registerPage.enterFirstName(
                "John"
        );

        registerPage.enterLastName(
                "Doe"
        );

        registerPage.enterEmail(
                "john@test.com"
        );

        registerPage.enterPassword(
                "123"
        );

        registerPage.enterConfirmPassword(
                "123"
        );


        registerPage.clickCreateAccount();


        Assert.assertTrue(
                registerPage.isPasswordErrorDisplayed(),
                "Password validation message not displayed"
        );


    }





    @Test(
            description =
                    "TC-REG-007 Verify password confirmation mismatch"
    )
    public void verifyPasswordMismatch(){


        openRegistrationPage();


        registerPage.enterFirstName(
                "John"
        );

        registerPage.enterLastName(
                "Doe"
        );

        registerPage.enterEmail(
                "john@test.com"
        );

        registerPage.enterPassword(
                "Test@1234"
        );

        registerPage.enterConfirmPassword(
                "Test@5678"
        );


        registerPage.clickCreateAccount();


        Assert.assertTrue(
                registerPage.isConfirmPasswordErrorDisplayed(),
                "Password mismatch message not displayed"
        );


    }





    @Test(
            description =
                    "TC-REG-008 Verify mandatory field validations"
    )
    public void verifyAllMandatoryFieldValidation(){


        openRegistrationPage();


        registerPage.clickCreateAccount();


        Assert.assertTrue(
                registerPage.isFirstNameErrorDisplayed()
        );


        Assert.assertTrue(
                registerPage.isLastNameErrorDisplayed()
        );


        Assert.assertTrue(
                registerPage.isEmailErrorDisplayed()
        );


        Assert.assertTrue(
                registerPage.isPasswordErrorDisplayed()
        );


    }




    @Test(
            description =
                    "TC-REG-009 Verify successful customer account creation"
    )
    public void verifySuccessfulAccountCreation(){


        openRegistrationPage();


        registerPage.registerUser(
                "Automation",
                "Tester",
                "Maho",
                "automation"
                        + System.currentTimeMillis()
                        + "@test.com",
                "Test@1234"
        );


        Assert.assertTrue(
                registerPage.isAccountCreated(),
                "Account dashboard not displayed"
        );


    }

}