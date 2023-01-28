package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramePage;
import utilities.Waiter;

public class TechGlobalIFrameTest extends TechGlobalBase {

    @BeforeMethod
    public void sePage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramePage = new TechGlobalIFramePage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }

            /*
            Go to https://techglobal-training.netlify.app/
        Click on “Practices” dropdown in the header
        Select the “Frontend Testing” option
        Click on the “IFrames” card
        Validate the “Please fill out your information below” text
             */

    @Test(priority = 1, description = "Validate input header text")
    public void validateInputText() {

        driver.switchTo().frame(techGlobalIFramePage.iFrameId);
        Assert.assertTrue(techGlobalIFramePage.testHeader.isDisplayed());
        Assert.assertEquals(techGlobalIFramePage.testHeader.getText(), "Please fill out your information below");
        Waiter.pause(3);
    }

            /*
            Go to https://techglobal-training.netlify.app/
        Click on “Practices” dropdown in the header
        Select the “Frontend Testing” option
        Click on the “IFrames” card
        Enter “John” to first name input box
        Enter “Doe” to last name input box
        Click on “SUBMIT” button
        Validate the result equals “You entered: John Doe”
             */

    @Test(priority = 2, description = "Validate input")
    public void validateInput() {

        driver.switchTo().frame(techGlobalIFramePage.iFrameId);
        techGlobalIFramePage.firstNameInput.sendKeys("John");
        techGlobalIFramePage.lastNameInput.sendKeys("Doe");
        techGlobalIFramePage.submitButton.click();

        driver.switchTo().parentFrame();
        Assert.assertTrue(techGlobalIFramePage.resultText.isDisplayed());
        Assert.assertEquals(techGlobalIFramePage.resultText.getText(), "You entered: John Doe");
    }


}