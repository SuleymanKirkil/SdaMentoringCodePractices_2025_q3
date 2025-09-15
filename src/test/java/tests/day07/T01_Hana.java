package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T01_Hana {


        // Method to highlight an element by changing its border color and style
        public void highlightElement(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }

        @Test
        void signInTest() {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();


            driver.get("https://claruswaysda.github.io/signIn.html");


            WebElement username = driver.findElement(By.id("username"));
            highlightElement(driver, username);
            username.sendKeys("admin");


            WebElement password = driver.findElement(By.id("password"));
            highlightElement(driver, password);
            password.sendKeys("123");


            WebElement signInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            highlightElement(driver, signInBtn);
            signInBtn.click();


            WebElement employeeTable = driver.findElement(By.id("employeeTable"));
            highlightElement(driver, employeeTable);
            assertTrue(employeeTable.isDisplayed(), "Employee Table should be visible after sign in");

           
            driver.quit();
        }
    }

