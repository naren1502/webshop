

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	public static void main(String[] args) throws AWTException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		options.addExtensions(new File("C:\\Users\\venka\\Downloads\\Neotas-Extension.crx"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		driver.get("chrome://extensions/shortcuts");

		WebElement topLevelParent = driver.findElement(By.tagName("extensions-manager"));
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String str = "extensions-keyboard-shortcuts[class='active']";
		SearchContext shadowHost = topLevelParent.getShadowRoot();
		WebElement shadowElement = shadowHost.findElement(By.cssSelector(str));
		SearchContext nestedshadowhost = shadowElement.getShadowRoot();
		WebElement nestedShadowelement = nestedshadowhost
				.findElement(By.cssSelector("extensions-shortcut-input[readonly_]"));
		SearchContext nest = nestedShadowelement.getShadowRoot();
		WebElement nestelement = nest.findElement(By.cssSelector("cr-icon-button[id='edit']"));
		js.executeScript("arguments[0].click();", nestelement);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("Y").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
		driver.get("https://saas.neotas.com/");
		
		driver.findElement(By.name("username")).sendKeys("harsha.r@fireflink.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("signInSubmitButton")).click();
		
		//verification
		boolean isDisplayed=driver.findElement(By.xpath("//div[contains(text(),'View Cases')] ")).isDisplayed();
		Assert.assertEquals(isDisplayed, true,"Login sucessfully");
		
//		driver.findElement(By.xpath("//a[contains(text(),'FLINK-17')]")).click();
//		isDisplayed=driver.findElement(By.xpath("//span[contains(text(),'FLINK-17')]")).isDisplayed();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_Y);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_Y);
		Thread.sleep(5000);
		String parentid = driver.getWindowHandle();
		Set<String> allwindowid = driver.getWindowHandles();
		allwindowid.remove(parentid);
		for(String windowid:allwindowid)
			driver.switchTo().window(windowid);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	
	}

}