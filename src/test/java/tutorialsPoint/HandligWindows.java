package tutorialsPoint;

import java.time.Duration;

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

	}

	@Test(priority = 2)
	public void openNewWindow1() {

	}

	@Test(priority = 3)
	public void openNewWindow2() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
