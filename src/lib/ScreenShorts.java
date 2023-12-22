package lib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static lib.BaseClass.driver;

public class ScreenShorts {
    public static void takeScreenShorts() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String date = getCurrentTimeStamp();
            String destinationFile = BaseClass.projectPath + "/src/screenShorts/screenshot" + date + ".png";
            FileUtils.copyFile(scrFile, new File(destinationFile)); // interview questions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
    }
}
