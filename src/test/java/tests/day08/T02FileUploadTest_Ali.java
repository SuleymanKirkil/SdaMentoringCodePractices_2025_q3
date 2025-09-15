package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;


public class T02FileUploadTest_Ali extends TestBase {

    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Upload a PDF using single upload button
    Verify that 'Files uploaded successfully!'
    Do negative test (No file or other than PDF)
    Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
    Test multiple PDFs as well
    */

    By uploadButton = By.className("upload-btn");
    By submitButton = By.className("submit-btn");
    By success = By.className("success-box");
    By alert = By.className("alertBox");
    By alertMsg = By.className("alert-box");
    By multiUpload = By.xpath("//label[normalize-space()='Upload Multiple PDFs']");
    Path filePath1 = Path.of(System.getProperty("user.home"), "Downloads", "test.pdf");
    Path filePath2 = Path.of(System.getProperty("user.home"), "Downloads", "test1.pdf");
    Path filePath3 = Path.of(System.getProperty("user.home"), "Downloads", "test2.pdf");

    @Test
    public void T02FileUploadTest1() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        driver.findElement(uploadButton).click();

        String fileSTR = filePath1.toString();
        StringSelection transferableStr = new StringSelection(fileSTR);


        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transferableStr, null);

        Robot robot = new Robot();
        robot.setAutoDelay(200);
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            // Paste the path:
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            // Hit Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } else if (System.getProperty("os.name").toLowerCase().contains("win")) {
            // Paste the path:
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Hit Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(success).isDisplayed());
    }
    @Test
    public void T02FileUploadNegativeTest() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        driver.findElement(uploadButton).click();

        String fileSTR = filePath3.toString();
        StringSelection transferableStr = new StringSelection(fileSTR);


        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transferableStr, null);

        Robot robot = new Robot();
        robot.setAutoDelay(200);
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);

            // Paste the path:
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            // Hit Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } else if (System.getProperty("os.name").toLowerCase().contains("win")) {
            // Paste the path:
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Hit Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(alertMsg).isDisplayed());
    }
    @Test
    void T02FileUploadNoPathTest2() {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        driver.findElement(submitButton).click();
        Assertions.assertTrue(driver.findElement(alertMsg).isDisplayed());
    }

    @Test
    void T02FileUploadTest3() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        driver.findElement(submitButton).click();
        Assertions.assertTrue(driver.findElement(success).isDisplayed());

        Thread.sleep(5500);
    }
    }
