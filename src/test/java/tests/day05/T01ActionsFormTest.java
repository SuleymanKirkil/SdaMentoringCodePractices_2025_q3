package tests.day05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T01ActionsFormTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill the form
    Generate Passcode
    Use passcode to submit form
     */
    By nameId = By.id("name");
    By ageId = By.id("age");
    By selectID = By.id("options");
    By checkbox1value = By.xpath("//label[normalize-space()='Coding']");
    By checkbox2value = By.xpath("//label[normalize-space()='design']");
    By checkbox3value = By.xpath("//label[.=' Management']");
    By radioMale = By.xpath("//input[@value='male']");
    By radioFemale = By.xpath("//input[@value='female']");
    By radioOther = By.xpath("//input[@value='other']");
    By submitButton = By.xpath("//button[@type='button']");

    @Test
    void testZahra()  {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Zahra");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");

        Select select = new   Select(driver.findElement(By.xpath("//select[@id='options']")));
        select.selectByValue("it");

        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

        String alertPassword = driver.switchTo().alert().getText();
        System.out.println("password = " + alertPassword);


        String password = alertPassword.substring(alertPassword.indexOf(":") + 1).trim();
        System.out.println("Extracted password = " + password);
        driver.switchTo().alert().accept();


        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(password);
        prompt.accept();

        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();


    }
    @Test
    void testAli() {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(nameId).sendKeys("John Doe");
        driver.findElement(ageId).sendKeys("30");
        Select select = new Select(driver.findElement(selectID));
        select.selectByValue("it");
        driver.findElement(checkbox1value).click();
        driver.findElement(checkbox3value).click();
        driver.findElement(radioMale).click();
        driver.findElement(submitButton).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String passcode = alertText.substring(alertText.indexOf(":") +1).trim();
        System.out.println("Passcode is: " + passcode);
        alert.accept();
        alert.sendKeys(passcode);
        alert.accept();

        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();

    }
}
