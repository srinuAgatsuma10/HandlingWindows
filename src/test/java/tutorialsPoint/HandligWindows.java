package tutorialsPoint;

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

	@Test(priority = 2)
	public void openNewWindow1() {
		// Click New Window button
		driver.findElement(By.xpath("//button[normalize-space()='New Window']")).click();

		Set<String> windows = driver.getWindowHandles();

		// Access all windows one by one
		List<String> tabs = new ArrayList(windows);
		String currentWindow = tabs.get(0);
		String newWindow = tabs.get(1);

		// Switch to New Window
		driver.switchTo().window(newWindow);
		System.out.println("This is new window : " + driver.getTitle());
		driver.close();

		// Switch to currentWindow window
		driver.switchTo().window(currentWindow);
		System.out.println("This is previous window : " + driver.getTitle());
	}

	@Test(priority = 3)
	public void openNewWindow2() {
		// Click New Window button
		driver.findElement(By.xpath("//button[normalize-space()='New Window Message']")).click();

		Set<String> windows = driver.getWindowHandles();

		// Access all windows one by one
		List<String> tabs = new ArrayList(windows);
		String currentWindow = tabs.get(0);
		String newWindow = tabs.get(1);

		// Switch to New Window
		driver.switchTo().window(newWindow);
		System.out.println("This is new window : " + driver.getTitle());
		WebElement message = driver
				.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
		System.out.println("New Window Message : " + message.getText());
		driver.close();

		// Switch to currentWindow window
		driver.switchTo().window(currentWindow);
		System.out.println("This is previous window : " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
