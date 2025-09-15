package tests.day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T03ScreenShotTest  extends TestBase {
    /*
Go to https://claruswaysda.github.io/homepage.html
Register a user
Sign in with the registered user
Take all pages' screenshots
Take 'Celebrate Login' button's screenshot.
Capture a screenshot of the page with confetti.
*/

    String url = "https://claruswaysda.github.io/homepage.html";
    By registerBy = By.xpath("//a[.='Register']");
    By signInBy = By.xpath("//a[.='Sign In']");
    By ssnBy = By.id("ssn");
    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By addressBy = By.id("address");
    By phoneBy = By.id("phone");
    By ssBy = By.id("ssn");


    String username="testUser";
    String email="tester@test.com";
    String password="abc123";


    @Test
    void name() {
       //Go to https://claruswaysda.github.io/homepage.html
        driver.get("https://claruswaysda.github.io/homepage.html");

        //Register a user

        //Sign in with the registered user
        //Take all pages' screenshots
        //Take 'Celebrate Login' button's screenshot.
        //Capture a screenshot of the page with confetti
    }
}
