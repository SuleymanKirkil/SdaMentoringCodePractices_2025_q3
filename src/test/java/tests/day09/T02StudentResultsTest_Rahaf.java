package tests.day09;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02StudentResultsTest_Rahaf {
    @Test
    void name() throws IOException {
        FileInputStream fis= new FileInputStream(Path.of(".","resources","TestData02.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();
        Sheet sheet = workbook.getSheetAt(0);
        FileOutputStream fos=null;
        for (int i=1;i<=sheet.getLastRowNum();i++) {
            String score = sheet.getRow(i).getCell(1).toString();
            score = score.substring(0, 2);
            System.out.println("score = " + score);
            sheet.getRow(i).createCell(2).setCellValue(evaluateGrade(Integer.parseInt(score)));


            fos = new FileOutputStream(Path.of(".", "resources", "TestData02.xlsx").toString());
            workbook.write(fos);
        }
        fos.close();
        workbook.close();


    }

    private String evaluateGrade(int i) {
        if (i <101 && i>90) return "A";
        else if (i >79 && i<90) return "B";
        else if (i >69 && i<80) return "C";
        else if (i >59 && i<70) return "D";
        else if (i >0 && i<60) return "F";
        else return null;
    }

}
