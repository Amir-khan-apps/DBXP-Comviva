package DBXP.Comviva.carina.demo.testUtils;


import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;


public abstract class TestSetUp  implements IAbstractTest,IMobileUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	public WebDriver driver;

	@BeforeTest
	public WebDriver setup() {

		LOGGER.info("----Before Method Started");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", R.CONFIG.get("capabilities.platformName"));
		caps.setCapability("deviceType", R.CONFIG.get("capabilities.deviceType"));
		caps.setCapability("appPackage", R.CONFIG.get("capabilities.appPackage"));
		caps.setCapability("appActivity", R.CONFIG.get("capabilities.appActivity"));
		driver = getDriver(DEFAULT,caps,"http://192.168.88.216:4723/wd/hub");
		return driver;
	}


}
