package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan.ApplyLoanAdditionalDetailsForPurposeOfLoanPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanAdditionalDetailsPageBase extends AbstractPage {

	public ApplyLoanAdditionalDetailsPageBase(WebDriver driver) {
		super(driver);
		
	}

	public  abstract  void chooseDropDownOption(String empType);

	public  abstract  void enterTheEmpName(String empDetails);

	public  abstract String  getYourAdditionalDetailsText();

	public  abstract void  clickOnBackButton();

	public  abstract  void enterCompanyName(String name);

	public  abstract  void enterLastYearsPatCurrency(String  currencyValue);

	public  abstract  void chooseCurrencyType( String currency);

	public  abstract  void enterQualification(String qualification);

	public  abstract  void enterCoBrowserName(String name);

	public  abstract  ApplyLoanAdditionalDetailsLoanTypePageBase clickOnProceedButton();

	public  abstract  void clickOnSaveDraftButton();

	public abstract void chooseProfessionType( String Profession);

	public  abstract void enterStartDateOfCurrentBusiness();







}
