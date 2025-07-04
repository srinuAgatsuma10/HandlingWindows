package tutorialsPoint;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandligWindows {

	WebDriver driver;

	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void openNewTab() {
		// Click New Tab button
		driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		// Access all windows one by one
		List<String> tabs = new ArrayList(windows);
		String parent = tabs.get(0);
		String child = tabs.get(1);
		
		// Switch to child window
		driver.switchTo().window(child);
		System.out.println("This is child window : " + driver.getTitle());
		driver.close();
		
		// Switch to parent window
		driver.switchTo().window(parent);
		System.out.println("This is parent window : " + driver.getTitle());
	}

//	@Test(priority = 2)
	public void openNewWindow1() {

	}

//	@Test(priority = 3)
	public void openNewWindow2() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
