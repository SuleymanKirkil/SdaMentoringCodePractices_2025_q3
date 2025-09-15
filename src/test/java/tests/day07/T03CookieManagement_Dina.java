package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class T03CookieManagement_Dina extends TestBase {

    /*
    Go to https://claruswaysda.github.io/CookiesWait.html
    Accept the alert if it is present
    Print the cookies
    Delete all cookies and assert
    */

    String url = "https://claruswaysda.github.io/CookiesWait.html";
    WebDriverWait wait;

    @Test
    void task03CookieManagement()  {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://claruswaysda.github.io/CookiesWait.html");
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e){
            System.out.println("No Alert");
        }

        //conditional wait until id="acceptCookiesButton"

        wait.until(driver -> driver.findElement(By.id("acceptCookiesButton")).isDisplayed());
        driver.findElement(By.id("acceptCookiesButton")).click();

        //print all cookies
        Set cookies = driver.manage().getCookies();
        System.out.println("Cookies: " + cookies);

        //Delete all cookies and assert
        driver.manage().deleteAllCookies();
        Set cookiesAfterDeletion = driver.manage().getCookies();
        assert cookiesAfterDeletion.isEmpty() : "Cookies were not deleted successfully.";
        System.out.println("All cookies deleted successfully.");


    }
}