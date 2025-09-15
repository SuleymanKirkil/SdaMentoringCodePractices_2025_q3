package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02RobotTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on 'Upload'
    Close the opening page using 'CTRL+F4'
    */

    @Test
    void ctrlF4Test() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        By uploadButtonByClass = By.className("upload-btn");

        driver.findElement(uploadButtonByClass).click();
        Robot robot = new Robot();
        robot.setAutoDelay(200);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
    }
}