package readCaptacha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Captacha {
	
	@Test
	public void readCaptacha() throws IOException, Exception {
		WebDriver driver=null;
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			
			 driver=new ChromeDriver(options);			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("https://www.irctc.co.in/nget/train-search");
			
			driver.findElement(By.partialLinkText("LOGIN")).click();
			Thread.sleep(2000);
			WebElement imageElement = driver.findElement(By.xpath("//div[@class='captcha_div']"));
			
			File src = imageElement.getScreenshotAs(OutputType.FILE);
			
			String path="./errorShots/captacha.png";
			
			FileHandler.copy(src, new File(path));
			
			
			Thread.sleep(2000);
			
			ITesseract image=new Tesseract();
			String str=image.doOCR(new File(path));
			System.out.println("image OCR done");
			System.out.println(str);
		} catch (Exception e) {
			System.out.println("exception ought "+e.getMessage());
		}
		driver.quit();
	}

}
