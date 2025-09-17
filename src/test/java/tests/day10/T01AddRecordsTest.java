package tests.day10;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.List;

public class T01AddRecordsTest extends TestBase2 {

    /*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records.
Store the name, age, and country columns in separate arrays (not ArrayList).
*/

    @Test
    void name() {

        //  Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("claruswaysda web site is opened ....");

        //Add 10 records.
        logger.info("Adding 10 records to the site");

        for (int i=0;i<10;i++){
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"),Faker.instance().number().numberBetween(18,50)+"");
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1,5);
            try{
                select.selectByIndex(idx);
                logger.info("Country is selecteed with index :"+idx);
            }catch (Exception e){
                logger.error("Coulnd'T select by referance with idx :"+idx);
            }
            actionHelper.click(By.xpath("//button[.='Add Record']"));
        }


        //Store the name, age, and country columns in separate arrays (not ArrayList).
        List<WebElement> namesList = driver.findElements(By.xpath("//table//td[1]"));

        String[] namesArr = new String[namesList.size()];
        for (int i=0;i< namesList.size();i++){
            namesArr[i] = namesList.get(i).getText();
        }

        List<WebElement> agesList = driver.findElements(By.xpath("//table//td[2]"));

        String[] agesArr = new String[namesList.size()];
        for (int i=0;i< agesList.size();i++){
            agesArr[i] = agesList.get(i).getText();
        }

        List<WebElement> countryList = driver.findElements(By.xpath("//table//td[3]"));

        String[] countryArr = new String[countryList.size()];
        for (int i=0;i< countryList.size();i++){
            countryArr[i] = countryList.get(i).getText();
        }

        System.out.println("Names: ");
        for(String name:namesArr){
            System.out.print(name+ " ");
        }

        System.out.println(Arrays.asList(countryArr));
        System.out.println(Arrays.asList(agesArr));
    }


}
