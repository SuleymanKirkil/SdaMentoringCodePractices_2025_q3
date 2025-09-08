package tests.day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08GoogleSearchTest {
static WebDriver driver;
static String url = "https://www.google.com";
String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};
    By searchBoxByName = By.name("q");
    By resultCountByXpath = By.xpath("");

@BeforeAll
public static void setUp() throws InterruptedException {
// TODO: Initialize static WebDriver
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// TODO: Navigate to Google
    driver.get(url);
    //Thread.sleep(2000);
    driver.findElement(By.xpath("//div[.='Tout accepter']")).click();

}
@Test
public void searchMovies() throws InterruptedException {

for(String movie : movies) {
// TODO: Find search box
    driver.findElement(searchBoxByName).clear();
// TODO: Clear and enter movie name
// TODO: Submit search
    driver.findElement(searchBoxByName).sendKeys(movies[0], Keys.ENTER);
    Thread.sleep(10000);

// TODO: Get and print result count

// TODO: Clear search box for next iteration
    driver.findElement(searchBoxByName).clear();
}
}
@AfterAll
public static void tearDown() {
// TODO: Close driver
}
}