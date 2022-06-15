package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsAddressPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase;
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

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase.class)
public class ApplyLoanAdditionalDetailsForPurposeOfLoanPage extends ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase implements IMobileUtils {

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@FindBy(id = "com.comviva.applyloanfma.demo:id/header")
	    private ExtendedWebElement enterYourAdditionalDetailsText;

	@FindBy(className = "android.widget.FrameLayout")
	private ExtendedWebElement ChoosePurposeOfLoanDropDown;

	@FindBy(className = "android.widget.CheckedTextView")
	private List<ExtendedWebElement> selectDropDown;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_father_name")
	private ExtendedWebElement FatherNameTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edt_mother_name")
	private ExtendedWebElement MotherNameTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/proceed")
	private ExtendedWebElement proceedButton;

	@FindBy(className = "android.widget.ImageButton")
	private ExtendedWebElement backButton;


	@FindBy(className = "com.comviva.applyloanfma.demo:id/save_draft")
	private ExtendedWebElement SaveDraftButton;


	public ApplyLoanAdditionalDetailsForPurposeOfLoanPage(WebDriver driver) {
		super(driver);
		
	}
	@Override
	public  void clickOnBackButton()
	{
		backButton.click();
	}

	@Override
	public void ChoosePurposeOfLoanDropDown(String loanType) {
		ChoosePurposeOfLoanDropDown.click();
		LOGGER.info("selecting '" + loanType + "' loanType..");
		for (ExtendedWebElement loanTypeLink : selectDropDown) {
			String currentLoanType = loanTypeLink.getText();
			LOGGER.info("loanType is : " + currentLoanType);
			if (loanType.equalsIgnoreCase(currentLoanType)) {
				loanTypeLink.click();
				break;
			}
		}
	}

	@Override
	public  void clickOnSaveDraftButton()
	{
		proceedButton.click();
	}

	@Override
	public ApplyLoanAdditionalDetailsAddressPageBase clickOnProceedButton()
	{
		proceedButton.click();
		return  initPage(getDriver(),ApplyLoanAdditionalDetailsAddressPageBase.class);
	}

	@Override
	public  String getEnterYourAdditionalDetailsText()
	{
		return enterYourAdditionalDetailsText.getText();

	}

	@Override
	public void enterFatherNameTextField(String fatherName)
	{
		FatherNameTextField.type(fatherName);
	}

	@Override
	public void enterMotherNameTextField(String motherName)
	{
		MotherNameTextField.type(motherName);
	}



}
