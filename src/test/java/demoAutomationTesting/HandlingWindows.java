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

	@Test(priority = 1)
	public void openNewTabWindow() {
		// Click
		driver.findElement(By.xpath(
				"//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']"))
				.click();
		Set<String> tabs = driver.getWindowHandles();
		System.out.println("Id's of current windows : " + tabs);

		// To access one by one convert into List
		List<String> tabList = new ArrayList(tabs);
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

	@Test(priority = 2)
	public void openNewWindow() {
		// Click
		driver.findElement(By.xpath("//a[normalize-space()='Open New Seperate Windows']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println("Id's of current windows : " + windows);

		List<String> winID = new ArrayList(windows);
		String currentWindow = winID.get(0);
		String newWindow = winID.get(1);

		// Switching to Current Window
		driver.switchTo().window(currentWindow);
		System.out.println("This is Child Window : " + driver.getTitle());

		// Switching to New Window
		driver.switchTo().window(newWindow);
		System.out.println("This is Parent Window : " + driver.getTitle());
		driver.close();

		driver.switchTo().window(currentWindow);
	}

	@Test(priority = 3)
	public void openMultipleWindow() {
		// Click
		driver.findElement(By.xpath("//a[normalize-space()='Open Seperate Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println("Id's of current windows : " + windows);

		List<String> winID = new ArrayList(windows);
		String currentWindow = winID.get(0);
		String newWindow1 = winID.get(1);
		String newWindow2 = winID.get(2);

		// Switching to Child Window
		driver.switchTo().window(newWindow1);
		System.out.println("This is new Window one : " + driver.getTitle());
		// Go to new window from child window one
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thundergod123@gmail.com");
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		System.out.println("This is new Window : " + driver.getTitle());

		// Switch to new Tab from child window two
		driver.switchTo().window(newWindow2);
		System.out.println("This is new Window two : " + driver.getTitle());

		// Switching to Parent Window
		driver.switchTo().window(currentWindow);
		System.out.println("This is Parent Window : " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
