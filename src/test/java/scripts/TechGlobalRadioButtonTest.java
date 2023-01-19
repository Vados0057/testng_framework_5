package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicElementsPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalRadioButtonsPage;
import utilities.Waiter;

public class TechGlobalRadioButtonTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalRadioButtonsPage = new TechGlobalRadioButtonsPage();
    }

    /*
            Go to https://techglobal-training.netlify.app/
        Click on "Practices" dropdown in the header
        Select the "Frontend Testing" option
        Click on the "Radio Buttons" card
        Validate "Java", "JavaScript" and "C#" radio buttons are displayed, enabled and not selected
        Select "Java" and validate it is selected but the other 2 are deselected
        Select "JavaScript" validate it is selected but the other 2 are deselected
     */

    @Test(priority = 1)
    public void validateRadioButtons1() {
    techGlobalFrontendTestingHomePage.getFrontendTestingPage();
    techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (WebElement element : techGlobalRadioButtonsPage.firstBlockLabel) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertFalse(element.isSelected());
        }

        techGlobalRadioButtonsPage.firstBlockLabel.get(0).click();
        Waiter.pause(2);

        Assert.assertTrue(techGlobalRadioButtonsPage.firstBlockInput.get(0).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.firstBlockInput.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.firstBlockInput.get(2).isSelected());

        techGlobalRadioButtonsPage.firstBlockLabel.get(1).click();
        Waiter.pause(2);

        Assert.assertFalse(techGlobalRadioButtonsPage.firstBlockInput.get(0).isSelected());
        Assert.assertTrue(techGlobalRadioButtonsPage.firstBlockInput.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.firstBlockInput.get(2).isSelected());
    }

    @Test(priority = 2)
    public void validateRadioButtons2(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (WebElement element : techGlobalRadioButtonsPage.secondBlockLabel) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertFalse(element.isSelected());
        }
        techGlobalRadioButtonsPage.secondBlockLabel.get(1).click();
        Waiter.pause(2);

        Assert.assertFalse(techGlobalRadioButtonsPage.secondBlockInput.get(0).isSelected());
        Assert.assertTrue(techGlobalRadioButtonsPage.secondBlockInput.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.secondBlockInput.get(2).isSelected());

        techGlobalRadioButtonsPage.secondBlockLabel.get(2).click();
        Waiter.pause(2);

        Assert.assertFalse(techGlobalRadioButtonsPage.secondBlockInput.get(0).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.secondBlockInput.get(1).isSelected());
        Assert.assertTrue(techGlobalRadioButtonsPage.secondBlockInput.get(2).isSelected());

    }


}
