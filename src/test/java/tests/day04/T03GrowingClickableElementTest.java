package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T03GrowingClickableElementTest {

   // Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
   // Click "click me" button
   // Verify "Event Triggered" appears
WebDriver driver;
String url = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";
By growingButtonByXpath = By.xpath("//button[@id='growbutton']");
By growbuttonstatusById = By.id("growbuttonstatus");

    @Test
    void test() {
    // Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.htm
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get(url);

    // Click "click me" butto
        wait.until(ExpectedConditions.attributeToBe(growingButtonByXpath,"class","styled-click-button showgrow grown"));
        driver.findElement(growingButtonByXpath).click();
        //wait.until(ExpectedConditions.elementToBeClickable(growingButtonByXpath)).click();
    // Verify "Event Triggered" appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(growbuttonstatusById));
        Assertions.assertEquals("Event Triggered",driver.findElement(growbuttonstatusById).getText());

    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


