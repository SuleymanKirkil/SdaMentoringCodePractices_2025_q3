package tests.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09CalculatorTest {
        /*
     Navigate to  https://testpages.herokuapp.com/styled/index.html
     Click on  Calculator under Micro Apps
     Type any number in the first input
     Type any number in the second input
     Click on Calculate
     Get the result
     Verify the result
     Print the result
     Close the browser by using @After annotation
*/
    String url = "https://testpages.herokuapp.com/styled/index.html";
    WebDriver driver;
    int num1 = 12;
    int num2 = 95;

    By calculatorLinkId = By.id("calculatetest");
    By number1Name = By.name("number1");
    By number2Name = By.name("number2");
    By calculateById = By.id("calculate");
    By resultById = By.id("answer");

    @Test
    void additionTest() {
        driver.findElement(calculatorLinkId).click();

        driver.findElement(number1Name).sendKeys(String.valueOf(num1));
        driver.findElement(number2Name).sendKeys(String.valueOf(num2));
        driver.findElement(calculateById).click();
        String actualResult = driver.findElement(resultById).getText();
        int expectedResult = num1 + num2;

        Assertions.assertEquals(String.valueOf(expectedResult),actualResult);

    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
