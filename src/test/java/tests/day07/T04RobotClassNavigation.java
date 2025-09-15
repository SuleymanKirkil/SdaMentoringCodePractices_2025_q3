package tests.day07;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class T04RobotClassNavigation extends TestBase {
    //* Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
    //* Click into the username field.
    //* Type the username using sendKeys.
    //* Use the Robot class to:
    //* Press Tab → go to password field.
    //* Type the password using sendKeys.
    //* Press Enter → submit the form.
    //* Verify login success or error message.


    @Test
    void name() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
}
