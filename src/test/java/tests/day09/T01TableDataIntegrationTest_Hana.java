package tests.day09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T01TableDataIntegrationTest_Hana {

    @Test
    void addExcelDataToWebTable() throws IOException {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");


        FileInputStream fis = new FileInputStream("./resources/Task01.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<String> names = new ArrayList<>();
        List<String> ages = new ArrayList<>();
        List<String> countries = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            names.add(row.getCell(0).getStringCellValue());
            ages.add(String.valueOf((int) row.getCell(1).getNumericCellValue()));
            countries.add(row.getCell(2).getStringCellValue());
        }

        workbook.close();
        fis.close();


        for (int i = 0; i < names.size(); i++) {
            WebElement nameInput = driver.findElement(By.id("nameInput"));
            WebElement ageInput = driver.findElement(By.id("ageInput"));
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add Record']"));

            nameInput.clear();
            nameInput.sendKeys(names.get(i));

            ageInput.clear();
            ageInput.sendKeys(ages.get(i));

            new Select(countryDropdown).selectByVisibleText(countries.get(i));

            addBtn.click();
        }

        driver.quit();
        System.out.println("All records have been successfully added!");
    }
}