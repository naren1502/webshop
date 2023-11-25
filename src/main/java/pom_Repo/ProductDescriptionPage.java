package pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends BasePage{
	public WebDriver driver;
	public ProductDescriptionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//button[text()='Buy Now']")
	private WebElement buyNowButton;

	@FindBy(xpath = "//button[text()='GO TO CART']")
	private WebElement goToCartButton;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getBuyNowButton() {
		return buyNowButton;
	}

	public WebElement getGoToCartButton() {
		return goToCartButton;
	}
	public WebElement productName(String productName) {
		return driver.findElement(By.xpath("//span[contains(text(),'" + productName + "')]"));
	}

}
