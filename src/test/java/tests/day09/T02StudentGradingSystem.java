package tests.day09;

import utilities.TestBase;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02StudentGradingSystem extends TestBase {
    @Test
    void test() throws IOException {

        String path = Path.of(".","resources","TestData02.xlsx").toString();
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

        Sheet sheet = workbook.getSheetAt(0);
        String aliceGrade = null;
        String student = null;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            student = row.getCell(0).getStringCellValue();
            int score = (int) row.getCell(1).getNumericCellValue();
            Cell gradeCell = row.getCell(2);

            String grade;
            if (score >= 90) grade = "A";
            else if (score >= 80) grade = "B";
            else if (score >= 70) grade = "C";
            else if (score >= 60) grade = "D";
            else grade = "F";

            gradeCell.setCellValue(grade);

            if (student.equals("Alice")) {
                aliceGrade = grade;
            }
            System.out.println(student + " is:"+ grade);
        }

        Assertions.assertEquals("A", aliceGrade);

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        fos.close();
        workbook.close();
    }
    }
