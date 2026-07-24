package driver;

import config.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {


    public static ChromeOptions getChromeOptions() {


        ChromeOptions options = new ChromeOptions();


        if (ConfigReader.isHeadless()) {

            options.addArguments("--headless=new");

        }


        options.addArguments(
                "--start-maximized",
                "--disable-notifications",
                "--disable-popup-blocking",
                "--remote-allow-origins=*"
        );


        return options;
    }



    public static FirefoxOptions getFirefoxOptions() {


        FirefoxOptions options =
                new FirefoxOptions();


        if (ConfigReader.isHeadless()) {

            options.addArguments("--headless");

        }


        return options;

    }



    public static EdgeOptions getEdgeOptions() {


        EdgeOptions options =
                new EdgeOptions();


        if (ConfigReader.isHeadless()) {

            options.addArguments("--headless=new");

        }


        options.addArguments(
                "--start-maximized",
                "--disable-notifications"
        );


        return options;

    }

}