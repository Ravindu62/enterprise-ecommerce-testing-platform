package utils;

import com.github.javafaker.Faker;


public class TestDataUtils {


    private static final Faker faker =
            new Faker();



    private TestDataUtils(){

    }



    public static String getFirstName(){

        return faker.name()
                .firstName();

    }



    public static String getLastName(){

        return faker.name()
                .lastName();

    }



    public static String getEmail(){

        return faker.internet()
                .emailAddress();

    }



    public static String getPassword(){

        return faker.internet()
                .password(
                        8,
                        12
                );

    }



    public static String getPhoneNumber(){

        return faker.phoneNumber()
                .cellPhone();

    }


}