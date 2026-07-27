package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import config.ConfigReader;


public class WaitUtils {


    private WaitUtils() {

    }


    private static WebDriverWait getWait() {


        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(
                        ConfigReader.getExplicitWait()
                )
        );

    }



    public static WebElement waitForVisibility(By locator) {


        return getWait()
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(locator)
                );

    }



    public static WebElement waitForClickable(By locator) {


        return getWait()
                .until(
                        ExpectedConditions
                                .elementToBeClickable(locator)
                );

    }



    public static boolean waitForElementInvisible(By locator) {


        return getWait()
                .until(
                        ExpectedConditions
                                .invisibilityOfElementLocated(locator)
                );

    }



    public static boolean waitForUrlContains(
            String url) {


        return getWait()
                .until(
                        ExpectedConditions
                                .urlContains(url)
                );

    }



    public static boolean waitForTitleContains(
            String title) {


        return getWait()
                .until(
                        ExpectedConditions
                                .titleContains(title)
                );

    }


}