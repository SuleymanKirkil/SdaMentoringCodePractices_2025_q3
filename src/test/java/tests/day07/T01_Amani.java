package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class T01_Amani extends TestBase {

    @Test
    public void signInWithRobotAndHighlight() throws AWTException {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        Robot robot = new Robot();
        robot.setAutoDelay(200);


        driver.get("https://claruswaysda.github.io/signIn.html");

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);

        String username = "admin";
        StringSelection ssUser = new StringSelection(username);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssUser, null);

        WebElement usernameField = driver.findElement(By.id("username"));
        highlightElement(js, usernameField);


        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);


        robot.keyPress(KeyEvent.VK_META);  // use VK_META for Mac
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);


        String password = "123";
        StringSelection ssPass = new StringSelection(password);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssPass, null);

        WebElement passwordField = driver.findElement(By.id("password"));
        highlightElement(js, passwordField);


        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);


        WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit'][value='Sign In']"));
        highlightElement(js, signInButton);
        js.executeScript("arguments[0].click();", signInButton);


        WebElement employeeTable = driver.findElement(By.id("employeeTable"));
        highlightElement(js, employeeTable);
        assert employeeTable.isDisplayed() : "Employee Table is not visible!";
    }


    public void highlightElement(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}


