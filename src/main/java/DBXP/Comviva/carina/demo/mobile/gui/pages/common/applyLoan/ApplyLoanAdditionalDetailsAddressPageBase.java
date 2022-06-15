package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanAdditionalDetailsAddressPageBase extends AbstractPage {

	public ApplyLoanAdditionalDetailsAddressPageBase(WebDriver driver) {
		super(driver);
		
	}

	public  abstract  String getEnterYourAdditionalDetailsText();

	public  abstract void clickOnBackButton();

	public  abstract void clickOnSaveDraftButton();

	public  abstract void clickOnEditAddressButton();

	public  abstract   void enterEditAddressTextField(String address);

	public  abstract  void clickOnEditPinCodeButton();

	public  abstract  void enterEditPinCodeTextField(String pinCode);

	public  abstract ExtendedWebElement cityTextField();

	public  abstract   ExtendedWebElement stateTextField();

	public  abstract ExtendedWebElement MyCurrentAddressCheckBox();

	public  abstract ApplyLoanProvideDocumentsPageBase clickOnProceedButton();






}
