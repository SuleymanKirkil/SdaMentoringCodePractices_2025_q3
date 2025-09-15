package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T03DeleteConformedTest extends TestBase {
    /*
Go to https://claruswaysda.github.io/deleteChars.html
Enter your full name
click delete until msg deleted appeare
Verify the message 'Deleted'
*/
By inputTextById = By.id("inputText");
By enterButtonById = By.id("enterButton");
By deleteButtonById = By.id("deleteButton");
By deletedMessageById = By.id("deletedMessage");
    By field = By.xpath("//input[@type='text']");
    By enterButton = By.id("enterButton");
    By deleteButton = By.id("deleteButton");
    By messageId = By.id("deletedMessage");
    String deletedMessage = "Deleted";
    String nameExample = "John Doe";
    @Test
    void nameYoumna() {
        By delete = By.id("deletedMessage");

//Go to https://claruswaysda.github.io/deleteChars.html
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//Enter your full name
        Faker faker = new Faker();
        driver.findElement(By.id("inputText")).sendKeys(faker.name().fullName());

//Delete the letters
        driver.findElement(By.id("enterButton")).click();

        while ( !driver.findElement(delete).isDisplayed()) {
            driver.findElement(By.id("deleteButton")).click();
        }
//Verify the message 'Deleted'
        wait.until(ExpectedConditions.visibilityOfElementLocated(delete));
        System.out.println(driver.findElement(delete).getText());

    }
    @Test
    void deleteRaja() {
        /*
 Go to https://claruswaysda.github.io/deleteChars.html

 Enter your full name
 Delete the letters
 Verify the message 'Deleted'
 */

        driver.get("https://claruswaysda.github.io/deleteChars.html");
        driver.findElement(By.id("inputText")).sendKeys("John Doe");
        driver.findElement(By.id("enterButton")).click();
        // Delete the letters use for loop
        for (int i = 0; i < 8; i++) {
            driver.findElement(By.id("deleteButton")).click();

        }

        //Verify the message 'Deleted'
        String deletedMessage = driver.findElement(By.id("deletedMessage")).getText();
        System.out.println(deletedMessage);
        if (deletedMessage.equals("Deleted")) {
            System.out.println("Test Passed: The message is 'Deleted'");
        } else {
            System.out.println("Test Failed: The message is not 'Deleted'");
        }
        Assertions.assertEquals("Deleted",deletedMessage);
    }

    @Test
    void testShahad() throws InterruptedException {
        String name = "Shahad";
        driver.get("https://claruswaysda.github.io/deleteChars.html");

        driver.findElement(By.id("inputText")).sendKeys(name);

        driver.findElement(By.id("enterButton")).click();

        WebElement deleteBtn = driver.findElement(By.id("deleteButton"));
        for (int i = 0; i < name.length(); i++) {
            deleteBtn.click();
        }
        String deleteMessage = driver.findElement(By.id("deletedMessage")).getText();
        String expectedMessage = "Deleted";
        Assertions.assertEquals(expectedMessage, deleteMessage);

    }
    @Test
    void testAli() {
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        driver.findElement(field).sendKeys(nameExample);
        driver.findElement(enterButton).click();

        for(int i= 0 ; i < nameExample.length(); i++){
            driver.findElement(deleteButton).click();
        }

        String message = driver.findElement(messageId).getText();
        Assertions.assertEquals(deletedMessage,message);
    }

String text = "My Name";
    @Test
    void deleteTest() {
        //Go to https://claruswaysda.github.io/deleteChars.html
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        //Enter your full name
        driver.findElement(inputTextById).sendKeys();
        driver.findElement(enterButtonById).click();

        //click delete until msg deleted appeare

        //Verify the message 'Deleted'

    }
}
