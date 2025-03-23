package demoAutomationTesting;

import java.time.Duration;

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
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void openNewTabWindow() {
		
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
