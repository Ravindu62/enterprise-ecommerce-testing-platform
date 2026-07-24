package pages;


import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class BasePage {


    protected WebDriver driver;


    protected WebDriverWait wait;


    protected Actions actions;



    public BasePage(){


        this.driver =
                DriverManager.getDriver();


        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15)
                );


        this.actions =
                new Actions(driver);

    }



    // ==============================
    // Wait Methods
    // ==============================


    protected WebElement waitForElement(By locator){


        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator)
        );

    }



    protected WebElement waitForClickable(By locator){


        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator)
        );

    }



    protected boolean waitForInvisibility(By locator){


        return wait.until(
                ExpectedConditions
                        .invisibilityOfElementLocated(locator)
        );

    }



    // ==============================
    // Click Actions
    // ==============================


    protected void click(By locator){


        waitForClickable(locator)
                .click();

    }



    protected void javascriptClick(By locator){


        WebElement element =
                waitForElement(locator);


        JavascriptExecutor js =
                (JavascriptExecutor) driver;


        js.executeScript(
                "arguments[0].click();",
                element
        );

    }



    // ==============================
    // Input Actions
    // ==============================


    protected void sendKeys(
            By locator,
            String value){


        WebElement element =
                waitForElement(locator);


        element.clear();

        element.sendKeys(value);

    }



    protected String getText(By locator){


        return waitForElement(locator)
                .getText();

    }



    protected String getAttribute(
            By locator,
            String attribute){


        return waitForElement(locator)
                .getAttribute(attribute);

    }



    // ==============================
    // Validation Methods
    // ==============================


    protected boolean isDisplayed(By locator){


        try{


            return waitForElement(locator)
                    .isDisplayed();


        }catch(Exception e){


            return false;

        }

    }



    protected boolean isEnabled(By locator){


        return waitForElement(locator)
                .isEnabled();

    }



    // ==============================
    // Dropdown Handling
    // ==============================


    protected void selectDropdownByVisibleText(
            By locator,
            String text){


        Select select =
                new Select(
                        waitForElement(locator)
                );


        select.selectByVisibleText(text);

    }



    protected List<WebElement> getDropdownOptions(
            By locator){


        Select select =
                new Select(
                        waitForElement(locator)
                );


        return select.getOptions();

    }



    // ==============================
    // Mouse Actions
    // ==============================


    protected void hover(By locator){


        actions.moveToElement(
                waitForElement(locator)
        ).perform();

    }



    protected void moveAndClick(By locator){


        actions.moveToElement(
                        waitForElement(locator)
                )
                .click()
                .perform();

    }



    // ==============================
    // Scroll
    // ==============================


    protected void scrollToElement(By locator){


        WebElement element =
                waitForElement(locator);


        JavascriptExecutor js =
                (JavascriptExecutor) driver;


        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );

    }



    protected void scrollToBottom(){


        JavascriptExecutor js =
                (JavascriptExecutor) driver;


        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight)"
        );

    }



    // ==============================
    // Browser Actions
    // ==============================


    protected String getCurrentUrl(){


        return driver.getCurrentUrl();

    }



    protected String getPageTitle(){


        return driver.getTitle();

    }



    protected void refreshPage(){


        driver.navigate()
                .refresh();

    }



}