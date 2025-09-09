package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T02CalculatorOperations02Test {

    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    By firstInput = By.id("number1");
    By secondInput = By.id("number2");

    String num1 = "20";
    String num2 = "5";

    String[] operations = {"plus","minus","times","divide"};


    int addResult = Integer.parseInt(num1) + Integer.parseInt(num2);
    int subResult = Integer.parseInt(num1) - Integer.parseInt(num2);
    int mulResult = Integer.parseInt(num1) * Integer.parseInt(num2);
    int divResult = Integer.parseInt(num1) / Integer.parseInt(num2);

    String expectedAddResult = String.valueOf((int)addResult);
    String expectedSubResult = String.valueOf((int)subResult);
    String expectedMulResult = String.valueOf((int)mulResult);
    String expectedDivResult = String.valueOf(divResult);


    @Test
    void test() throws InterruptedException {

        //   Go to https://testpages.eviltester.com/styled/calculator
        driver.get(url);

        //   Type any number in first and second input
        driver.findElement(firstInput).sendKeys(num1);
        driver.findElement(secondInput).sendKeys(num2);

        //   Click Calculate for each operation

        for(int i=0; i<operations.length; i++){

            driver.findElement(firstInput).clear();
            driver.findElement(firstInput).sendKeys(num1);
            driver.findElement(secondInput).clear();
            driver.findElement(secondInput).sendKeys(num2);

            WebElement op = driver.findElement(By.id("function"));
            Select select = new Select(op);
            select.selectByValue(operations[i]);
            driver.findElement(By.id("calculate")).click();

            //   Get and verify results for all operations
            switch (operations[i]) {
                case "plus" -> {
                    String additionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedAddResult, additionResult);
                    System.out.println("Addition Result: " + additionResult); // 20 + 5
                }
                case "minus" -> {
                    String subtractionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedSubResult, subtractionResult);
                    System.out.println("Subtraction Result: " + subtractionResult); // 20 - 5
                }
                case "times" -> {
                    String multiplicationResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedMulResult, multiplicationResult);
                    System.out.println("Multiplication Result: " + multiplicationResult); // 20 * 5
                }
                case "divide" -> {
                    String divisionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedDivResult, divisionResult);
                    System.out.println("Division Result: " + divisionResult); // 20 / 5
                }
            }
            //for stale element exception
            driver.navigate().refresh();
        }

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

