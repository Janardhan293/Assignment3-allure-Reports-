package Testcases;

import ObjectRepo.Homepage;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.Common_Functions;



public class TC01PickDateTests extends Common_Functions {
    Logger log = Logger.getLogger(TC01PickDateTests.class.getName());
    Homepage homepage = null;

    @BeforeClass
    public void launchApp(){
        homepage = new Homepage(driver);
    }
    @Test(priority = 1)
    public void changeDate(){
        click(homepage.getDate_Picker(),"Date Picker");
        click(homepage.getDate(),"Date");
        click(homepage.getMoveToNextMonth(),"next");
        Actions a = new Actions(driver);
        a.doubleClick(homepage.getDate6()).perform();
        click(homepage.getFreeSpace(),"go back");
        log.info("date changed successfully");
    }
    @Test(priority = 2)
    public void changeTime() throws InterruptedException {
        click(homepage.getNextTime(),"time");
        click(homepage.getTime(),"time");
        click(homepage.getHh(),"hours ");
        Thread.sleep(2000);
        click(homepage.getKeyOne(),"1");
        click(homepage.getKeyOne(),"1");
        click(homepage.getMm(),"minutes");
        Thread.sleep(2000);
        click(homepage.getKeyFour(),"4");
        click(homepage.getKeySix(),"6");
        click(homepage.getFreeSpace(),"go back");
        click(homepage.getGoBack(),"back button");
        log.info("changed time successfully");
    }
}

