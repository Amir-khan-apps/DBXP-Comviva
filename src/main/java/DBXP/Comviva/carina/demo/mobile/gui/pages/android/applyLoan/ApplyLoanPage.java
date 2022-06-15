package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanPageBase.class)
public class ApplyLoanPage extends ApplyLoanPageBase implements IMobileUtils {

	 @FindBy(id = "com.comviva.applyloanfma.demo:id/acc_holder_pan_card_number")
	    private ExtendedWebElement panNumberInputField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/terms")
	private ExtendedWebElement checkBox;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement proceedBTN;

	@FindBy(xpath = "//android.widget.TextView[@text='Enter your details']")
	private ExtendedWebElement enterDetailsText;
//======================================================================

	@FindBy(id = "com.comviva.applyloanfma.demo:id/acc_holder_name")
	private ExtendedWebElement userNameField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/acc_holder_dob")
	private ExtendedWebElement dobField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/acc_holder_mobile_number")
	private ExtendedWebElement mobileNoField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/acc_holder_email_id")
	private ExtendedWebElement emailIDField;

	@FindBy(xpath = "//*[contains(@class,'android.widget.ImageButton')]")
	private ExtendedWebElement backButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Save Draft']")
	private ExtendedWebElement saveDraftButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/done")
	private ExtendedWebElement doneButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/message")
	private ExtendedWebElement draftMessage;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/title")
	private ExtendedWebElement draftTitle;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/termsTextView")
	private ExtendedWebElement termsTextView;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/textinput_error")
	private ExtendedWebElement panCardTextInput_error;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/iv_verify_check")
	private ExtendedWebElement panCardVerifyCheck;


	public ApplyLoanPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
		setUiLoadedMarker(panNumberInputField);
		
	}
	
	   @Override
	    public void typePanNumber(String panNumber) {
		   panNumberInputField.type(panNumber);
	        hideKeyboard();
	    }

	@Override
	public  void clikcOnCheckBox()
	{
		checkBox.click();
	}

	@Override
	public  boolean verifyCheckBox()
	{
		swipe(checkBox, Direction.UP);
		return checkBox.isChecked();
	}

	@Override
	public  ApplyLoanAdditionalDetailsPageBase clickOnProceedBTN()
	{
		proceedBTN.click();
		return initPage(getDriver(), ApplyLoanAdditionalDetailsPageBase.class);
	}

	@Override
	public  boolean  ckeckProceedButtonIsPresent()
	{
		   return proceedBTN.isChecked();

	}

	@Override
	public  String  VerifyEnterDetailsPage()
	{
		assertElementPresent(enterDetailsText);
		return enterDetailsText.getText();
	}




}
