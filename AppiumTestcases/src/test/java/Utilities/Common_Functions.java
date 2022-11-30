package Utilities;
import Testcases.TC02SendText;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;


public class Common_Functions{

    public static IOSDriver<?> driver;
    Logger log = Logger.getLogger(TC02SendText.class.getName());

    @BeforeSuite
    public void appLaunch() throws MalformedURLException {
        driver = setUp();
        BasicConfigurator.configure();
        log.info("app launched successfully");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
    public IOSDriver setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/janardhan/Downloads/UIKitCatalog.app");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.1");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS, 3600);
        desiredCapabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new IOSDriver(remoteUrl, desiredCapabilities);
        return driver;
    }
    @Step("Passed {input} as a input to {eleName}")
    public void sendKeys(IOSElement element, String input,String eleName) {
        element.sendKeys(input);
    }
    @Step("clicked on {eleName}")
    public void click(IOSElement element,String eleName) {
        element.click();
    }
}