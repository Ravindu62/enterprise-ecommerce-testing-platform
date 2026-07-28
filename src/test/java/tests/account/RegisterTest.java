package tests.account;


import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.RegisterPage;
import driver.DriverManager;
import factories.UserFactory;


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


        User user = UserFactory.createValidUser();

        registerPage.registerUser(user);

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

        User user = UserFactory.withoutFirstName();

        registerPage.registerUser(user);


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

        User user = UserFactory.withoutLastName();

        registerPage.registerUser(user);


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

        User user = UserFactory.createExistingUser();

        registerPage.registerUser(user);


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


        User user = UserFactory.createInvalidEmailUser();

        registerPage.registerUser(user);


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

        User user = UserFactory.createWeakPasswordUser();

        registerPage.registerUser(user);

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


        User user = UserFactory.createPasswordMismatchUser();

        registerPage.registerUser(user);


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


        User user = UserFactory.createEmptyUser();

        registerPage.registerUser(user);


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


        User user = UserFactory.createValidUser();

        registerPage.registerUser(user);


        Assert.assertTrue(
                registerPage.isAccountCreated(),
                "Account dashboard not displayed"
        );


    }

}