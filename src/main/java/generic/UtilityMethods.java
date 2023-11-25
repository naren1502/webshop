package generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods implements FrameworkConstants {
	public WebDriver driver;

	public UtilityMethods(WebDriver driver) {
		this.driver = driver;
	}

	public String errorShots() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		String filePath = SCREENSHOT_PATH + name() + ".png";

		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(filePath));

		return filePath;
	}

	public String name() {
		LocalDateTime sysdate = LocalDateTime.now();
		return sysdate.toString().replace(":", "_");
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void enterInputIntoElement(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void clearTextandEnterInputIntoElement(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public String getTextFromElement(WebElement element) {
		return element.getText();
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void selectValuesByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectValuesByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectValuesByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCssValueOf(WebElement element, String attribute) {
		return element.getCssValue(attribute);
	}
	
	public void arrowDown() {
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ARROW_DOWN);
		actions.keyUp(Keys.ARROW_DOWN);
	}
	
	public void enter() {
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER);
		actions.keyUp(Keys.ENTER);
	}
	
	public boolean verifyIfElementIsDisplayed(WebElement element) {
	return	element.isDisplayed();
	}
	/***
	 * This method is used to generate the random number with the given limit
	 * @param min 
	 * @param max
	 * @return
	 */
	public int generateRandomNumberByGivenRange(int min,int max) {
		
		//min=100,max=115, Math.random() method will generate random number within 0.0 to 1.0
		return (int) Math.floor(Math.random()*(max-min+1)+min);//s
	}
	
	

}
