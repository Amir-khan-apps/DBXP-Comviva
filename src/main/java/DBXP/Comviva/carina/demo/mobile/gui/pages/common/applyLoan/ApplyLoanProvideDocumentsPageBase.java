package DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ApplyLoanProvideDocumentsPageBase extends AbstractPage {

	public ApplyLoanProvideDocumentsPageBase(WebDriver driver) {
		super(driver);
		
	}
	public abstract void uploadEmployeeID();

	public  abstract  void uploadPaySlip();

	public  abstract  ApplyLoanStatusPageBase clickOnProceedButton();

	public  abstract   void uploadIncomeProof();

	public  abstract void uploadStudentID();

	public  abstract void uploadITRFile();




}
