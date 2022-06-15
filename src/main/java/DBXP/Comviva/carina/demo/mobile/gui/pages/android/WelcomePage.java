package DBXP.Comviva.carina.demo.mobile.gui.pages.android;


import DBXP.Comviva.carina.demo.helpers.Constants.TimeoutConstants;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.applyLoan.ApplyLoanPageBase;
import DBXP.Comviva.carina.demo.utils.IDbxpComvivaUIMethod;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.LoginPageBase;
import DBXP.Comviva.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase implements IDbxpComvivaUIMethod {

    @FindBy(id = "com.comviva.applyloanfma.demo:id/btnApplyLoan")
    private ExtendedWebElement applyLoan;

    @FindBy(id = "com.comviva.applyloanfma.demo:id/btnLoginCall")
    private ExtendedWebElement loginBTN;

    @FindBy(xpath = "//android.widget.ProgressBar")
    public ExtendedWebElement progressBar;

    @FindBy(xpath = "(//android.widget.ImageView)[last()]")
    private ExtendedWebElement bannerCloseButton;

    @FindBy(xpath = "//android.widget.Button[contains(@text, 'IGNORE')]")
    public ExtendedWebElement updateIgnoreButton;

    @FindBy(xpath = "//android.widget.TextView[@text='OK, GOT IT'] | //android.widget.TextView[@text='OKAY']")
    private ExtendedWebElement okGotItButton;

    public WelcomePage(WebDriver driver) {

        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(applyLoan);
    }

    public void checkAndCloseBanner() {
        if (bannerCloseButton.isVisible(TimeoutConstants.BANNER_WAIT_TIMEOUT)) {
            customClick(bannerCloseButton);
        } else {
            LOGGER.info("Banner pop is not displayed");
        }
    }

    public void tapOnIgnoreButton() {
        updateIgnoreButton.clickIfPresent(TimeoutConstants.UPDATE_ALERT_TIMEOUT);
    }

    public void tapOnAppAlertBtnButton() {
        //Adding the logger here, to explain the execution delay in the event the button is not present.
        LOGGER.info("Checking if ok Got It Button is present ...");
        okGotItButton.clickIfPresent(TimeoutConstants.LOADING_ICON_TIMEOUT);

    }

    public void customClick(ExtendedWebElement element){
        customClick(comviva_explicit_timeout,element);
    }
    public void customClick(Long timeout, ExtendedWebElement element){
        handledClick(timeout,element);
        waitToDisappear(progressBar);
    }


    @Override
    public boolean isWelcomePageOpened() {

        return applyLoan.isElementPresent();
    }

    @Override
    public LoginPageBase clickOnLoginBTN(){
        loginBTN.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
    
    @Override
    public ApplyLoanPageBase clickOnApplyLoanBTN(){
    	applyLoan.click();
        return initPage(getDriver(), ApplyLoanPageBase.class);
    }

    public void repeatedClickHandler(ExtendedWebElement element) {
        element.click(TimeoutConstants.PAGE_LOAD_TIMEOUT);
        waitToDisappear(progressBar);
        for(int i=0;element.isClickable(3)&&i<10;i++){
            element.click();
            waitToDisappear(progressBar);
        }
    }


}
