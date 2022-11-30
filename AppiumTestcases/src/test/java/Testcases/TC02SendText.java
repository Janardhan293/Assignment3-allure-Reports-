package Testcases;


import ObjectRepo.TextFields;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.Common_Functions;
;

public class TC02SendText extends Common_Functions{
    Logger log = Logger.getLogger(TC02SendText.class.getName());
    TextFields textFields = null;

    @BeforeClass
    public void launchBrowser() throws IllegalArgumentException{
        textFields = new TextFields(driver);
    }

    @Test(priority = 3)
    public void sendTextsToDefault() {
        click(textFields.getClickTextFields(),"text field");
        sendKeys(textFields.getDefaultTextField(),"Automation","Default");
        log.info("Successfully passed the data");
    }
}
