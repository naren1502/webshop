package generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaUtility {
	public WebDriver driver;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public JavaUtility(WebDriver driver) {
		this.driver = driver;
	}

	

	public void click(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	public void enterInput(WebElement element, String data) {
		js.executeScript("arguments[0].value=" + data + ";", data);
	}
	
	public void clearData(WebElement element) {
		js.executeScript("arguments[0].value=\"\";", element);
	}
	
	public void ScrollBy(int x,int y) {
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public void scrollToView(boolean bool,WebElement element) {
		js.executeScript("arguments[0].scrollIntoView("+bool+");", element);
	}
	
	public void scrollToBottomPage() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}
	
	public void scrollTillElementIsVisible(WebElement element) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Rectangle position = element.getRect();
		int x=position.getX();
		int y=position.getY();
		js.executeScript("window.scrollBy(arguments[0],arguments[1])",x,y);
	}

}
