package driver;


import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {



    public static void initializeDriver() {


        String browser =
                ConfigReader.getBrowser()
                        .toLowerCase();



        WebDriver driver;



        switch(browser) {


            case "chrome":

                WebDriverManager.chromedriver()
                        .setup();

                driver =
                        new ChromeDriver(
                                BrowserFactory
                                        .getChromeOptions()
                        );

                break;



            case "firefox":

                WebDriverManager.firefoxdriver()
                        .setup();

                driver =
                        new FirefoxDriver(
                                BrowserFactory
                                        .getFirefoxOptions()
                        );

                break;



            case "edge":

                WebDriverManager.edgedriver()
                        .setup();

                driver =
                        new EdgeDriver(
                                BrowserFactory
                                        .getEdgeOptions()
                        );

                break;



            default:

                throw new RuntimeException(
                        "Browser not supported: "
                                + browser
                );

        }



        DriverManager.setDriver(driver);



        if(Boolean.parseBoolean(
                ConfigReader.getProperty("maximize")
        )){

            DriverManager.getDriver()
                    .manage()
                    .window()
                    .maximize();

        }



        DriverManager.getDriver()
                .manage()
                .timeouts()
                .pageLoadTimeout(
                        java.time.Duration.ofSeconds(30)
                );

    }



    public static void quitDriver() {


        if(DriverManager.getDriver()!=null) {


            DriverManager.getDriver()
                    .quit();


            DriverManager.unloadDriver();

        }

    }

}