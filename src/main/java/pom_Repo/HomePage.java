package pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

//Login Popup

	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeIcon;

	@FindBy(xpath = "//form/div/input[not(@name)]")
	private WebElement emailTextfield;

	@FindBy(xpath = "//button[text()='Request OTP']")
	private WebElement requestOtpButton;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginText;

	@FindBy(linkText = "Create an account")
	private WebElement createAnAccountLink;

//Header

	@FindBy(xpath = "//img[@title='Flipkart']")
	private WebElement flipkartLogo;

	@FindBy(name = "q")
	private WebElement searchTextfield;

	@FindBy(xpath = "//button/*[local-name()='svg']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[text()='My Account']")
	private WebElement myAccountTab;

	@FindBy(xpath = "//div[text()='My Profile']")
	private WebElement myProfileLink;

	@FindBy(xpath = "//div[text()='SuperCoin Zone']")
	private WebElement superCoinZoneLink;

	@FindBy(xpath = "//div[text()='Flipkart Plus Zone']")
	private WebElement flipkartPlusZoneLink;

	@FindBy(xpath = "//div[text()='Orders']")
	private WebElement ordersLink;

	@FindBy(xpath = "//div[text()='Wishlist']")
	private WebElement wishlistLink;

	@FindBy(xpath = "//div[text()='Coupons']")
	private WebElement couponsLink;

	@FindBy(xpath = "//div[text()='Gift Cards']")
	private WebElement giftcardsLink;

	@FindBy(xpath = "//div[text()='Notifications']")
	private WebElement notificationsLink;

	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div/a[.='Become a Seller']")
	private WebElement becomeASeller;

	@FindBy(xpath = "//div[text()='More']")
	private WebElement moreLink;

	@FindBy(xpath = "//div[text()='Notification Preferences']")
	private WebElement notificationPreferencesLink;

	@FindBy(xpath = "//div[contains(text(),'24x7')]")
	private WebElement customerCareLink;

	@FindBy(xpath = "//div[contains(text(),'Advertise')]")
	private WebElement advertiseLink;

	@FindBy(xpath = "//div[contains(text(),'Download App')]")
	private WebElement downloadAppLink;

	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cartLink;

//@FindBy(xpath = "//span[text()='Electronics']")private WebElement electronicsTab;
//
//@FindBy(xpath = "//span[text()='TVs & Appliances']")private WebElement tvandAppliancesTab;
//
//@FindBy(xpath = "//span[text()='Men']")private WebElement menTab;
//
//@FindBy(xpath = "//span[text()='Women']")private WebElement womenTab;
//
//@FindBy(xpath = "//span[text()='Baby & Kids']")private WebElement babyandKidsTab;
//
//@FindBy(xpath = "//span[text()='Home & Furniture']")private WebElement homeandFurnitureTab;
//
//@FindBy(xpath = " //span[text()='Sports, Books & More']")private WebElement sportBookandMoreTab;
//
//@FindBy(linkText = "Flights")private WebElement filghtsTab;
//
//@FindBy(linkText = "Offer Zone")private WebElement offerZoneTab;

	@FindBy(xpath = "//div[text()='Grocery']")
	private WebElement groceryTab;

	@FindBy(xpath = "//div[text()='Mobiles']")
	private WebElement mobilesTab;

	@FindBy(xpath = "//div[text()='Fashion']")
	private WebElement fashionTab;

	@FindBy(xpath = "//div[text()='Electronics']")
	private WebElement electronicsTab;

	@FindBy(xpath = "//div[text()='Home']")
	private WebElement homeTab;

	@FindBy(xpath = "//div[text()='Appliances']")
	private WebElement appliancesTab;

	@FindBy(xpath = "//div[text()='Travel']")
	private WebElement travelTab;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFlipkartLogo() {
		return flipkartLogo;
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getMyAccountTab() {
		return myAccountTab;
	}

	public WebElement getMyProfileLink() {
		return myProfileLink;
	}

	public WebElement getSuperCoinZoneLink() {
		return superCoinZoneLink;
	}

	public WebElement getFlipkartPlusZoneLink() {
		return flipkartPlusZoneLink;
	}

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getCouponsLink() {
		return couponsLink;
	}

	public WebElement getGiftcardsLink() {
		return giftcardsLink;
	}

	public WebElement getNotificationsLink() {
		return notificationsLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBecomeASeller() {
		return becomeASeller;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getNotificationPreferencesLink() {
		return notificationPreferencesLink;
	}

	public WebElement getCustomerCareLink() {
		return customerCareLink;
	}

	public WebElement getAdvertiseLink() {
		return advertiseLink;
	}

	public WebElement getDownloadAppLink() {
		return downloadAppLink;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getGroceryTab() {
		return groceryTab;
	}

	public WebElement getMobilesTab() {
		return mobilesTab;
	}

	public WebElement getFashionTab() {
		return fashionTab;
	}

	public WebElement getElectronicsTab() {
		return electronicsTab;
	}

	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getAppliancesTab() {
		return appliancesTab;
	}

	public WebElement getTravelTab() {
		return travelTab;
	}

	public WebElement getTopOffersTab() {
		return topOffersTab;
	}

	public WebElement getBeautyToysandMoreTab() {
		return beautyToysandMoreTab;
	}

	public WebElement getTwoWheelersTab() {
		return twoWheelersTab;
	}

	@FindBy(xpath = "Top Offers")
	private WebElement topOffersTab;

	@FindBy(xpath = "//div[text()='Beauty, Toys & More']")
	private WebElement beautyToysandMoreTab;

	@FindBy(xpath = "//div[text()='Two Wheelers']")
	private WebElement twoWheelersTab;

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getRequestOtpButton() {
		return requestOtpButton;
	}

	public WebElement getLoginText() {
		return loginText;
	}

	public WebElement getCreateAnAccountLink() {
		return createAnAccountLink;
	}

	// dynamic xpaths
	public WebElement headerMinorTabs(String value) {
		String headerMinorTabs = "//a[text()=\"" + value + "\"]";
		return driver.findElement(By.xpath(headerMinorTabs));
	}

}
