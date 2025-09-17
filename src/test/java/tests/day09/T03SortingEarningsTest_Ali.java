package tests.day09;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class T03SortingEarningsTest_Ali {

    @Test
    void  test02() throws FileNotFoundException, IOException {
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