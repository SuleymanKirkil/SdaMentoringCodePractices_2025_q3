package tests.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01NavigateBackAndForward {

    public static void main(String[] args) throws InterruptedException {
     /*
        TC - 01

    Invoke Chrome Browser
    Navigate to URL: https://www.w3schools.com/
    Navigate to URL: https://stackoverflow.com/
    Come back to the w3schools using the back command.
    Again go back to the stackoverflow website using forward command
    Refresh the Browser using refresh command.
    Close the Browser.

      */

        //Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Navigate to URL: https://www.w3schools.com/
        driver.navigate().to("https://www.w3schools.com/");

       //Navigate to URL: https://stackoverflow.com/
        driver.get("https://stackoverflow.com/");

        //Come back to the w3schools using the back command.
        driver.navigate().back();
        Thread.sleep(1000);

        //Again go back to the stackoverflow website using forward command
        driver.navigate().forward();
        Thread.sleep(1000);

        //Refresh the Browser using refresh command.
        driver.navigate().refresh();
        Thread.sleep(1000);

        //Close the Browser.
        driver.close(); // Close the active TAB
        driver.quit();  // Terminates the session -> closes all tabs
    }
}
