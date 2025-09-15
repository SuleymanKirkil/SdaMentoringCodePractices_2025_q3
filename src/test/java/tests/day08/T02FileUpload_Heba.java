package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Path;

public class T02FileUpload_Heba extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/
    String fileName1 = "08 - Selenium Files & Screenshots - Review and Summary.pdf";
    String fileName2 = "07-Selenium WebDriver - JS Executor - Robot  Class - Cookies Review & Practice Tasks.pdf";

    Path path1 = Path.of(System.getProperty("user.home"), "Downloads", fileName1);
    Path path2 = Path.of(System.getProperty("user.home"), "Downloads", fileName2);

    @Test
    public void Test01() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Upload a PDF using single upload button
       Path uploadSinglePDF = Path.of(System.getProperty("user.home"),"Downloads","08 - Selenium Files & Screenshots - Review and Summary.pdf");
       driver.findElement(By.className("upload-btn")).click();
       driver.findElement(By.id("uploadInput")).sendKeys(uploadSinglePDF.toString());
       driver.findElement(By.className("submit-btn")).click();

      // WebElement successMseage = driver.findElement(By.id("alertBox"));
       //Verify that 'Files uploaded successfully!'
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());

    }

    @Test
    public void negativePathTest01() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Upload a PDF using single upload button
        Path uploadSinglePDF = Path.of(System.getProperty("user.home"),"Downloads","Selenium Files & Screenshots - Review and Summary.pdf");
        driver.findElement(By.className("upload-btn")).click();
        try {
            driver.findElement(By.id("uploadInput")).sendKeys(uploadSinglePDF.toString());

        }catch (InvalidArgumentException e){
            System.out.println("Do you like File Topic");
        }
        driver.findElement(By.className("submit-btn")).click();

        // WebElement successMseage = driver.findElement(By.id("alertBox"));
        //Verify that 'Files uploaded successfully!'
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("alertBox")).isDisplayed());


    }
    @Test
    public void Test03HelpOfShahd() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // Multiple files
        driver.findElement(By.id("multiUploadInput")).sendKeys(path1.toString() + "\n" + path2.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
        Thread.sleep(3000);
    }
}