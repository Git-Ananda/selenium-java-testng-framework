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

public final class ScreenshotUtility {

    private ScreenshotUtility() {
    }

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "dd-MM-yyyy_HH-mm-ss"));

        String destination =
                "screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        try {

            Files.createDirectories(
                    new File("screenshots").toPath());

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            Files.copy(
                    source.toPath(),
                    new File(destination).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        }

        catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot.",
                    e);

        }

        return destination;

    }

}