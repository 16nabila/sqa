package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) {
        // Set path for ChromeDriver (update path as needed)
        //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Go to Amazon
            driver.get("https://www.amazon.com/");
            driver.manage().window().maximize();

            // 2. Click "Continue shopping" button
            WebElement continueShopping = driver.findElement(By.xpath("//button[@type='submit' and text()='Continue shopping']"));
            continueShopping.click();

            // 3. Find the search box and click
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.click();

            // 4. Write "samsung galaxy s25 ultra"
            searchBox.sendKeys("samsung galaxy s25 ultra");

            // 5. Click the search button
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            // Optional: wait to see results
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
