package DBXP.Comviva.carina.demo.mobile.gui.pages.common;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanPageBase;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public  abstract boolean isWelcomePageOpened();

    public abstract LoginPageBase clickOnLoginBTN();
    
    public abstract ApplyLoanPageBase clickOnApplyLoanBTN();
}
