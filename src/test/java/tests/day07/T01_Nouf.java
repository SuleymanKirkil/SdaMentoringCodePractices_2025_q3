package tests.day07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class T01_Nouf extends TestBase {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;


    WebElement username;
    WebElement password;
    WebElement signInBtn;
    WebElement employeeTable;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://claruswaysda.github.io/signIn.html");


        username = driver.findElement(By.id("username"));
        password = driver.findElement(By.id("password"));
        signInBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Sign In']"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid magenta'", element);
        js.executeScript("arguments[0].style.backgroundColor='lightgreen'", element);
    }

    @Test
    void testSignInAndVerifyEmployeeTable() {

        highlightElement(username);
        username.sendKeys("admin");

        highlightElement(password);
        password.sendKeys("123");

        highlightElement(signInBtn);
        signInBtn.click();


        employeeTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeTable")));
        highlightElement(employeeTable);

        Assertions.assertTrue(employeeTable.isDisplayed(), "Employee Table should be visible");
    }
}


