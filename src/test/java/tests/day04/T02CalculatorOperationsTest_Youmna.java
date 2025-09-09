package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T02CalculatorOperationsTest_Youmna {
   //   Go to https://testpages.eviltester.com/styled/calculator
   //   Type any number in first and second input
   //   Click Calculate for each operation
   //   Get and verify results for all operations
    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    String num1 = "27";
    String num2 = "20";
    String[] operations = {"plus","times","minus","divide"};

    By num1ById = By.id("number1");
    By num2ById = By.id("number2");
    By operatioDropdownById = By.id("function");
    By calculateButtonById = By.id("calculate");
    By resultById = By.id("answer");



    @Test
    void calculatorTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //   Go to https://testpages.eviltester.com/styled/calculator
        driver.get(url);
        //   Type any number in first and second input
        driver.findElement(num1ById).sendKeys(num1);
        driver.findElement(num2ById).sendKeys(num2);
        //Select select = new Select(driver.findElement(operatioDropdownById));

        //   Click Calculate for each operation
        //   Get and verify results for all operations
        for (int i = 0; i < operations.length; i++) {
            Select select = new Select(driver.findElement(operatioDropdownById));
            select.selectByIndex(i);

            driver.findElement(calculateButtonById).click();
            //WebElement operationElement = select.getFirstSelectedOption();

            Double result = switch (operations[i]) {
                case "plus" -> Double.parseDouble(num1) + Double.parseDouble(num2);
                case "times" -> Double.parseDouble(num1) * Double.parseDouble(num2);
                case "minus" -> Double.parseDouble(num1) - Double.parseDouble(num2);
                case "divide" -> Double.parseDouble(num1) / Double.parseDouble(num2);
                default -> null;
            };


                Thread.sleep(200);


            Double actual = Double.parseDouble(driver.findElement(resultById).getText());
            System.out.println("Expected = " + result + " | Actual = " + actual);
            Assertions.assertEquals(result, actual);
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

