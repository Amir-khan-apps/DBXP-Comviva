package DBXP.Comviva.carina.demo.mobile.gui.pages.android.applyLoan;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanProvideDocumentsPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanStatusPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ApplyLoanProvideDocumentsPageBase.class)
public class ApplyLoanProvideDocumentsPage extends ApplyLoanProvideDocumentsPageBase implements IMobileUtils {

	 @FindBy(className = "android.widget.ImageButton")
	    private ExtendedWebElement backButton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Provide Documents')]")
	private ExtendedWebElement bacProvideDocumentsText;


	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Upload Pay Slip')]")
	private ExtendedWebElement UploadPaySlip;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'ITR File')]")
	private ExtendedWebElement ITRFile;


	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Income Proof')]")
	private ExtendedWebElement IncomeProof;


	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Upload Employee ID')]")
	private ExtendedWebElement UploadEmployeeID;


	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Student ID')]")
	private ExtendedWebElement StudentID;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/submit")
	private ExtendedWebElement SubmitButton;

	@FindBy(xpath = "//android.widget.Button[contains(@text,'While using the app')]")
	private ExtendedWebElement conformationPopupsWhileUsingTheAppButton;

	@FindBy(xpath = "//android.widget.Button[contains(@text,'Only this time')]")
	private ExtendedWebElement conformationPopupsOnlyThisTimeButton;

	@FindBy(xpath = "//android.widget.Button[contains(@text,'Deny')]")
	private ExtendedWebElement conformationPopupsDenyButton;

	@FindBy(xpath = "//android.widget.Button[contains(@text,'Allow')]")
	private ExtendedWebElement conformationPopupsAllowButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/gallery")
	private ExtendedWebElement gallery;


	@FindBy(id = "com.comviva.applyloanfma.demo:id/mTxtSelectImage")
	private ExtendedWebElement hiddenPopupsSelectImageButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/mTxtSelectDocument")
	private ExtendedWebElement hiddenPopupsSelectDocumentButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/mTxtDismiss")
	private ExtendedWebElement hiddenPopupsDismissButton;

	@FindBy(id = "com.google.android.documentsui:id/icon_thumb")
	private ExtendedWebElement ImageFile;


	@FindBy(id = "com.android.permissioncontroller:id/permission_message")
	private ExtendedWebElement conformationPopupsText;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/menu_crop")
	private ExtendedWebElement menu_cropRightButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/deleteImageView")
	private ExtendedWebElement deleteImageViewButton;

	@FindBy(id = "com.comviva.applyloanfma.demo:id/selectImageView")
	private ExtendedWebElement selectImageViewButton;


	public ApplyLoanProvideDocumentsPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public  ApplyLoanStatusPageBase clickOnProceedButton()
	{
		SubmitButton.click();
		return  initPage(getDriver(), ApplyLoanStatusPageBase.class);
	}

	   @Override
	    public void uploadPaySlip() {
		   UploadPaySlip.click();
		   gallery.click();
		   hiddenPopupsSelectImageButton.click();
		  ImageFile.click();
		   menu_cropRightButton.click();
		   selectImageViewButton.click();
	    }

	@Override
	public void uploadEmployeeID() {
		UploadEmployeeID.click();
		conformationPopupsOnlyThisTimeButton.click();
		conformationPopupsAllowButton.click();
		gallery.click();
		hiddenPopupsSelectImageButton.click();
		ImageFile.click();
		menu_cropRightButton.click();
		selectImageViewButton.click();
	}

	@Override
	public  void uploadIncomeProof()
	{
		IncomeProof.click();
		conformationPopupsOnlyThisTimeButton.click();
		conformationPopupsAllowButton.click();
		gallery.click();
		hiddenPopupsSelectImageButton.click();
		ImageFile.click();
		menu_cropRightButton.click();
		selectImageViewButton.click();

	}

	@Override
	public void uploadStudentID() {
		StudentID.click();
		gallery.click();
		hiddenPopupsSelectImageButton.click();
		ImageFile.click();
		menu_cropRightButton.click();
		selectImageViewButton.click();
	}

	@Override
	public  void uploadITRFile()
	{
		ITRFile.click();
		conformationPopupsOnlyThisTimeButton.click();
		conformationPopupsAllowButton.click();
		gallery.click();
		hiddenPopupsSelectImageButton.click();
		ImageFile.click();
		menu_cropRightButton.click();
		selectImageViewButton.click();

	}

}
