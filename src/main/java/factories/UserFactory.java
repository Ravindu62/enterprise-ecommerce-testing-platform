package factories;

import com.github.javafaker.Faker;
import models.User;

public class UserFactory {

    private static final Faker faker = new Faker();

    private UserFactory() {
    }

    public static User createValidUser() {

        String password = "Test@1234";

        return new User(

                faker.name().firstName(),

                faker.name().lastName(),

                faker.name().lastName(),

                faker.internet().emailAddress(),

                password,

                password

        );

    }

    public static User createExistingUser() {

        return new User(

                "Ravindu",

                "Pasan",

                "Nanayakkara",

                "ravindu@gmail.com",

                "Ravindu@2001",

                "Ravindu@2001"

        );

    }

    public static User createInvalidEmailUser() {

        return new User(

                "Chandima",

                "Suboda",

                "Nanayakkara",

                "invalid-email",

                "Test@1234",

                "Test@1234"

        );

    }

    public static User createWeakPasswordUser() {

        return new User(

                "John",

                "Ebraham",

                "Doe",

                faker.internet().emailAddress(),

                "123",

                "123"

        );

    }

    public static User createPasswordMismatchUser() {

        return new User(

                "John",

                "Ebraham",

                "Doe",

                faker.internet().emailAddress(),

                "Test@1234",

                "Wrong@123"

        );

    }

    public static User createEmptyUser() {

        return new User(

                "",

                "",

                "",

                "",

                "",

                ""

        );

    }

    public static User withoutFirstName() {

        String password = "Test@1234";

        return new User(

                "",

                faker.name().lastName(),

                faker.name().lastName(),

                faker.internet().emailAddress(),

                password,

                password

        );

    }

    public static User withoutLastName() {

        String password = "Test@1234";

        return new User(

                faker.name().lastName(),

                faker.name().lastName(),

                "",

                faker.internet().emailAddress(),

                password,

                password

        );

    }

    public static User emptyEmailUser() {

        return new User(

                "Ravindu",

                "Pasan",

                "Nanayakkara",

                "",

                "Ravindu@2001",

                "Ravindu@2001"

        );

    }

    public static User emptyPasswordUser() {

        return new User(

                "Ravindu",

                "Pasan",

                "Nanayakkara",

                "ravindu@gmail.com",

                "",

                "Ravindu@2001"

        );

    }


    public static User createInvalidEmail() {

        return new User(

                "Chandima",

                "Suboda",

                "Nanayakkara",

                "ravindu2001@gmail.com",

                "Ravindu@2001",

                "Ravindu@2001"

        );

    }
}