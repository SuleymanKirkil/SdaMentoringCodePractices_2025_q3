package tests.day09;

import org.junit.jupiter.api.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T02StudentGradingWriteBackTest_Hana {

    @Test
    void writeGradesToExcelAndVerifyAlice() throws IOException {
        String filePath = "src/test/resources/TestData02.xlsx";

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        String aliceGrade = "";


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            int score = (int) row.getCell(1).getNumericCellValue();

            String grade = getGrade(score);

            Cell gradeCell = row.createCell(2, CellType.STRING);
            gradeCell.setCellValue(grade);

            if (name.equals("Alice")) {
                aliceGrade = grade;
            }
        }

        fis.close();

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();

        // Assert Alice's grade
        assertEquals("A", aliceGrade);
        System.out.println("Grades written to Excel. Alice's grade is: " + aliceGrade);
    }

    private String getGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
}