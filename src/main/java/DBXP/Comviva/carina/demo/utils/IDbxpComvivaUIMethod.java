package DBXP.Comviva.carina.demo.utils;

import DBXP.Comviva.carina.demo.helpers.Constants.TimeoutConstants;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Messager;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.text.DecimalFormat;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public interface IDbxpComvivaUIMethod extends IAbstractTest, IMobileUtils, ICustomTypePageFactory {

    Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    By bannerCloseButtonBy = By.xpath("(//android.widget.ImageView)[last()]");
    By appAlertsBy = By.xpath("//android.widget.TextView[contains(@text,'DISMISS')" +
            " or contains(@text,'OKAY')" +
            " or contains(@text,'NO')" +
            " or contains(@text,'OK, GOT IT')" +
            " or contains(@text,'ALLOW')" +
            " or contains(@text,'GO BACK')" +
            " or contains(@text,'NOT NOW')]");
    By btnByMarketing = By.xpath("//android.widget.Button[contains(@text,'DISMISS')" +
            " or contains(@text,'CLOSE')" +
            " or contains(@text,'PROCEED')]");
    By addressPopUpBy = By.xpath("//android.widget.TextView[@text = 'Choose from saved addresses']/following-sibling::android.widget.ScrollView/android.view.ViewGroup[1]");
    By serviceIssuePopUpBy =By.xpath("//android.widget.TextView[" +
            " contains(@text,'Please try again.')" +
            " or contains(@text,'services are not available')" +
            " or contains(@text,'Uh oh..')" +
            " or contains(@text,'Oops!')" +
            " or contains(@text,'Error!')" +
            "]");

    By tatSyncIssuesBy =By.xpath("//android.widget.TextView[@text = 'Out of stock']");
    DecimalFormat df = new DecimalFormat("0.00");
    Long comviva_explicit_timeout = Long.valueOf(R.CONFIG.get("explicit_timeout"));



    default String amountConversion(String amount){
        df.setMaximumFractionDigits(2);
        return df.format(Double.parseDouble(amount));
    }

    default void customElementAssert(ExtendedWebElement... elements){
        customElementAssert(comviva_explicit_timeout,elements);
    }

    default void customElementAssert(Long timeout, ExtendedWebElement... elements){
        WebDriver driver = elements[0].getDriver();
        DriverHelper assertHelper = new DriverHelper(driver);
        if(!assertHelper.isAnyElementPresent(timeout,elements)){
            if(dynamicElementHandlers(driver)){
                LOGGER.info("Handled  dynamically. trying again");
                assertHelper.isAnyElementPresent(elements);
            }
            else{
                LOGGER.warn("Dynamic element handlers didn't work");

                throw new NoSuchElementException(Messager.ELEMENT_NOT_PRESENT.getMessage(getElementsByMessage(elements)));
            }
        }
    }

    default void handleAddressPopup(WebDriver driver){
        handleAddressPopup(driver,TimeoutConstants.BANNER_WAIT_TIMEOUT);

    }

    default void handleAddressPopup(WebDriver driver,Long timeout){
        DriverHelper clickHelper = new DriverHelper(driver);
        handledClick(timeout,clickHelper.findExtendedWebElement(addressPopUpBy));
    }

    default String getElementsByMessage(ExtendedWebElement... elements){
        StringBuilder s= new StringBuilder();
        for (ExtendedWebElement element:elements) {
            s.append(element.getBy().toString());
        }
        return String.valueOf(s);
    }

    default void handledClick(Long timeout, ExtendedWebElement element) {
        try{
            element.click(timeout);
        }
        catch (NoSuchElementException | ElementNotSelectableException e){
            if(dynamicElementHandlers(element)){
                LOGGER.info("Handled "+e+" dynamically. trying again");
                element.click();
            }
            else{
                LOGGER.warn("Dynamic element handlers didn't work",e);
                throw e;
            }
        }
    }

    default boolean dynamicElementHandlers(ExtendedWebElement element){

        return dynamicElementHandlers(element.getDriver());
    }

    default void handleKnownIssues(WebDriver driver){
        DriverHelper issuesHelper = new DriverHelper(driver);
        // Known issues handlers. Check if some service dependency error has occurred.

        if (
                issuesHelper.findExtendedWebElement(serviceIssuePopUpBy,1)!=null||
                        issuesHelper.findExtendedWebElement(tatSyncIssuesBy,1)!=null
        ){
            LOGGER.warn("Underlying Service might be down Known issues found, check the logs");
        }
        else{
            LOGGER.info("No Known issues found");
        }
    }

    default boolean dynamicElementHandlers(WebDriver driver){

        LOGGER.info("Inside dynamic element handlers");
        handleKnownIssues(driver);
        return tapOnAppAlertBtn(driver) ||
                tapOnBannerCloseButton(driver)||
                tapOnButtonMarketing(driver);
    }


    default boolean tapOnBannerCloseButton(WebDriver driver){
        DriverHelper clickHelper = new DriverHelper(driver);

        ExtendedWebElement bannerCloseButton = clickHelper.findExtendedWebElement(bannerCloseButtonBy,1);

        if (bannerCloseButton!=null){
            LOGGER.info("Banner popup is displayed, Handling it dynamically.");
            handledClick(bannerCloseButton);
            return true;
        }
        return false;
    }

    default boolean tapOnAppAlertBtn(WebDriver driver){
        DriverHelper clickHelper = new DriverHelper(driver);

        ExtendedWebElement alertBtn = clickHelper.findExtendedWebElement(appAlertsBy,1);
        if(alertBtn!=null){
            LOGGER.info("App Alert button displayed, Handling it dynamically.");
            handledClick(alertBtn);
            return true;
        }
        return false;
    }

    default boolean tapOnButtonMarketing(WebDriver driver){
        DriverHelper clickHelper = new DriverHelper(driver);

        ExtendedWebElement marketingBtn = clickHelper.findExtendedWebElement(btnByMarketing,1);
        if(marketingBtn!=null){
            LOGGER.info(" Marketing button displayed, Handling it dynamically.");
            handledClick(marketingBtn);
            return true;
        }
        return false;
    }

    @Override
    default boolean swipe(ExtendedWebElement element, Direction direction) {
        if(!R.CONFIG.get("core_log_level").equalsIgnoreCase("info")){
            LOGGER.debug("Starting swipe test");
            getDriver().manage().window().getSize();
            LOGGER.debug("ending swipe Test");
        }
        return IMobileUtils.super.swipe(element,direction,20,1000);
    }

    default void handledClick(ExtendedWebElement element) {

        handledClick(comviva_explicit_timeout, element);
    }


    default void customSwipe(ExtendedWebElement element,Direction direction){
        swipe(element,direction);
        if (element.isVisible()){
            swipeUp(2,DEFAULT_TOUCH_ACTION_DURATION);
        }
    }

    public default void waitToDisappear(ExtendedWebElement element) {
        waitToDisappear(element,TimeoutConstants.LOADING_ICON_TIMEOUT,TimeoutConstants.PAGE_LOAD_TIMEOUT);
    }

    public default void waitToDisappear(ExtendedWebElement element, Long time1, Long time2){
        WebDriver driver = element.getDriver();
        DriverHelper appreanceHelper = new DriverHelper(driver);
        if (element.isPresent(time1))
        {
            LOGGER.info("Waiting for "+element.getBy().toString()+" to disappear");
            appreanceHelper.waitUntil(ExpectedConditions.invisibilityOfElementLocated(element.getBy()),time2);
            LOGGER.info(element.getBy().toString() + " loaded and disappear successfully");
        }
        else{
            LOGGER.warn(element.getBy().toString()+" didn't appear");
        }

    }


}
