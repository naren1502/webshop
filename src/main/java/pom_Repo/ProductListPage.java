package pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {
	public WebDriver driver;

	public ProductListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Search

	public String SearchResult = "//div[contains(@data-tkid,'SEARCH')]/a[@title]|//div[contains(@data-tkid,'SEARCH')]/a/div[2]/div/div[not(text()='Free delivery')]";

	public WebElement searchResult(int productNo) {
		return driver.findElement(By.xpath(SearchResult + "[" + productNo + "]"));
	}

	public WebElement sortByTab(String option) {
		return driver.findElement(By.xpath("//span[text()='Sort By']/following-sibling::div[text()='" + option + "']"));
	}
	public String price="//a/div/div/div/div/div[contains(text(),'₹') and position()=1 and not(contains(text(),'No Cost'))]|//a/div/div[contains(text(),'₹') and position()=1]";
	
	public WebElement priceText(int index) {
		return driver.findElement(By.xpath(price + "[" + index + "]"));
	}
	
	@FindBy(xpath = "//span[contains(text(),'Page')]")private WebElement pageCountText;
	
	@FindBy(xpath = "(//nav/a)[last()-1]")private WebElement pageButton;
	
	@FindBy(xpath = "//span[text()='Next']")private WebElement nextLink;
	
	@FindBy(xpath = "//span[text()='Previous']")private WebElement previousLink;
	
	@FindBy(xpath = "//span[contains(text(),'results for')]")private WebElement showingResultsText;

	public WebElement getShowingResultsText() {
		return showingResultsText;
	}

	public WebElement getPageCountText() {
		return pageCountText;
	}

	public WebElement getPageButton() {
		return pageButton;
	}

	public WebElement getNextLink() {
		return nextLink;
	}

	public WebElement getPreviousLink() {
		return previousLink;
	}
	public WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	

}
