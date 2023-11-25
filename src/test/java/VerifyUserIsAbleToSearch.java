import org.testng.annotations.Test;

import generic.BaseClass;

public class VerifyUserIsAbleToSearch extends BaseClass{

	
	@Test
	public void verifyUserIsAbleToSearch() {
		
		hp.getSearchTextfield().clear();
		hp.getSearchTextfield().sendKeys("realme");
		hp.getSearchButton().click();
		
	}
}
