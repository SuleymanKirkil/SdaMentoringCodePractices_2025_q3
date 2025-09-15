package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T02IFramewithAlert extends TestBase {

 /*
Go to https://claruswaysda.github.io/iframe.html
Type your name in input
Click on 'Bold' button
Assert the alert message
*/


    Faker faker = new Faker();

    @Test
    void test() {

        driver.get("https://claruswaysda.github.io/iframe.html");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//input[@placeholder='Type here...']")).sendKeys(faker.name().fullName());


        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[.='Bold']")).click();


        Assertions.assertEquals(driver.switchTo().alert().getText(), "Bold button clicked");
        driver.switchTo().alert().accept();

    }
}
