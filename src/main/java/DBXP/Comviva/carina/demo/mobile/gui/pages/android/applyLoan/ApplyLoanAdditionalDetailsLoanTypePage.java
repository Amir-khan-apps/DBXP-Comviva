package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsAddressPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsLoanTypePageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanAdditionalDetailsLoanTypePageBase.class)
public class ApplyLoanAdditionalDetailsLoanTypePage extends ApplyLoanAdditionalDetailsLoanTypePageBase implements IMobileUtils {

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@FindBy(className = "android.widget.ImageButton")
	    private ExtendedWebElement backButton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Loan Details')]")
	private ExtendedWebElement LoanDetailsText;

	@FindBy(className = "android.widget.FrameLayout")
	private ExtendedWebElement loanTypeDropDown;

	@FindBy(className = "android.widget.CheckedTextView")
	private List<ExtendedWebElement> chooseLoanTypeDropDown;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/multiCurrencyAmountEdittext")
	private ExtendedWebElement enterLoanAmount;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/multiCurrencyLayout")
	private ExtendedWebElement selectAmountType;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/slider_tenure")
	private ExtendedWebElement slider_tenure;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/tv_selected_tenure")
	private ExtendedWebElement selected_tenure;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/tv_emi_calculator")
	private ExtendedWebElement emi_calculator;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement submit;

	public ApplyLoanAdditionalDetailsLoanTypePage(WebDriver driver) {
		super(driver);
		
	}

	public  void enterAmountLoan(String amount)
	{
		enterLoanAmount.type(amount);
	}

	public void ChooseOfLoanTypeDropDown(String loanType) {
		loanTypeDropDown.assertElementPresent(1000);
		loanTypeDropDown.click();
		LOGGER.info("selecting '" + loanType + "' loanType..");
		for (ExtendedWebElement loanTypeLink : chooseLoanTypeDropDown) {
			String currentLoanType = loanTypeLink.getText();
			LOGGER.info("loanType is : " + currentLoanType);
			if (loanType.equalsIgnoreCase(currentLoanType)) {
				loanTypeLink.click();
				break;
			}
		}
	}

	@Override
	public  String getLoanDetailsText()
	{
		return LoanDetailsText.getText();
	}
	@Override
	public void clickOnBackButton()
	{
		backButton.click();
	}

	@Override
	public ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase clickOnProceedButton()
	{
		swipe(submit, Direction.UP);

		submit.click();
		return  initPage(getDriver(),ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase.class);
	}

}
