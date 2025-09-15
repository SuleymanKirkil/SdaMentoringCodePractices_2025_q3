package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T01_Heba extends TestBase {


    @Test
    void execute() {
        driver.get("https://claruswaysda.github.io/signIn.html");
        WebElement userName = driver.findElement(By.id("username"));
        newStyleElement(userName);
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        newStyleElement(password);
        password.sendKeys("123");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        newStyleElement(login);
        login.click();
        WebElement employeeTable = driver.findElement(By.id("employeeTable"));
        newStyleElement(employeeTable);
        Assertions.assertTrue(employeeTable.isDisplayed());

    }

    public void  newStyleElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.backgroundColor='#f0f8ff';" +
                        "arguments[0].style.color='#1e90ff';" +
                        "arguments[0].style.fontSize='18px';" +
                        "arguments[0].style.fontFamily='Arial, sans-serif';" +
                        "arguments[0].style.border='2px solid #ff4500';" +
                        "arguments[0].style.borderRadius='12px';" +
                        "arguments[0].style.padding='8px 15px';" +
                        "arguments[0].style.boxShadow='2px 2px 8px rgba(0,0,0,0.2)';",
                element
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


