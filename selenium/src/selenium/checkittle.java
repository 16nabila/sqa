package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class checkittle {

	public static void main(String[] args) {
		
		  WebDriver driver = new ChromeDriver();
	        driver.get("https://www.w3schools.com/");

	        // Locate the heading element containing "Learn to Code"
	        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Learn to Code')]"));

	        // Get the text of the heading
	        String headingText = heading.getText();
	        System.out.println("Heading found: " + headingText);

	        // Compare and print result
	        if (headingText.contains("Learn to Code")) {
	            System.out.println("✅ Heading contains 'Learn to Code'!");
	        } else {
	            System.out.println("❌ Heading does not contain 'Learn to Code'. Found: " + headingText);
	        }

	}

}
