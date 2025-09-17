package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase2 {

    protected WebDriver driver;
    protected ActionHelper actionHelper;
    protected Logger logger;
    @BeforeEach
    void setUp() {
        logger= LogManager.getLogger(TestBase2.class);
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Chrome browser is initialized...");
        driver.manage().window().maximize();
        actionHelper = new ActionHelper(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Chrome browser is closed ...");
    }
}
