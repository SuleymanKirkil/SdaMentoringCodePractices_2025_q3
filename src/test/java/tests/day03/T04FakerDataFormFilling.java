package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {
    /*
    Task: Go to "https://demoqa.com/text-box"
        . Use Java Faker to:

        Generate and enter a fake full name
        Generate and enter a fake email address
        Generate and enter a fake current address
        Generate and enter a fake permanent address
        Submit the form and verify the output contains the entered data
    */
    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @Test
    void fakerTest() {
        driver.get(url);
        //        Generate and enter a fake full name

        //        Generate and enter a fake email address
        //        Generate and enter a fake current address
        //        Generate and enter a fake permanent address
        //        Submit the form and verify the output contains the entered data
    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
