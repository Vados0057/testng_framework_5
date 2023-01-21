package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Driver;
import utilities.Waiter;

public class TechGlobalWaitsTest extends TechGlobalBase {
/*
        Waits
        Go to https://techglobal-training.netlify.app/
        Click on "Practices" dropdown in the header
        Select the "Frontend Testing" option
        Click on the "Waits" card
        Click on "Click on me to see a red box" button
        Validate a red box is displayed
 */

    @BeforeMethod
    public void setPage() {
        techGlobalWaitsPage = new TechGlobalWaitsPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
    }

    @Test(priority = 1, description = "Validate a red box is displayed")
    public void validateARedBoxIsDisplayed() {
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(3);

        // techGlobalWaitsPage.redBoxButton.click();
        techGlobalWaitsPage.blueBoxButton.click();

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
//        wait.until(ExpectedConditions.visibilityOf(techGlobalWaitsPage.blueBox));
        Waiter.waitForVisibilityOfElement(techGlobalWaitsPage.blueBox, 60);

        // Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());
        Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());
    }


}