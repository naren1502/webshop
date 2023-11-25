import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClass;
import generic.JavaUtility;

public class ScrollTillElementVisible extends BaseClass{
	
	@Test
	public void scroll() {
		JavaUtility js=new JavaUtility(driver);
		WebElement element = driver.findElement(By.xpath("//img/following-sibling::a[.='Become a Seller']"));
		js.scrollTillElementIsVisible(element);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
