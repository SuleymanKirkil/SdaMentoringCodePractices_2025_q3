package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHelper {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger logger;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = LogManager.getLogger(ActionHelper.class);
    }

    public WebElement findElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element found successfully: {}", locator);
            return element;
        } catch (TimeoutException e) {
            logger.error("Timeout while finding element: {}", locator);
            throw new TimeoutException("Element not found within time: " + locator, e);
        } catch (NoSuchElementException e) {
            logger.error("Element not found: {}", locator);
            throw new NoSuchElementException("Element not found: " + locator, e);
        } catch (Exception e) {
            logger.error("Unexpected error while finding element: {}", locator, e);
            throw new RuntimeException("Error finding element: " + locator, e);
        }
    }

    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Clicked element successfully: {}", locator);
        } catch (ElementClickInterceptedException e) {
            logger.error("Element click was intercepted: {}", locator);
            throw new ElementClickInterceptedException("Element click was intercepted: " + locator, e);
        } catch (Exception e) {
            logger.error("Failed to click element: {}", locator, e);
            throw new RuntimeException("Error clicking element: " + locator, e);
        }
    }

    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Clicked element successfully: {}", element);
        } catch (ElementClickInterceptedException e) {
            logger.error("Element click was intercepted: {}", element);
            throw new ElementClickInterceptedException("Element click was intercepted", e);
        } catch (Exception e) {
            logger.error("Failed to click element: {}", element, e);
            throw new RuntimeException("Error clicking element", e);
        }
    }

    public void sendKeys(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            logger.info("Sent keys '{}' to element: {}", text, locator);
        } catch (Exception e) {
            logger.error("Failed to send keys to element: {}", locator, e);
            throw new RuntimeException("Error sending keys to element: " + locator, e);
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String text = element.getText();
            logger.info("Retrieved text '{}' from element: {}", text, locator);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from element: {}", locator, e);
            throw new RuntimeException("Error getting text from element: " + locator, e);
        }
    }

    public String getText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            logger.info("Retrieved text '{}' from element: {}", text, element);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from element: {}", element, e);
            throw new RuntimeException("Error getting text from element", e);
        }
    }

    public void acceptAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            logger.info("Alert accepted successfully");
        } catch (NoAlertPresentException e) {
            logger.error("No alert present to accept");
            throw new NoAlertPresentException("No alert present to accept", e);
        } catch (Exception e) {
            logger.error("Failed to accept alert", e);
            throw new RuntimeException("Error accepting alert", e);
        }
    }

    public String getAlertText() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            logger.info("Retrieved alert text: {}", alertText);
            return alertText;
        } catch (NoAlertPresentException e) {
            logger.error("No alert present to get text");
            throw new NoAlertPresentException("No alert present to get text", e);
        } catch (Exception e) {
            logger.error("Failed to get alert text", e);
            throw new RuntimeException("Error getting alert text", e);
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element is visible: {}", locator);
            return true;
        } catch (Exception e) {
            logger.info("Element is not visible: {}", locator);
            return false;
        }
    }

    public boolean isElementClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            logger.info("Element is clickable: {}", locator);
            return true;
        } catch (Exception e) {
            logger.info("Element is not clickable: {}", locator);
            return false;
        }
    }
}