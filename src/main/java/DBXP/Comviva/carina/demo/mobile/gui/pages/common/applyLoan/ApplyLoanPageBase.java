package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsPageBase;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ApplyLoanPageBase  extends AbstractPage {

	public ApplyLoanPageBase(WebDriver driver) {
		super(driver);
		
	}
	public abstract void typePanNumber(String panNumber);

	public abstract void clikcOnCheckBox();

	public abstract  boolean verifyCheckBox();

	public  abstract ApplyLoanAdditionalDetailsPageBase clickOnProceedBTN();

	public  abstract  boolean  ckeckProceedButtonIsPresent();

	public  abstract  String  VerifyEnterDetailsPage();


}
