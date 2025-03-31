package automationBlogSpot;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingWindows {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void newTab() {
		// Click the button
		driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();

		Set<String> windows = driver.getWindowHandles();

		// To access one by one convert into List
		List<String> tabList = new ArrayList(windows);
		String parent = tabList.get(0);
		String child = tabList.get(1);

		// Switching to Child Window
		driver.switchTo().window(child);
		System.out.println("This is Child Window : " + driver.getTitle());
		driver.close();

		// Switching to Parent Window
		driver.switchTo().window(parent);
		System.out.println("This is Parent Window : " + driver.getTitle());
	}

	@Test
	public void popUpWindow() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
