package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanStatusPageBase extends AbstractPage {

	public ApplyLoanStatusPageBase(WebDriver driver) {
		super(driver);
		
	}
	public abstract String getApplyLoanLabelText();

	public abstract String getApplicationNoText();


}
