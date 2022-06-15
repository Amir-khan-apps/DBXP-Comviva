package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase extends AbstractPage {

	public ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase(WebDriver driver) {
		super(driver);
		
	}

	public  abstract  String getEnterYourAdditionalDetailsText();

	public  abstract void enterFatherNameTextField(String fatherName);

	public abstract  void enterMotherNameTextField(String motherName);

	public  abstract  ApplyLoanAdditionalDetailsAddressPageBase clickOnProceedButton();

	public  abstract  void clickOnSaveDraftButton();

	public  abstract  void clickOnBackButton();

	public  abstract void ChoosePurposeOfLoanDropDown( String loanType);






}
