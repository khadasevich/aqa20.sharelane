package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Screenshoter {
    public static void takeScreenShot(WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshotInBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Paths.get("src/test/resources/screenshot.png"), screenshotInBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
