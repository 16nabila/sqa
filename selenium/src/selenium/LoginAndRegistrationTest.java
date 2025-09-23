package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAndRegistrationTest {

    public static void main(String[] args) {
        // ✅ Set ChromeDriver path (update with your actual path)


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // ✅ Load local HTML file dynamically
            String filePath = System.getProperty("user.home") + "/Downloads/index.html";
            driver.get("file:///" + filePath.replace("\\", "/"));

            // 2. Enter invalid User ID and Password for login
            WebElement userIdInput = driver.findElement(By.id("userId"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

            userIdInput.sendKeys("Admin");
            passwordInput.sendKeys("123");
            loginButton.click();

            // 3. Verify main page is visible
            WebElement mainPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainPage")));
            System.out.println("Login successful: main page is visible.");

            // 4. Click on the "Registration" menu
            WebElement registrationMenuButton = driver.findElement(By.xpath("//button[text()='Registration']"));
            registrationMenuButton.click();

            // 5. Fill out the registration form
            WebElement applicantNameInput = driver.findElement(By.id("applicantName"));
            WebElement applicantAddressInput = driver.findElement(By.id("applicantAddress"));
            WebElement applicantAgeInput = driver.findElement(By.id("applicantAge"));
            WebElement applicantMobileInput = driver.findElement(By.id("applicantMobile"));
            WebElement applicantInterestInput = driver.findElement(By.id("applicantInterest"));
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

            applicantNameInput.sendKeys("Mr. ABC");
            applicantAddressInput.sendKeys("Dhaka");
            applicantAgeInput.sendKeys("33");
            applicantMobileInput.sendKeys("017578579");
            applicantInterestInput.sendKeys("Music");
            submitButton.click();

            // 6. Verify the registration message
            WebElement registrationMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("registrationMessage"))
            );
            String messageText = registrationMessage.getText();

            if (messageText.equals("You are Registered into Blue Group")) {
                System.out.println("Test Passed: Registration message is as expected.");
            } else {
                System.out.println("Test Failed: Unexpected registration message: " + messageText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ✅ Close the driver properly
//            driver.quit();
        }
    }
}
