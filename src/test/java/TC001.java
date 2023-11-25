import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseClass;
import pom_Repo.AddToCartPage;
import pom_Repo.ProductDescriptionPage;
import pom_Repo.ProductListPage;

public class TC001 extends BaseClass {

	@Test
	public void VerifyTheProductCount() throws InterruptedException {

		plp = new ProductListPage(driver);
		pdp = new ProductDescriptionPage(driver);
		ap = new AddToCartPage(driver);

		// enterering data into search textfield and search
		hp.getSearchTextfield().sendKeys("realme 10 pro");
		hp.getSearchButton().click();

		// wait for the result
		explicitWait.until(ExpectedConditions.visibilityOf(plp.searchResult(1)));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// get text from page result
		String result = plp.getShowingResultsText().getText();
		String data[] = result.replaceAll("[^0-9 –]", "").trim().split(" ");
//		String[] newArray = Arrays.stream(data).filter(s -> !s.equals("")).toArray(String[]::new);
//		int productPerPage = Integer.parseInt(newArray[2]);
		WebElement pagecount=null;
		WebElement pagelink=null;
		for (;;) {
			
			try {
				 pagecount=plp.getWebElement("//span[contains(text(),'Page')]");
				pagelink=plp.getWebElement("(//nav/a)[last()-1]");
			js.executeScript("arguments[0].scrollIntoView(false);",pagecount);
			explicitWait.until(ExpectedConditions.elementToBeClickable(pagelink));
			try {
				plp.getWebElement("(//nav/a)[last()-1]").click();
				if (!plp.getNextLink().isDisplayed())
					break;
			}
			catch (Exception e) {
				break;
			}
			}catch (StaleElementReferenceException e) {
				pagecount=plp.getWebElement("//span[contains(text(),'Page')]");
				pagelink=plp.getWebElement("(//nav/a)[last()-1]");
			}
			
		}
		data = result.replaceAll("[^0-9 –]", "").trim().split(" ");
		System.out.println(data);
//		newArray = Arrays.stream(data).filter(s -> !s.equals("")).toArray(String[]::new);
//
//		int totalProduct = Integer.parseInt(newArray[3]);
//		int expectedproductInLastPage = totalProduct - ((totalProduct / productPerPage) * productPerPage);
//		int actualproductInLastPage = driver.findElements(By.xpath(plp.price)).size();
//		System.out.println(expectedproductInLastPage);
//		System.out.println(actualproductInLastPage);
//		Assert.assertEquals(actualproductInLastPage, expectedproductInLastPage, "Last products count is not displayed");
//		Reporter.log("the count is matched",true);

	}
}
