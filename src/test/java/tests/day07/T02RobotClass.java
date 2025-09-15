package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02RobotClass extends TestBase {
     /*
 Go to https://claruswaysda.github.io/downloadUpload.html
 Click on 'Upload'
 Close the opening page using 'CTRL+F4'
 */

    @Test
    void test() throws AWTException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        driver.findElement(By.xpath("//label[normalize-space()='Upload']")).click();
        
        Robot robot = new Robot();
        robot.setAutoDelay(200);

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.out.println(System.getProperty("os.name"));
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } else if (System.getProperty("os.name").toLowerCase().contains("mac")){
            System.out.println(System.getProperty("os.name"));

            // Switch fpcus on the browser
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_META);

        }


    }
}