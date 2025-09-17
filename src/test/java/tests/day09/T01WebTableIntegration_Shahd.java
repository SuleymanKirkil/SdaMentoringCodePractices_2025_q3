package tests.day09;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

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

    public static class T03SortingEarningsTest   {

        @Test
        void  test02() throws FileNotFoundException, IOException
        {
            String pathOf = Path.of(".", "resources", "EarningsTask.xlsx").toString();
            FileInputStream path = new FileInputStream(pathOf);
            Workbook workbook = WorkbookFactory.create(path);
            Sheet sheet = workbook.getSheetAt(0);


            ArrayList<Integer> earningsList = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                int earnings =(int) row.getCell(1).getNumericCellValue();
                earningsList.add(earnings);
                Collections.sort(earningsList);
                System.out.println(earningsList);
            }

            int rowNumber = 0;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                for(int j = 0; j < earningsList.size(); j++){
                    if(earningsList.get(j) == row.getCell(1).getNumericCellValue()){
                        row.getCell(2).setCellValue(j+1);
                        if(row.getCell(0).getStringCellValue().equals("Wednesday")){
                            rowNumber = j+1;
                        }
                    }
                }
            }

            FileOutputStream fos = new FileOutputStream(pathOf);
            workbook.write(fos);
            fos.close();
            Assertions.assertEquals(1, rowNumber);

        }
    }
}