package pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage{
	public WebDriver driver;
	public MyProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/div/div/div")private WebElement profileNameText;
	
	@FindBy(xpath = "//a[.='MY ORDERS']")private WebElement myOrdersLink;
	
	@FindBy(xpath = "//a[.='Profile Information']")private WebElement profileInformationLink;
	
	@FindBy(xpath = "//a[.='Manage Addresses']")private WebElement manageAddressesLink;
	
	@FindBy(xpath = "//a[.='PAN Card Information']")private WebElement panCardInformationLink;
	
	@FindBy(xpath = "//a[.='Gift Cards']")private WebElement giftCardsLink;
	
	@FindBy(xpath = "//a[.='Saved UPI']")private WebElement savedUPIlink;
	
	@FindBy(xpath = "//a[.='Saved Cards']")private WebElement savedCardsLink;
	
	@FindBy(xpath = "//a[.='My Coupons']")private WebElement myCouponsLink;
	
	@FindBy(xpath = "//a[.='My Reviews & Ratings']")private WebElement myReviewandRatingsLink;
	
	@FindBy(xpath = "//a[.='All Notifications']")private WebElement allNotificationsLink;
	
	@FindBy(xpath = "//a[.='My Wishlist']")private WebElement myWishlistLink;
	
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logoutLink;
	
	//profile information tabs
	
	public WebElement editLink(String titleName) {
		return driver.findElement(By.xpath("//span[text()='"+titleName+"']/following-sibling::*[text()='Edit']"));
	}
	//Cancel
	public WebElement cancelLink(String titleName) {
		return driver.findElement(By.xpath("//span[text()='"+titleName+"']/following-sibling::*[text()='cancel']"));
	}
	
	public WebElement saveButton(String titleName) {
		return driver.findElement(By.xpath("//span[text()='"+titleName+"']/../../form/div/button[text()='SAVE']"));
	}
	
	@FindBy(name = "firstName")private WebElement firstNameTextfield;
	
	@FindBy(name = "lastName")private WebElement lastNameTextfield;
	
	@FindBy(id = "Male")private WebElement maleRadioButton;
	
	@FindBy(id = "Female")private WebElement femaleRadioButton;
	
	@FindBy(name = "email")private WebElement emailAddressTextfield;
	
	@FindBy(name = "mobileNumber")private WebElement mobileNumberTextfield;
	
	@FindBy(xpath = "//div[text()='Deactivate Account']")private WebElement deactiveAccountLink;
	
	//manage addresses tab
	
	@FindBy(xpath = "//button[text()='ADD ADDRESSES']")private WebElement addAddressesButton;
	
	@FindBy(xpath = "//button[text()='Use my current location']")private WebElement useMyCurrentLocationButton;

	@FindBy(name = "name")private WebElement nametextfield;
	
	@FindBy(name = "phone")private WebElement phoneTextfield;
	
	@FindBy(name = "pincode")private WebElement pincodeTextfield;
	
	@FindBy(name = "addressLine2")private WebElement localityTextfield;
	
	@FindBy(name = "addressLine1")private WebElement addressTextAreafield;
	
	@FindBy(name = "city")private WebElement cityTextfield;
	
	@FindBy(name = "state")private WebElement stateDropdown;
	
	@FindBy(name = "landmark")private WebElement landmarkTextfield;
	
	@FindBy(name = "alternatePhone")private WebElement alternatePhoneTextfield;
	
	@FindBy(id = "HOME")private WebElement homeAddressAreaRadioButton;
	
	@FindBy(id = "WORK")private WebElement workAddressAreaRadioButton;
	
	@FindBy(xpath = "//button[text()='Save']")private WebElement saveButton;
	
	@FindBy(xpath = "//button[text()='Cancel']")private WebElement cancelButton;
	
	
	//Pancard information
	
	@FindBy(name = "pan")private WebElement pancardNumberTextfield;
	
	@FindBy(name = "fullName")private WebElement fullNameTextfield;
	
	@FindBy(name = "fileselect")private WebElement chooseFileButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")private WebElement iDoHereCheckbox;
	
	@FindBy(xpath = "//button[text()='UPLOAD']")private WebElement uploadButton;
	
	@FindBy(linkText = "Read Terms & Conditions of PAN Card Information")private WebElement termsandCOnditionOfPanLink;
	
	public WebElement getProfileNameText() {
		return profileNameText;
	}
	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}
	public WebElement getProfileInformationLink() {
		return profileInformationLink;
	}
	public WebElement getManageAddressesLink() {
		return manageAddressesLink;
	}
	public WebElement getPanCardInformationLink() {
		return panCardInformationLink;
	}
	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}
	public WebElement getSavedUPIlink() {
		return savedUPIlink;
	}
	public WebElement getSavedCardsLink() {
		return savedCardsLink;
	}
	public WebElement getMyCouponsLink() {
		return myCouponsLink;
	}
	public WebElement getMyReviewandRatingsLink() {
		return myReviewandRatingsLink;
	}
	public WebElement getAllNotificationsLink() {
		return allNotificationsLink;
	}
	public WebElement getMyWishlistLink() {
		return myWishlistLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}
	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}
	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}
	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}
	public WebElement getEmailAddressTextfield() {
		return emailAddressTextfield;
	}
	public WebElement getMobileNumberTextfield() {
		return mobileNumberTextfield;
	}
	public WebElement getDeactiveAccountLink() {
		return deactiveAccountLink;
	}
	public WebElement getAddAddressesButton() {
		return addAddressesButton;
	}
	public WebElement getUseMyCurrentLocationButton() {
		return useMyCurrentLocationButton;
	}
	public WebElement getNametextfield() {
		return nametextfield;
	}
	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}
	public WebElement getPincodeTextfield() {
		return pincodeTextfield;
	}
	public WebElement getLocalityTextfield() {
		return localityTextfield;
	}
	public WebElement getAddressTextAreafield() {
		return addressTextAreafield;
	}
	public WebElement getCityTextfield() {
		return cityTextfield;
	}
	public WebElement getStateDropdown() {
		return stateDropdown;
	}
	public WebElement getLandmarkTextfield() {
		return landmarkTextfield;
	}
	public WebElement getAlternatePhoneTextfield() {
		return alternatePhoneTextfield;
	}
	public WebElement getHomeAddressAreaRadioButton() {
		return homeAddressAreaRadioButton;
	}
	public WebElement getWorkAddressAreaRadioButton() {
		return workAddressAreaRadioButton;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}
	public WebElement getPancardNumberTextfield() {
		return pancardNumberTextfield;
	}
	public WebElement getFullNameTextfield() {
		return fullNameTextfield;
	}
	public WebElement getChooseFileButton() {
		return chooseFileButton;
	}
	public WebElement getiDoHereCheckbox() {
		return iDoHereCheckbox;
	}
	public WebElement getUploadButton() {
		return uploadButton;
	}
	public WebElement getTermsandCOnditionOfPanLink() {
		return termsandCOnditionOfPanLink;
	}
	
	
	
	

}
