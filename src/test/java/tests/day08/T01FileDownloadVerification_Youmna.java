package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01FileDownloadVerification_Youmna extends TestBase {

    @Test
    void name() throws InterruptedException, IOException {
//        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Click on download
        driver.findElement(By.className("download-btn")).click();
        Thread.sleep(2000);

//        Verify that 'QAProgram.png' file is downloaded
        Path filePath = Path.of(System.getProperty("user.home"), "Downloads", "QAProgram.png");
        Assertions.assertTrue(Files.exists(filePath));
        //Files.deleteIfExists(filePath);
    }
}