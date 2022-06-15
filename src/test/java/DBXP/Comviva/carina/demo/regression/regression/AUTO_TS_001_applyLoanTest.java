package DBXP.Comviva.carina.demo.regression.regression;

import DBXP.Comviva.carina.demo.helpers.Constants.ApplyLoanConstant;
import DBXP.Comviva.carina.demo.helpers.Constants.Groups;
import DBXP.Comviva.carina.demo.mobile.gui.pages.android.WelcomePage;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.*;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.LoginPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import DBXP.Comviva.carina.demo.testUtils.TestSetUp;

import java.util.HashMap;

public class AUTO_TS_001_applyLoanTest extends TestSetUp  implements IAbstractTest {

    @Test(testName = "Verify the Apply Loan for Salaried Employed Type", dataProvider = "DataProvider",description = "JIRA#AUTO-TC-001", enabled = true, priority = 1,  groups = { Groups.REGRESSION,Groups.APPLYLOAN})
    @CsvDataSourceParameters(path = "xls/DBXP_Comviva_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO_TC_001")
    public void testApplyLoanForSalariedEmployedType_AUTO_TC_001(HashMap<String, String> args) {
        Reporter.log("TC_AUTO_TC_001 - Verify the Apply Loan for Salaried Employed Type", true);
        WelcomePageBase wp=new WelcomePage(driver);
        Assert.assertTrue(wp.isWelcomePageOpened(),"Welcome page is not open");
        LoginPageBase loginpaage = wp.clickOnLoginBTN();
        ApplyLoanPageBase applyLoan = wp.clickOnApplyLoanBTN();
        applyLoan.typePanNumber(args.get("PanCardNumber"));
        Assert.assertFalse(applyLoan.verifyCheckBox(),"Check Box is already checked ");
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        applyLoan.clikcOnCheckBox();
        ApplyLoanAdditionalDetailsPageBase empDetails = applyLoan.clickOnProceedBTN();
        Assert.assertEquals(empDetails.getYourAdditionalDetailsText(),"Enter your additional details");
        empDetails.chooseDropDownOption(ApplyLoanConstant.Employment_Type_SALARIED);
        empDetails.enterTheEmpName(args.get("EmployerName"));
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        empDetails.chooseCurrencyType(ApplyLoanConstant.Currency_LAK_₭);
        empDetails.enterLastYearsPatCurrency(args.get("LastYearPat"));
        ApplyLoanAdditionalDetailsLoanTypePageBase loanTypePage = empDetails.clickOnProceedButton();
        Assert.assertEquals(loanTypePage.getLoanDetailsText(),"Loan Details");
        loanTypePage.ChooseOfLoanTypeDropDown(ApplyLoanConstant.Loan_Type_Personal);
        loanTypePage.enterAmountLoan(args.get("LoanAmount"));
        ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase loanType = loanTypePage.clickOnProceedButton();
        Assert.assertEquals(loanType.getEnterYourAdditionalDetailsText(),"Enter your additional details");
        loanType.ChoosePurposeOfLoanDropDown(ApplyLoanConstant.Purpose_Of_Loan_Personal);
        loanType.enterFatherNameTextField(args.get("FatherName"));
        loanType.enterMotherNameTextField(args.get("MotherName"));
        ApplyLoanAdditionalDetailsAddressPageBase addressPage = loanType.clickOnProceedButton();
        addressPage.clickOnEditAddressButton();
        addressPage.enterEditAddressTextField(args.get("Address"));
        //addressPage.clickOnEditPinCodeButton();
       // addressPage.enterEditPinCodeTextField(args.get("PinCode"));
        ApplyLoanProvideDocumentsPageBase documentsPage = addressPage.clickOnProceedButton();
        documentsPage.uploadEmployeeID();
        documentsPage.uploadPaySlip();
        ApplyLoanStatusPageBase status = documentsPage.clickOnProceedButton();
        status.getApplicationNoText();
        Reporter.log("Your Loan Application Number IS: "+ status.getApplicationNoText(), true);
        Assert.assertEquals(status.getApplyLoanLabelText(),"Your request for loan is sent Successfully");

    }

