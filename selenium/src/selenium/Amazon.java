package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("saima");
		Thread.sleep (3000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(1000);		
//	       driver.quit();


	}

}
