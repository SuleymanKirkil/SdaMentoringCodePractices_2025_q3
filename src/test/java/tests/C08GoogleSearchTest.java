package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class C08GoogleSearchTest {
static WebDriver driver;
@BeforeAll
public static void setUp() {
// TODO: Initialize static WebDriver
// TODO: Navigate to Google
}
@Test
public void searchMovies() {
String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};

for(String movie : movies) {
// TODO: Find search box
// TODO: Clear and enter movie name
// TODO: Submit search
// TODO: Get and print result count
// TODO: Clear search box for next iteration
}
}
@AfterAll
public static void tearDown() {
// TODO: Close driver
}
}