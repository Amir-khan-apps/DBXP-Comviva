package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsAddressPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanProvideDocumentsPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanAdditionalDetailsAddressPageBase.class)
public class ApplyLoanAdditionalDetailsAddressPage extends ApplyLoanAdditionalDetailsAddressPageBase implements IMobileUtils {

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@FindBy(id = "com.comviva.applyloanfma.demo:id/header")
	    private ExtendedWebElement EnterYourAdditionalDetailsText;

	@FindBy(className = "android.widget.ImageButton")
	private ExtendedWebElement backButton;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/save_draft")
	private ExtendedWebElement SaveDraftButton;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/iv_edit_address")
	private ExtendedWebElement editAddressButton;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_address")
	private ExtendedWebElement editAddressTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/iv_edit_pincode")
	private ExtendedWebElement editPinCodeButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_pin_code")
	private ExtendedWebElement editPinCodeTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_city")
	private ExtendedWebElement cityTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_state")
	private ExtendedWebElement stateTextField;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/chk_current_address")
	private ExtendedWebElement thisIsMyCurrentAddressCheckBox;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement proceedButton;

	public ApplyLoanAdditionalDetailsAddressPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public ApplyLoanProvideDocumentsPageBase clickOnProceedButton()
	{
		proceedButton.click();
		return  initPage(getDriver(),ApplyLoanProvideDocumentsPageBase.class);
	}
	@Override
	public ExtendedWebElement MyCurrentAddressCheckBox()
	{
		return thisIsMyCurrentAddressCheckBox;
	}

	@Override
	public  ExtendedWebElement stateTextField()
	{
		return stateTextField;
	}

	@Override
	public  ExtendedWebElement cityTextField()
	{
		return cityTextField;
	}

	@Override
	public  String getEnterYourAdditionalDetailsText()
	{
		return EnterYourAdditionalDetailsText.getText();

	}

	@Override
	public void clickOnBackButton()
	{
		backButton.click();
	}

	@Override
	public void clickOnSaveDraftButton()
	{
		SaveDraftButton.click();
	}


	@Override
	public void clickOnEditAddressButton()
	{
		editAddressButton.click();
	}

	@Override
	public  void enterEditAddressTextField(String address)
	{
		editAddressTextField.type(address);
	}

	@Override
	public  void enterEditPinCodeTextField(String pinCode)
	{

		editPinCodeTextField.type(pinCode);
	}

	@Override
	public void clickOnEditPinCodeButton()
	{
		editPinCodeButton.click();
	}

}
