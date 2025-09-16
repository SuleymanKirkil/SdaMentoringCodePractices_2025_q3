package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T01WebTableIntegration_Shahd extends TestBase {

    /*
     Go to
https://claruswaysda.github.io/addRecordWebTable.html and add 10 records to the
 table by taking data (Name, Age, Country) from Excel.
     */

    Path path = Path.of("./", "resources", "Task01.xlsx");

    @Test
    void test() throws IOException {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        //locate elements
        WebElement inputName = driver.findElement(By.id("nameInput"));
        WebElement inputAge = driver.findElement(By.id("ageInput"));
        WebElement countrySelect = driver.findElement(By.id("countrySelect"));
        WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add Record']"));
        Select countries = new Select(countrySelect);

        //read excel file
        FileInputStream fis = new FileInputStream(path.toFile());
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        //loop through the rows and get data, then add to the web table
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            String name = sheet.getRow(i).getCell(0).toString();
            String age = sheet.getRow(i).getCell(1).toString();
            String country = sheet.getRow(i).getCell(2).toString();

            inputName.sendKeys(name);
            inputAge.sendKeys(age);
            countries.selectByValue(country);
            addButton.click();
        }


    }
}