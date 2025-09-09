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
import java.util.List;

public class T01SauceDemoTest {

    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String password = "secret_sauce";
    String visibleText = "Price (low to high)";


    By userNameById = By.id("user-name");
    By passwordById = By.id("password");
    By loginButtonById = By.id("login-button");
    By dropDownByCss = By.cssSelector(".product_sort_container");
    By priceByXpath = By.xpath("//div[@class='inventory_item_price']");


    @Test
    void sauceDemoTest() {
        //Given: Go to https://www.saucedemo.com/
        driver.get(url);
        //When: Enter username as "standar_duser"
        driver.findElement(userNameById).sendKeys(userName);
        //And: Enter password as "secret_sauce"
        driver.findElement(passwordById).sendKeys(password);
        //And: Click login button
        driver.findElement(loginButtonById).click();

        //And: Order products by "Price (low to high)"
        Select select = new Select(driver.findElement(dropDownByCss));
        select.selectByVisibleText(visibleText);

        //Then: Assert last product costs $49.99, first product costs $7.99
        List<WebElement> priceList= driver.findElements(priceByXpath);

        Assertions.assertEquals("7.99",priceList.get(0).getText().substring(1));
        Assertions.assertEquals("$49.99",priceList.getLast().getText());
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

