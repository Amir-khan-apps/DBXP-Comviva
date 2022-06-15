package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;


import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanLoanDetailsPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ApplyLoanLoanDetailsPageBase.class)
public class ApplyLoanLoanDetailsPage extends ApplyLoanLoanDetailsPageBase implements IMobileUtils {

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@FindBy(xpath ="//android.widget.TextView[text()='Loan Details']")
	    private ExtendedWebElement loanDetailsText;

	@FindBy(className = "android.widget.ImageButton")
	private ExtendedWebElement backButton;


	@FindBy(xpath = "//android.widget.EditText[text()='Choose Loan Type']")
	private ExtendedWebElement chooseLoanType;

	@FindBy(className = "android.widget.CheckedTextView")
	private List<ExtendedWebElement> loanTypeDropDown;

	@FindBy(xpath = "(//android.widget.RelativeLayout[@id='com.comviva.applyloanfma.demo:id/multiCurrencyLayout'])[3]")
	private ExtendedWebElement CurrencyType;

	@FindBy(xpath = "(//android.widget.RelativeLayout[@id='com.comviva.applyloanfma.demo:id/multiCurrencyLayout'])[5]")
	private ExtendedWebElement loanAmountFiled;

	@FindBy(xpath = "com.comviva.applyloanfma.demo:id/multiCurrencyAmountErrorLabel")
	private ExtendedWebElement multiCurrencyAmountErrorLabel;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/slider_tenure")
	private ExtendedWebElement seekBar;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/tv_selected_tenure")
	private ExtendedWebElement selectedTenureField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/emi_value")
	private ExtendedWebElement emiTextField;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/tv_emi_calculator")
	private ExtendedWebElement emiCalculatorButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/interest_rate")
	private ExtendedWebElement interestRate;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/fees")
	private ExtendedWebElement feesTestField;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/you_save")
	private ExtendedWebElement youSaveTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement proceedButton;



	public ApplyLoanLoanDetailsPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
		setUiLoadedMarker(loanDetailsText);
		
	}
	@Override
	public  void clickOnproceedButton()
	{
		proceedButton.click();
	}

	@Override
	public  void clickOnEmiCalculatorButton()
	{
		emiCalculatorButton.click();
	}

	@Override
	public ExtendedWebElement feesTestField()
	{
		return  feesTestField;
	}
	@Override
	public ExtendedWebElement youSaveTextField()
	{
		return  youSaveTextField;
	}

	@Override
	public ExtendedWebElement interestRate()
	{
		return  interestRate;
	}

	@Override
	public ExtendedWebElement emiTextField()
	{
		return  emiTextField;
	}

	@Override
	public  ExtendedWebElement selectedTenureField()
	{
		return selectedTenureField;
	}

   @Override
   public  ExtendedWebElement slideBarForTenure()
   {
	  return  seekBar;
   }


	@Override
	public  String getCurrencyAmountErrorLabel()
	{
		return  multiCurrencyAmountErrorLabel.getText();
	}

	   @Override
	    public String getLoanDetailsText() {
		return loanDetailsText.getText();
	    }

		@Override
	public  void  clickOnBackButton()
		{
			backButton.click();
		}

@Override
	public void ChooseLoanType( String loanType)
	{
		chooseLoanType.click();
		LOGGER.info("selecting '" + loanType + "' loanType..");
		for (ExtendedWebElement loanTypeLink : loanTypeDropDown) {
			String currentLoanType = loanTypeLink.getText();
			LOGGER.info("loanType is : " + currentLoanType);
			if (loanType.equalsIgnoreCase(currentLoanType)) {
				loanTypeLink.click();
				break;
			}
		}
	}



	@Override
	public  String getCurrencyTypeText()
	{
		return  CurrencyType.getText();
	}

	@Override
	public  void enterLoanAmount(String amount)
	{
		loanAmountFiled.type(amount);
	}
}