    @Test(testName = "Verify the Apply Loan for Retired Employed Type", dataProvider = "DataProvider",description = "JIRA#AUTO-TC-002", enabled = true, priority = 2,  groups = { Groups.REGRESSION,Groups.APPLYLOAN})
    @CsvDataSourceParameters(path = "xls/DBXP_Comviva_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO_TC_002")
    public void testApplyLoanForRetiredEmployedType_AUTO_TC_002(HashMap<String, String> args) {
        Reporter.log("TC_AUTO_TC_002 - Verify the Apply Loan for Retired Employed Type", true);
        WelcomePageBase wp = new WelcomePage(driver);
        Assert.assertTrue(wp.isWelcomePageOpened(), "Welcome page is not open");
        LoginPageBase loginpaage = wp.clickOnLoginBTN();
        ApplyLoanPageBase applyLoan = wp.clickOnApplyLoanBTN();
        applyLoan.typePanNumber(args.get("PanCardNumber"));
        Assert.assertFalse(applyLoan.verifyCheckBox(), "Check Box is already checked ");
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(), "Proceed Button is Present");
        applyLoan.clikcOnCheckBox();
        ApplyLoanAdditionalDetailsPageBase empDetails = applyLoan.clickOnProceedBTN();
        Assert.assertEquals(empDetails.getYourAdditionalDetailsText(), "Enter your additional details");
        empDetails.chooseDropDownOption(ApplyLoanConstant.Employment_Type_RETIRED);
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        empDetails.enterTheEmpName(args.get("EmployerName"));
        ApplyLoanAdditionalDetailsLoanTypePageBase loanTypePage = empDetails.clickOnProceedButton();
        Assert.assertEquals(loanTypePage.getLoanDetailsText(),"Loan Details");
        loanTypePage.ChooseOfLoanTypeDropDown(ApplyLoanConstant.Loan_Type_Business);
        loanTypePage.enterAmountLoan(args.get("LoanAmount"));
        ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase loanType = loanTypePage.clickOnProceedButton();
        Assert.assertEquals(loanType.getEnterYourAdditionalDetailsText(),"Enter your additional details");
        loanType.ChoosePurposeOfLoanDropDown(ApplyLoanConstant.Purpose_Of_Loan_Others);
        loanType.enterFatherNameTextField(args.get("FatherName"));
        loanType.enterMotherNameTextField(args.get("MotherName"));
        ApplyLoanAdditionalDetailsAddressPageBase addressPage = loanType.clickOnProceedButton();
        addressPage.clickOnEditAddressButton();
        addressPage.enterEditAddressTextField(args.get("Address"));
        ApplyLoanProvideDocumentsPageBase documentsPage = addressPage.clickOnProceedButton();
        documentsPage.uploadIncomeProof();
        ApplyLoanStatusPageBase status = documentsPage.clickOnProceedButton();
        status.getApplicationNoText();
        Reporter.log("Your Loan Application Number IS: "+ status.getApplicationNoText(), true);
        Assert.assertEquals(status.getApplyLoanLabelText(),"Your request for loan is sent Successfully");
    }


    @Test(testName = "Verify the Apply Loan for Student Employed Type", dataProvider = "DataProvider",description = "JIRA#AUTO-TC-003", enabled = true, priority = 3,  groups = { Groups.REGRESSION,Groups.APPLYLOAN})
    @CsvDataSourceParameters(path = "xls/DBXP_Comviva_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO_TC_003")
    public void testApplyLoanForStudentEmployedType_AUTO_TC_003(HashMap<String, String> args) {
        Reporter.log("TC_AUTO_TC_003 - Verify the Apply Loan for Student Employed Type", true);
        WelcomePageBase wp = new WelcomePage(driver);
        Assert.assertTrue(wp.isWelcomePageOpened(), "Welcome page is not open");
        LoginPageBase loginpaage = wp.clickOnLoginBTN();
        ApplyLoanPageBase applyLoan = wp.clickOnApplyLoanBTN();
        applyLoan.typePanNumber(args.get("PanCardNumber"));
        Assert.assertFalse(applyLoan.verifyCheckBox(), "Check Box is already checked ");
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(), "Proceed Button is Present");
        applyLoan.clikcOnCheckBox();
        ApplyLoanAdditionalDetailsPageBase empDetails = applyLoan.clickOnProceedBTN();
        Assert.assertEquals(empDetails.getYourAdditionalDetailsText(), "Enter your additional details");
        empDetails.chooseDropDownOption(ApplyLoanConstant.Employment_Type_STUDENT);
        empDetails.enterQualification(args.get("Qualification"));
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        empDetails.enterCoBrowserName(args.get("CoBrowserName"));
        empDetails.enterLastYearsPatCurrency(args.get("LastYearPat"));
        ApplyLoanAdditionalDetailsLoanTypePageBase loanTypePage = empDetails.clickOnProceedButton();
        Assert.assertEquals(loanTypePage.getLoanDetailsText(),"Loan Details");
        loanTypePage.ChooseOfLoanTypeDropDown(ApplyLoanConstant.Loan_Type_Home);
        loanTypePage.enterAmountLoan(args.get("LoanAmount"));
        ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase loanType = loanTypePage.clickOnProceedButton();
        Assert.assertEquals(loanType.getEnterYourAdditionalDetailsText(),"Enter your additional details");
        loanType.ChoosePurposeOfLoanDropDown(ApplyLoanConstant.Purpose_Of_Loan_Others);
        loanType.enterFatherNameTextField(args.get("FatherName"));
        loanType.enterMotherNameTextField(args.get("MotherName"));
        ApplyLoanAdditionalDetailsAddressPageBase addressPage = loanType.clickOnProceedButton();
        addressPage.clickOnEditAddressButton();
        addressPage.enterEditAddressTextField(args.get("Address"));
        ApplyLoanProvideDocumentsPageBase documentsPage = addressPage.clickOnProceedButton();
        documentsPage.uploadIncomeProof();
        documentsPage.uploadStudentID();
        ApplyLoanStatusPageBase status = documentsPage.clickOnProceedButton();
        status.getApplicationNoText();
        Reporter.log("Your Loan Application Number IS: "+ status.getApplicationNoText(), true);
        Assert.assertEquals(status.getApplyLoanLabelText(),"Your request for loan is sent Successfully");
    }


    @Test(testName = "Verify the Apply Loan for Business Owner Employed Type", dataProvider = "DataProvider",description = "JIRA#AUTO-TC-004", enabled = true, priority = 4,  groups = { Groups.REGRESSION,Groups.APPLYLOAN})
    @CsvDataSourceParameters(path = "xls/DBXP_Comviva_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO_TC_004")
    public void testApplyLoanForBusinessOwnerEmployedType_AUTO_TC_004(HashMap<String, String> args) {
        Reporter.log("TC_AUTO_TC_004 - Verify the Apply Loan for Business Owner Employed Type", true);
        WelcomePageBase wp = new WelcomePage(driver);
        Assert.assertTrue(wp.isWelcomePageOpened(), "Welcome page is not open");
        LoginPageBase loginpaage = wp.clickOnLoginBTN();
        ApplyLoanPageBase applyLoan = wp.clickOnApplyLoanBTN();
        applyLoan.typePanNumber(args.get("PanCardNumber"));
        Assert.assertFalse(applyLoan.verifyCheckBox(), "Check Box is already checked ");
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(), "Proceed Button is Present");
        applyLoan.clikcOnCheckBox();
        ApplyLoanAdditionalDetailsPageBase empDetails = applyLoan.clickOnProceedBTN();
        Assert.assertEquals(empDetails.getYourAdditionalDetailsText(), "Enter your additional details");
        empDetails.chooseDropDownOption(ApplyLoanConstant.Employment_Type_BUSINESS_OWNER);
        empDetails.enterStartDateOfCurrentBusiness();
        empDetails.enterTheEmpName(args.get("CompanyName"));
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        empDetails.chooseCurrencyType(ApplyLoanConstant.Currency_THB_฿);
        empDetails.enterLastYearsPatCurrency(args.get("LastYearPat"));
        ApplyLoanAdditionalDetailsLoanTypePageBase loanTypePage = empDetails.clickOnProceedButton();
        Assert.assertEquals(loanTypePage.getLoanDetailsText(),"Loan Details");
        loanTypePage.ChooseOfLoanTypeDropDown(ApplyLoanConstant.Loan_Type_Gold);
        loanTypePage.enterAmountLoan(args.get("LoanAmount"));
        ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase loanType = loanTypePage.clickOnProceedButton();
        Assert.assertEquals(loanType.getEnterYourAdditionalDetailsText(),"Enter your additional details");
        loanType.ChoosePurposeOfLoanDropDown(ApplyLoanConstant.Purpose_Of_Loan_Others);
        loanType.enterFatherNameTextField(args.get("FatherName"));
        loanType.enterMotherNameTextField(args.get("MotherName"));
        ApplyLoanAdditionalDetailsAddressPageBase addressPage = loanType.clickOnProceedButton();
        addressPage.clickOnEditAddressButton();
        addressPage.enterEditAddressTextField(args.get("Address"));
        ApplyLoanProvideDocumentsPageBase documentsPage = addressPage.clickOnProceedButton();
        documentsPage.uploadITRFile();
        ApplyLoanStatusPageBase status = documentsPage.clickOnProceedButton();
        status.getApplicationNoText();
        Reporter.log("Your Loan Application Number IS: "+ status.getApplicationNoText(), true);
        Assert.assertEquals(status.getApplyLoanLabelText(),"Your request for loan is sent Successfully");

    }

    @Test(testName = "Verify the Apply Loan for Self Employed Employed Type", dataProvider = "DataProvider",description = "JIRA#AUTO-TC-005", enabled = true, priority = 5,  groups = { Groups.REGRESSION,Groups.APPLYLOAN})
    @CsvDataSourceParameters(path = "xls/DBXP_Comviva_App_Data.csv", dsUid = "TestCaseID", executeColumn = "TestCaseID", executeValue = "AUTO_TC_005")
    public void testApplyLoanForSelfEmployedEmployedType_AUTO_TC_004(HashMap<String, String> args) {
        Reporter.log("TC_AUTO_TC_005 - Verify the Apply Loan for Self Employed Employed Type", true);
        WelcomePageBase wp = new WelcomePage(driver);
        Assert.assertTrue(wp.isWelcomePageOpened(), "Welcome page is not open");
        LoginPageBase loginpaage = wp.clickOnLoginBTN();
        ApplyLoanPageBase applyLoan = wp.clickOnApplyLoanBTN();
        applyLoan.typePanNumber(args.get("PanCardNumber"));
        Assert.assertFalse(applyLoan.verifyCheckBox(), "Check Box is already checked ");
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(), "Proceed Button is Present");
        applyLoan.clikcOnCheckBox();
        ApplyLoanAdditionalDetailsPageBase empDetails = applyLoan.clickOnProceedBTN();
        Assert.assertEquals(empDetails.getYourAdditionalDetailsText(), "Enter your additional details");
        empDetails.chooseDropDownOption(ApplyLoanConstant.Employment_Type_SELF_EMPLOYED);
        empDetails.enterStartDateOfCurrentBusiness();
        empDetails.enterTheEmpName(args.get("CompanyName"));
        Assert.assertFalse(applyLoan.ckeckProceedButtonIsPresent(),"Proceed Button is Present");
        empDetails.enterLastYearsPatCurrency(args.get("LastYearPat"));
        empDetails.chooseProfessionType(ApplyLoanConstant.Emp_Profession_CA);
        ApplyLoanAdditionalDetailsLoanTypePageBase loanTypePage = empDetails.clickOnProceedButton();
        Assert.assertEquals(loanTypePage.getLoanDetailsText(),"Loan Details");
        loanTypePage.ChooseOfLoanTypeDropDown(ApplyLoanConstant.Loan_Type_Car);
        loanTypePage.enterAmountLoan(args.get("LoanAmount"));
        ApplyLoanAdditionalDetailsForPurposeOfLoanPageBase loanType = loanTypePage.clickOnProceedButton();
        Assert.assertEquals(loanType.getEnterYourAdditionalDetailsText(),"Enter your additional details");
        loanType.ChoosePurposeOfLoanDropDown(ApplyLoanConstant.Purpose_Of_Loan_Others);
        loanType.enterFatherNameTextField(args.get("FatherName"));
        loanType.enterMotherNameTextField(args.get("MotherName"));
        ApplyLoanAdditionalDetailsAddressPageBase addressPage = loanType.clickOnProceedButton();
        addressPage.clickOnEditAddressButton();
        addressPage.enterEditAddressTextField(args.get("Address"));
        ApplyLoanProvideDocumentsPageBase documentsPage = addressPage.clickOnProceedButton();
        documentsPage.uploadITRFile();
        ApplyLoanStatusPageBase status = documentsPage.clickOnProceedButton();
        status.getApplicationNoText();
        Reporter.log("Your Loan Application Number IS: "+ status.getApplicationNoText(), true);
        Assert.assertEquals(status.getApplyLoanLabelText(),"Your request for loan is sent Successfully");


    }

}

