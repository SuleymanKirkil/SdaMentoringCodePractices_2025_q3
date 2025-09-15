package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T01JScriptExecutorTest extends TestBase {
    ///*
    //Go to https://claruswaysda.github.io/signIn.html
    //enter username 'admin'
    //enter password '123'
    //Click on Sign In
    //Assert the 'Employee Table' is visible
    //Create a method to change border color and style of web elements.
    //Use the method on each element you interact with.
    //*/

    @Test
    void jsExecutorTest() {
        By userNameBy = By.id("username");
        By passwordBy = By.id("password");
        By employeeTableBy = By.id("employeeTable");
        By signInBy = By.xpath("//input[@type='submit']");

        String userName = "admin";
        String password = "123";

        driver.get("https://claruswaysda.github.io/signIn.html");

        // Sign in to yhe application

        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signInBy).click();

        WebElement table = driver.findElement(employeeTableBy);






    }
}
