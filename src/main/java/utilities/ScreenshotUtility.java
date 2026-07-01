package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destination =
                "screenshots/"
                        + testName
                        + "_"
                        + LocalDateTime.now()
                        + DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")
                        + ".png";

        try {

            Files.createDirectories(new File("screenshots").toPath());

            Files.copy(source.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);

        }

        catch (IOException e) {

            throw new RuntimeException(e);

        }

        return destination;

    }

}