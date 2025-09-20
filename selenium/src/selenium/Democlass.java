package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Democlass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://plant-world-v2.web.app");
		
		System.out.println(driver.getTitle());
	}

}