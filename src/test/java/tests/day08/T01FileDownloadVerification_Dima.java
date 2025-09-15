package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01FileDownloadVerification_Dima extends TestBase {
    @Test
    void task01FileDownloadVer() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //

        // Click on download button
        driver.findElement(By.xpath("//a[@class='download-btn']")).click();

        // Verify that 'QAProgram.png' file is downloaded
        String home = System.getProperty("user.home");
        String filePath = home + "/Downloads/QAProgram.png";
        Path path = Path.of(filePath);

        Thread.sleep(5000);
        Assertions.assertTrue(Files.exists(path), "File QAProgram.png was not downloaded successfully.");

    }

}