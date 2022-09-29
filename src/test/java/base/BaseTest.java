package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.Helper;

public class BaseTest {
	
	protected WebDriver driver = null;
	
	@BeforeClass
	protected void setUpEnvironment() {
		System.setProperty("webdriver.chrome.driver", Helper.getData("chromedriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Helper.getData("imdbUrl"));
	}

	@AfterClass
	protected void tearDown() {
		driver.quit();
	}

}
