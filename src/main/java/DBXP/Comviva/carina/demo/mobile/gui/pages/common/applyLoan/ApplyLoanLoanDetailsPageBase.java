package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanLoanDetailsPageBase extends AbstractPage {

	public ApplyLoanLoanDetailsPageBase(WebDriver driver) {
		super(driver);
		
	}
	public abstract String getLoanDetailsText();

	public  abstract   void  clickOnBackButton();

	public  abstract  void ChooseLoanType( String loanType);

	public  abstract  String getCurrencyTypeText();

	public  abstract  void enterLoanAmount(String amount);

	public  abstract   String getCurrencyAmountErrorLabel();

	public  abstract ExtendedWebElement slideBarForTenure();

	public abstract   ExtendedWebElement selectedTenureField();

	public  abstract ExtendedWebElement emiTextField();

	public  abstract  ExtendedWebElement interestRate();

	public  abstract ExtendedWebElement youSaveTextField();

	public  abstract  ExtendedWebElement feesTestField();

	public  abstract  void clickOnEmiCalculatorButton();

	public  abstract  void clickOnproceedButton();




}
