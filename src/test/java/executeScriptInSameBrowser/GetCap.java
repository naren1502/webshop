package executeScriptInSameBrowser;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCap {

	public static WebDriver driver;
	static String hostAddress;
	static ChromeOptions options;
	@BeforeSuite
	public void gethost() {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Capabilities cap = driver.getCapabilities();
		Map<String, Object> myCap = cap.asMap();

		String data = myCap.get("goog:chromeOptions").toString();
		hostAddress = data.substring(data.indexOf("=") + 1, data.length() - 1);

	}

	@BeforeClass
	public void initiate() {

		options.setExperimentalOption("debuggerAddress", hostAddress);
		driver = new ChromeDriver(options);

	}

	@Test(priority = 0)
	public void run() {
		driver.get("https://www.google.com/");
	}

	@Test(priority = 1)
	public void run1() {
		driver.get("https://www.amazon.in/");
	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}

}
