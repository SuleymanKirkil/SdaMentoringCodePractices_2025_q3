package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Path;

public class T02FileUploadingTest extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/

    @Test
    void name() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");


        // sent multiple pdf's:
        Path pdf1Path = Path.of(System.getProperty("user.home"),"Downloads","prestige.pdf");
        Path pdf2Path = Path.of(System.getProperty("user.home"),"Downloads","Resume_Umang(SDET).pdf");
        Path pdf3Path = Path.of(System.getProperty("user.home"),"Downloads","Document.pdf");
        WebElement multiUploadInput = driver.findElement(By.id("multiUploadInput"));


        String multiplePaths = pdf1Path.toString() + "\n" +
                pdf2Path.toString() + "\n" +
                pdf3Path.toString();

        multiUploadInput.sendKeys("""
                /Users/suleymankirkil/Downloads/prestige.pdf
                /Users/suleymankirkil/Downloads/Document.pdf
                """);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assertions.assertTrue(driver.findElement(By.id("success-box")).getText().contains("Files uploaded successfully!"));
    }
}
