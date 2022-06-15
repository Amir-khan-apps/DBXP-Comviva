package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;


import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanStatusPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ApplyLoanStatusPageBase.class)
public class ApplyLoanStatusPage extends ApplyLoanStatusPageBase implements IMobileUtils {

	 @FindBy(id = "com.comviva.applyloanfma.demo:id/apply_loan_done_label")
	    private ExtendedWebElement apply_loan_done_label;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/application_no")
	private ExtendedWebElement application_no;


	public ApplyLoanStatusPage(WebDriver driver) {
		super(driver);

		
	}
	
	   @Override
	    public String getApplyLoanLabelText() {

		return  apply_loan_done_label.getText();

	    }

	@Override
	public String getApplicationNoText() {

		return  application_no.getText();

	}





}
