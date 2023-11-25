import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseClass;
import pom_Repo.AddToCartPage;
import pom_Repo.ProductDescriptionPage;
import pom_Repo.ProductListPage;

public class TC002 extends BaseClass{

	@Test
	public void verifyUserIsAbleToAddProductToCart() {
		plp=new ProductListPage(driver);
		pdp=new ProductDescriptionPage(driver);
		ap=new AddToCartPage(driver);
		
		//enterering data into search textfield and search
		hp.getSearchTextfield().sendKeys("glass");
		hp.getSearchButton().click();
		
		//wait for the result
		explicitWait.until(ExpectedConditions.visibilityOf(plp.searchResult(1)));
		
		//get text of product
		String productName = plp.searchResult(1).getText().replaceAll("\\.","").trim();
		
		//click on product
		plp.searchResult(1).click();
		
		//switch the window
		String parentwindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentwindowId);
		for(String windowId:allWindowId) {
			driver.switchTo().window(windowId);
		}
		
		//verify the product name
		System.out.println(productName);
		boolean visibleInPdp=pdp.productName(productName).isDisplayed();
		Assert.assertEquals(true, visibleInPdp,"Product name is mismatched");
		Reporter.log("product name is matched with fetched product name",true);
		
		//click on add to cart
		pdp.getAddToCartButton().click();
		
		explicitWait.until(ExpectedConditions.visibilityOf(ap.getPlaceOrderButton()));
		
		//verify product
		boolean visibleInCart=ap.productName(productName).isDisplayed();
		Assert.assertEquals(true, visibleInCart,"Product is failed to add to cart");
		Reporter.log("product is added successfully to the cart",true);
		
		
	}
}
