package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.PageLoadStrategy;

import java.time.Duration;

public class YahooTest {
    // 🔹 Helper method for adding delay (in milliseconds)
    private static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.get("https://www.yahoo.com/");
            pause(1500); // Wait for page to stabilize

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1️⃣ Click "Sign in"
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[data-ylk*='slk:sign-in']")));
            signInButton.click();
            pause(2000);

            // 2️⃣ Enter placeholder username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("login-username")));
            usernameField.sendKeys("nabilasarkar131");
            pause(1500);

            // 3️⃣ Click "Next" after username
            WebElement nextButton1 = driver.findElement(By.id("login-signin"));
            nextButton1.click();
            pause(2000);

            // 4️⃣ Wait for password field and type dummy password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("login-passwd")));
            passwordField.sendKeys("16naBI*#...");
            pause(1500);

            // 5️⃣ Click "Next" after entering password
            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("login-signin")));
            nextButton2.click();
            pause(2000);

            System.out.println("✅ Password submitted and Next button clicked successfully.");

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            // driver.quit();
            // System.out.println("Browser closed.");
        }
    }
}