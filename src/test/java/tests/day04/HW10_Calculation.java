package tests.day04;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HW10_Calculation {
    /*
             Go to  https://testpages.eviltester.com/styled/calculator
             Type any number in the first input and the second input
             Click on Calculate
             Get the result
             Verify the result
             Do this for all operations
    */
    WebDriver driver;

    @Test
    public void test10Addition() {
//        Go to  https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");

//        Type any number in the first input and the second input
        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));

        int num1 = 6;
        int num2 = 2;

        number1.sendKeys(num1 + "");
        number2.sendKeys(num2 + "");

//        Click on Calculate
        driver.findElement(By.id("calculate")).click();

//        Get the result
        int result = Integer.parseInt(driver.findElement(By.id("answer")).getText());

//        Verify the result
        assertEquals(num1 + num2, result);

//        Do this for all operations

    }

    @Test
    public void test10Subtraction() throws InterruptedException {
//        Go to  https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");

//        Type any number in the first input and the second input
        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));

        int num1 = 6;
        int num2 = 2;

        number1.sendKeys(num1 + "");
        number2.sendKeys(num2 + "");

//        Click on Calculate
        new Select(driver.findElement(By.id("function"))).selectByVisibleText("minus");
        driver.findElement(By.id("calculate")).click();

//        Get the result
        int result = Integer.parseInt(driver.findElement(By.id("answer")).getText());

//        Verify the result
        assertEquals(num1 - num2, result);

//        Do this for all operations

    }

    @Test
    public void test10Multiplication() {
//        Go to  https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");

//        Type any number in the first input and the second input
        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));

        int num1 = 6;
        int num2 = 2;

        number1.sendKeys(num1 + "");
        number2.sendKeys(num2 + "");

//        Click on Calculate
        new Select(driver.findElement(By.id("function"))).selectByVisibleText("times");
        driver.findElement(By.id("calculate")).click();

//        Get the result
        int result = Integer.parseInt(driver.findElement(By.id("answer")).getText());

//        Verify the result
        assertEquals(num1 * num2, result);

//        Do this for all operations

    }


    @Test
    public void test10Division() {
//        Go to  https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");

//        Type any number in the first input and the second input
        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));

        int num1 = 6;
        int num2 = 2;

        number1.sendKeys(num1 + "");
        number2.sendKeys(num2 + "");

//        Click on Calculate
        new Select(driver.findElement(By.id("function"))).selectByVisibleText("divide");
        driver.findElement(By.id("calculate")).click();

//        Get the result
        int result = Integer.parseInt(driver.findElement(By.id("answer")).getText());

//        Verify the result
        assertEquals(num1 / num2, result);

//        Do this for all operations

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();

    }
}
