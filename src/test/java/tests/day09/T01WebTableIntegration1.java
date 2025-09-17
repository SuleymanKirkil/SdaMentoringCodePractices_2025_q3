package tests.day09;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T01WebTableIntegration1 {
   // Objective: Go to https://claruswaysda.github.io/addRecordWebTable.html and add 10 records to the
   // table by taking data (Name, Age, Country) from Excel.
   String url = "https://claruswaysda.github.io/addRecordWebTable.html";
    @Test
    void name() throws IOException {
        String [][] contacts = new String[10][3];
        List<String> nameList = new ArrayList<>();
        List<String> ageList = new ArrayList<>();
        List<String> countryList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(Path.of(".","resources","Task01.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();
        Sheet sheet = workbook.getSheetAt(0);

        for (int i=1; i<=sheet.getLastRowNum();i++) {
            String [] contactArr = new String[3];
            Row row = sheet.getRow(i);

            contactArr[0] =row.getCell(0).toString();
            contactArr[1] =row.getCell(1).toString();
            contactArr[2] =row.getCell(2).toString();

            contacts[i-1] =contactArr;
        }
        workbook.close();
        System.out.println(Arrays.deepToString(contacts));

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        for (int i = 0; i < contacts.length; i++) {
            WebElement nameInput = driver.findElement(By.id("nameInput"));
            WebElement ageInput = driver.findElement(By.id("ageInput"));
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add Record']"));

            nameInput.clear();
            nameInput.sendKeys(contacts[i][0]);

            ageInput.clear();
            ageInput.sendKeys(contacts[i][1]);

            new Select(countryDropdown).selectByVisibleText(contacts[i][2]);

            addBtn.click();
        }

        driver.quit();


    }
}
