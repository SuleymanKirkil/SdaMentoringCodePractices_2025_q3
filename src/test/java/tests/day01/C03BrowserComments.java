package tests.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {
    // TC – 03

// Expected Title
// Launch Chrome browser
// Open URL of Website
// Maximize Window
// Get Title of current Page
// Validate/Compare Page Title
// Close Browser

    public static void main(String[] args) {
    // Expected Title
        String expTitle = "Google";

// Launch Chrome browser
        WebDriver driver = new ChromeDriver();

// Open URL of Website
        driver.get("https://www.google.com/");

// Maximize Window
        driver.manage().window().maximize();

// Get Title of current Page
        String actualTitle = driver.getTitle();
        //System.out.println("actualTitle = " + actualTitle);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

// Validate/Compare Page Title
        if (actualTitle.equals(expTitle)){
            System.out.println("Page title appear as expected");
        } else {
            System.out.println("Page title does not appear as expected");
        }
// Close Browser
        driver.quit();
    }
}
