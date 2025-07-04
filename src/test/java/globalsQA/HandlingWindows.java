package globalsQA;

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

public class HandlingWindows {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		driver.manage().window().maximize();
	}

	@Test
	public void newTabWindow() {
		driver.findElement(By.xpath(
				"//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//a[@class='button e.g. button_hilite button_pale small_button'][normalize-space()='Click Here']"))
				.click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("All Windows Id's :" + windowHandles);

		List<String> winHandle = new ArrayList(windowHandles);
		String parent = winHandle.get(0);
		String child = winHandle.get(1);

		// Switch to Child window
		driver.switchTo().window(child);
		System.out.println("This is Child Window : " + driver.getTitle());

		// Switch to Parent window
		driver.switchTo().window(parent);
		System.out.println("This is Parent Window : " + driver.getTitle());
	}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
