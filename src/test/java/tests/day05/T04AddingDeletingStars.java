package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T04AddingDeletingStars extends TestBase {
    
    //Go to https://claruswaysda.github.io/addDeleteStar.html
    //Create a method to add given number of stars
    //Create a method to delete given numbers of stars
    //Create a method to verify the given number of stars deleted
    String url = "https://claruswaysda.github.io/addDeleteStar.html";

    By addStarButtonById = By.id("push-button");
    By deleteStarButtonById = By.id("delete-button");
    By starsByXpath = By.xpath("//div[@class='star']");

    // Method to add stars
    void addStars3(int addNum) {
        WebElement addButton = driver.findElement(addStarButtonById);
        for (int i = 0; i < addNum; i++) {
            addButton.click();
        }
    }

    // Method to delete stars
    void deleteStars3(int deleteNum) {
        WebElement deleteButton = driver.findElement(deleteStarButtonById);
        for (int i = 0; i < deleteNum; i++) {
            deleteButton.click();
        }
    }

    // Method to verify remaining stars
    void verifyStarsAfterDeleted(int expectedCount) {
        List<WebElement> stars = driver.findElements(starsByXpath);
        Assertions.assertEquals(expectedCount, stars.size());
    }

    @Test
    void testAddDeleteStarsRahaf() {
        driver.get(url);
        int addedStars = 10;
        int deletedStars1 = 2;
        int deletedStar2 = 5;

        addStars3(addedStars);

        deleteStars3(deletedStars1);
        int expectedStars = addedStars-deletedStars1;
        verifyStarsAfterDeleted(expectedStars);

        deleteStars3(deletedStar2);
        expectedStars = expectedStars -deletedStar2;
        verifyStarsAfterDeleted(expectedStars);
    }
    By addButton = By.id("push-button");
    By deleteButton = By.id("delete-button");
    int addStarsNum = 10;
    int deleteStarsNum = 5;
    By stars = By.className("star");

    @Test
    void test04() {
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");
        addStars2(addStarsNum);
        deleteStars2(deleteStarsNum);
        int remainingStars = driver.findElements(stars).size();
        Assertions.assertEquals(addStarsNum-deleteStarsNum,remainingStars, "Not all stars were deleted. Remaining stars: " + remainingStars);
    }
    void addStars2(int numberOfStars){
        for(int i = 0 ; i < numberOfStars; i++){
            driver.findElement(addButton).click();
        }
    }
    void deleteStars2(int numberOfStars){
        for(int i = 0 ; i < numberOfStars; i++){
            driver.findElement(deleteButton).click();
        }
    }

    @Test
    void testShahd() throws InterruptedException {
        int numberOfStarsToAdd = 20;
        int numberOfStarsToDelete = 6;

        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

        addStars(numberOfStarsToAdd);
        deleteStars(numberOfStarsToDelete);
        verifyStarsDeleted(numberOfStarsToAdd - numberOfStarsToDelete);
    }

    void addStars(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.id("push-button")).click();
        }
    }

    void deleteStars(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.id("delete-button")).click();
        }
    }

    void verifyStarsDeleted(int expectedCount) {
        int actualCount = driver.findElements(By.className("star")).size();
        Assertions.assertEquals(expectedCount, actualCount);

    }

}
