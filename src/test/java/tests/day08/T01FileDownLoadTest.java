package tests.day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T01FileDownLoadTest extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on download
Verify that 'QAProgram.png' file is downloaded
*/

    @Test
    void name() {
      //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        //Click on download
        driver.findElement(By.xpath("//*[.='Download']")).click();
        //Verify that 'QAProgram.png' file is downloaded
    }
}
