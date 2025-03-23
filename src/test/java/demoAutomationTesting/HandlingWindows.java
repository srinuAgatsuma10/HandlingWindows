package demoAutomationTesting;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void openNewTabWindow() {
		// Click
		driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']")).click();
		Set<String> tabs = driver.getWindowHandles();
		System.out.println("Id's of current windows : "+tabs);
		
		// To access one by one convert into List
		List<String> tabList = new ArrayList(tabs);
		String parent = tabList.get(0);
		String child = tabList.get(1);
		
		// Switching to Child Window
		driver.switchTo().window(child);
		System.out.println("This is Child Window : "+driver.getTitle());
		
		// Switching to Parent Window
		driver.switchTo().window(parent);
		System.out.println("This is Parent Window : "+driver.getTitle());
	}
	
	@Test(priority=2)
	public void openNewWindow() {
		
	}
	
	@Test(priority=3)
	public void openMultipleWindow() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
