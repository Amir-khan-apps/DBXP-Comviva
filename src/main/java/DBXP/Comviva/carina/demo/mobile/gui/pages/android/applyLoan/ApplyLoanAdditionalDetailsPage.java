package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsLoanTypePageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanAdditionalDetailsPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static DBXP.Comviva.carina.demo.utils.Utils.extractOnlyAmountFromText;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanAdditionalDetailsPageBase.class)
public class ApplyLoanAdditionalDetailsPage extends ApplyLoanAdditionalDetailsPageBase implements IMobileUtils {

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@FindBy(xpath= "//*[contains(@class,'android.widget.EditText')]")
	    private ExtendedWebElement chooseEmpType;

	@FindBy(className = "android.widget.CheckedTextView")
	private List<ExtendedWebElement> dropDownOption;

	@FindBy(xpath ="//android.widget.TextView[@text='Enter your additional details']")
	private ExtendedWebElement enterYourAdditionalDetailsText;

	@FindBy(xpath ="//*[contains(@class,'android.widget.ImageButton')]")
	private ExtendedWebElement backButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edtGenericBox")
	private ExtendedWebElement lastEmployesTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edtCalendarBox")
	private ExtendedWebElement dateTextBox;

	@FindBy(id = "android:id/button1")
	private ExtendedWebElement dateOKButton;

	@FindBy(id = "android:id/button2")
	private ExtendedWebElement dateCancelButton;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/edtGenericBox")
	private ExtendedWebElement companyTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/currencyName")
	private ExtendedWebElement currencyName;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/edtCurrencyCombo")
	private ExtendedWebElement lastYearsPatCurrencyTextField;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/currencyName")
	private ExtendedWebElement currencyDropDown;

	@FindBy(className = "android.widget.TextView")
	private List<ExtendedWebElement> selectCurrency;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/choosecurrency_title_text")
	private ExtendedWebElement chooseCurrencyPopupsText;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Qualification')]")
	private ExtendedWebElement qualificationTextFiled;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/edtGenericBox")
	private List<ExtendedWebElement> coBrowserName;


	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Profession')]")
	private ExtendedWebElement ProfessionDropDown;


	@FindBy(className = "android.widget.CheckedTextView")
	private List<ExtendedWebElement> ChooseProfessionDropDown;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement proceedButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/save_draft")
	private ExtendedWebElement saveDraft;

	public ApplyLoanAdditionalDetailsPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public  void enterStartDateOfCurrentBusiness()
	{
		dateTextBox.click();
		dateOKButton.click();

	}

	@Override
	public  void clickOnSaveDraftButton()
	{
		saveDraft.click();

	}

	@Override
	public ApplyLoanAdditionalDetailsLoanTypePageBase clickOnProceedButton()
	{
		proceedButton.click();
		return  initPage(getDriver(),ApplyLoanAdditionalDetailsLoanTypePageBase.class);
	}

	@Override
	public  void enterCoBrowserName(String name)
	{
		ExtendedWebElement browser = coBrowserName.get(1);
		browser.type(name);
	}
	@Override
	public  void enterQualification(String qualification)
	{
		qualificationTextFiled.type(qualification);
	}
	@Override
	public void chooseDropDownOption( String empType)
	{
		chooseEmpType.assertElementPresent(1000);
	    chooseEmpType.click();
		LOGGER.info("selecting '" + empType + "' Employment..");
		for (ExtendedWebElement empLink : dropDownOption) {
			String currentEmployment = empLink.getText();
			LOGGER.info("currentEmployment is : " + currentEmployment);
			if (empType.equalsIgnoreCase(currentEmployment)) {
				empLink.click();
                break;
			}
		}
	}



   @Override
	public  void enterTheEmpName(String empDetails)
   {
	   lastEmployesTextField.type(empDetails);
   }

	@Override
	public  String getYourAdditionalDetailsText()
	{
       return  enterYourAdditionalDetailsText.getText();
	}



	@Override
	public  void clickOnBackButton()
	{
		backButton.click();
	}

	@Override
	public  void  enterCompanyName(String name)
	{
		companyTextField.type(name);
	}

	@Override
	public  void  enterLastYearsPatCurrency(String currencyValue)
	{
		lastYearsPatCurrencyTextField.type(currencyValue);
	}

	@Override
	public void chooseCurrencyType( String currency)
	{
		currencyDropDown.click();
		chooseCurrencyPopupsText.assertElementPresent();
		LOGGER.info("selecting '" + currency + "' currency Type..");
		for (ExtendedWebElement currencyLink :selectCurrency) {
			String currentCurrency = currencyLink.getText();
			LOGGER.info("currency  is : " + currentCurrency);
			if (currency.equalsIgnoreCase(currentCurrency)) {
				currencyLink.click();
				break;
			}
		}
	}


	@Override
	public void chooseProfessionType( String Profession)
	{
		ProfessionDropDown.assertElementPresent();
		ProfessionDropDown.click();
		LOGGER.info("selecting '" + Profession + "' Profession Type..");
		for (ExtendedWebElement ProfessionLink :ChooseProfessionDropDown) {
			String currentCurrency = ProfessionLink.getText();
			LOGGER.info("Profession  is : " + currentCurrency);
			if (Profession.equalsIgnoreCase(currentCurrency)) {
				ProfessionLink.click();
				break;
			}
		}
	}

}
