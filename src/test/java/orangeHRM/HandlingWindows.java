package orangeHRM;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingWindows {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test
	public void handlinWindow() {
		// Login to Application
		logIN(driver);

		// Opening another window
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		// Accessing widow id's
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Id's of current windows: " + windows);
		// To access one by one we convert set to list
		List<String> winid = new ArrayList(windows);
		String parent = winid.get(0);
		String child = winid.get(1);
		// Accessing title of the window
		driver.switchTo().window(child);
		System.out.println("Child window: " + driver.getTitle()); // Child window title
		// Switch to parent window
		driver.switchTo().window(parent);
		System.out.println("Parent window: " + driver.getTitle()); // Parent window title

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void logIN(WebDriver driver) {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
