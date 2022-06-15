package DBXP.Comviva.carina.demo.mobile.gui.pages.android;

import DBXP.Comviva.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Web View']")
    private ExtendedWebElement webViewLink;


  

    @FindBy(className = "android.widget.ImageButton")
    private ExtendedWebElement leftMenuButton;

    public CarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

   /* @Override
    public WebViewPageBase navigateToWebViewPage() {
        leftMenuButton.click();
        webViewLink.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }
*/
}
