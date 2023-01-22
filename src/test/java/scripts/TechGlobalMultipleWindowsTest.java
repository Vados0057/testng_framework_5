package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalMultipleWindowsPage;
import utilities.Waiter;

public class TechGlobalMultipleWindowsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalMultipleWindowsPage = new TechGlobalMultipleWindowsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Multiple Windows");
    }

    @Test(priority = 1, description = "Validate the Apple link")
    public void validateTheAppleLink(){
        Waiter.pause(2);
        //Before clicking on Apple link
        String mainWindow = driver.getWindowHandle();
        techGlobalMultipleWindowsPage.links.get(0).click();
        Waiter.pause(5);

        for (String windowId: driver.getWindowHandles()) {
            if (!windowId.equals(mainWindow)){
                driver.switchTo().window(windowId);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "Apple");
        driver.close();
        driver.switchTo().window(mainWindow);

        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));

    }
}