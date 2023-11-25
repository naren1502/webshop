package pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{
	public WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@FindBy(xpath = "//button[.='Place Order']")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//button[.='Enter Delivery Pincode']")
	private WebElement enterDeliverPincodeButton;

	@FindBy(xpath = "//div[contains(text(),'Flipkart')]")
	private WebElement flipkartTab;

	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}

	public WebElement getEnterDeliverPincodeButton() {
		return enterDeliverPincodeButton;
	}

	public WebElement getFlipkartTab() {
		return flipkartTab;
	}

	public WebElement getGroceryTab() {
		return groceryTab;
	}

	public WebElement getYourCartIsEmptyText() {
		return yourCartIsEmptyText;
	}

	public WebElement getShopNowButton() {
		return shopNowButton;
	}

	public WebElement getRemoveItemText() {
		return removeItemText;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getRemoveButton() {
		return removeButton;
	}

	public WebElement getSuccessfullyRemvedToasterMessage() {
		return successfullyRemvedToasterMessage;
	}

	@FindBy(xpath = "//div[contains(text(),'Grocery')]")
	private WebElement groceryTab;

	@FindBy(xpath = "//div[contains(text(),'Your cart is empty')]")
	private WebElement yourCartIsEmptyText;

	@FindBy(xpath = "//button[.='Shop now']")
	private WebElement shopNowButton;

	public WebElement productName(String productName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]"));
	}

	public WebElement removeBuuton(String productName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + productName
				+ "')]/../../../following-sibling::div/div/div[text()='Remove']"));
	}

	public WebElement saveForLaterButton(String productName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + productName
				+ "')]/../../../following-sibling::div/div/div[text()='Save for later']"));
	}

	// remove item

	@FindBy(xpath = "//div[text()='Remove Item']")
	private WebElement removeItemText;

	@FindBy(xpath = "//div[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement removeButton;

	// toaster message

	@FindBy(xpath = "//div[contains(text(),'Successfully removed')]")
	private WebElement successfullyRemvedToasterMessage;

}
