package utils;


import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ScreenshotUtils {


    private ScreenshotUtils(){

    }



    public static String captureScreenshot(
            String testName) {


        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                )
                        .format(new Date());



        String filePath =
                "./screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";



        try {


            File source =
                    ((TakesScreenshot)
                            DriverManager.getDriver())
                            .getScreenshotAs(
                                    OutputType.FILE
                            );


            File destination =
                    new File(filePath);



            FileUtils.copyFile(
                    source,
                    destination
            );



        } catch (Exception e) {


            throw new RuntimeException(
                    "Unable to capture screenshot",
                    e
            );

        }



        return filePath;

    }


}