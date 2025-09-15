package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T03UserRegistrationandScreenshotCapture_Raja extends TestBase {
     /*
 Go to https://claruswaysda.github.io/homepage.html
 Register a user
 Sign in with the registered user
 Take all pages' screenshots
 Take 'Celebrate Login' button's screenshot.
 Capture a screenshot of the page with confetti.
 */

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/homepage.html");
        WebElement userIcon = driver.findElement(By.xpath("//div[@id=\"userIcon\"]"));
        userIcon.click();

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        String firstHandel = driver.getWindowHandle();
        //driver.switchTo().window( FirstHandel);
        WebElement SNN = driver.findElement(By.xpath("//input[@id=\"ssn\"]"));

        SNN.sendKeys("123-45-6789");
        WebElement firstname = driver.findElement(By.xpath("//input[@id=\"first-name\"]"));

        firstname.sendKeys("John");
        WebElement lastname = driver.findElement(By.xpath("//input[@id=\"last-name\"]"));

        lastname.sendKeys("Doe");
        WebElement Addres = driver.findElement(By.xpath("//input[@id=\"address\"]"));

        Addres.sendKeys("123 Main St");
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"phone\"]"));

        phone.sendKeys("9875898644");
        WebElement USERNAME = driver.findElement(By.xpath("//input[@id=\"username\"]"));

        USERNAME.sendKeys("johndoe");
        WebElement emil = driver.findElement(By.xpath("//input[@id=\"email\"]"));

        emil.sendKeys("oiuytfvb@gmile.com");
        WebElement pass = driver.findElement(By.xpath("//input[@id=\"password\"]"));

        pass.sendKeys("12345");
        WebElement pass2 = driver.findElement(By.xpath("//input[@id=\"confirm-password\"]"));

        pass2.sendKeys("12345");
        WebElement submint = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        submint.click();
        WebElement mussg = driver.findElement(By.xpath("//div[@id=\"successMessage\"]"));
        Assertions.assertTrue(mussg.isEnabled());
        WebElement loginusername = driver.findElement(By.xpath("//button[@class=\"login-button\"]"));
        loginusername.click();




    }
}