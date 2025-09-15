package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class T03CookieManagement_Rahaf extends TestBase {

    /*
    Go to https://claruswaysda.github.io/CookiesWait.html
    Accept the alert if it is present
    Print the cookies
    Delete all cookies and assert
    */

    String url = "https://claruswaysda.github.io/CookiesWait.html";

    @Test
    void test() {
        driver.get(url);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

        } catch (TimeoutException e){
            System.out.println("No alert present");
        }

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("=== Cookies Before Deleted ===");
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().deleteAllCookies();
        System.out.println("=== Cookies After Deleted ===");
        driver.manage().getCookies().forEach(System.out::println);

        Assertions.assertTrue(driver.manage().getCookies().isEmpty());
    }
}