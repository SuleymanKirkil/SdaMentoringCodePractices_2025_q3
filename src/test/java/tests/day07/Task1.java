package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {


    @Test
    void windowHandleTest() throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Go to the main page
        driver.get("https://claruswaysda.github.io/");


        // Click on 'Window Handle'
        driver.findElement(By.linkText("Window Handle")).click();

        // Click on 'Open Index Page' button
        new Actions(driver)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //WebElement linkButton = driver.findElement(By.xpath("//*[.='Open Index Page']"));
       // linkButton.click();

        // Get the original window handle
        String originalWindow = driver.getWindowHandle();

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Verify the URL of the new window
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://claruswaysda.github.io/index.html", currentUrl, "URL verification failed!");

        // Close the new window and switch back to the original
        driver.close();
        driver.switchTo().window(originalWindow);

        // Close the original window
        driver.quit();
    }
}