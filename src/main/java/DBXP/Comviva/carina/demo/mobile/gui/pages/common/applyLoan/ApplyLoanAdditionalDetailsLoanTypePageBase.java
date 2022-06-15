package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanAdditionalDetailsLoanTypePageBase extends AbstractPage {

	public ApplyLoanAdditionalDetailsLoanTypePageBase(WebDriver driver) {
		super(driver);
		
	}

	public  abstract  void clickOnBackButton();

	public  abstract  ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase clickOnProceedButton();

	public  abstract   void ChooseOfLoanTypeDropDown(String loanType);

	public  abstract   void enterAmountLoan(String amount);

	public  abstract  String getLoanDetailsText();






}
