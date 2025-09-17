package tests.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02StudentGradingSystem_Youmna {


    @Test
    void name() throws IOException {
        FileInputStream fis = new FileInputStream(Path.of(".", "resources", "TestData02.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Row header = sheet.getRow(0);
        header.createCell(2).setCellValue("Grade");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            Cell scoreCell = row.getCell(1);

            int score = (int) scoreCell.getNumericCellValue();
            String grade = getGrade(score);

            Cell gradeCell = row.createCell(2);
            gradeCell.setCellValue(grade);
        }

        fis.close();


        FileOutputStream fos = new FileOutputStream(Path.of(".", "resources", "TestData02.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    String getGrade(int score) {

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";


        }
    }
}
