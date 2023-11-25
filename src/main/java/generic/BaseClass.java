package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.AddToCartPage;
import pom_Repo.HomePage;
import pom_Repo.ProductDescriptionPage;
import pom_Repo.ProductListPage;

public class BaseClass  implements FrameworkConstants{
	
	
	public static WebDriver driver;
	public HomePage hp;
	public ProductListPage plp;
	public ProductDescriptionPage pdp;
	public AddToCartPage ap;
	public WebDriverWait explicitWait;
	@Parameters("BrowserName")
	@BeforeClass
	public void openBrowser(@Optional("chrome")String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bname.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUTS_WAIT));
		driver.get(URL);
		
		 hp=new HomePage(driver);
		UtilityMethods um=new UtilityMethods(driver);
		um.verifyIfElementIsDisplayed(hp.getFlipkartLogo());
		explicitWait=new WebDriverWait(driver, Duration.ofSeconds(TIMEOUTS_WAIT));
	}
	@BeforeMethod
	public void closeLoginPopUp() {	
		explicitWait.until(ExpectedConditions.visibilityOf(hp.getLoginText()));
		
		//close login popup
		hp.getCloseIcon().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
	

}
