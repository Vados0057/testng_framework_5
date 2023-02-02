package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.security.Key;
import java.time.Duration;

public class TechGlobalActionsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionsPage = new TechGlobalActionsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
        actions = new Actions(driver);
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled as "Click on me"
     * Verify that  message appears next of the element stating "You clicked on a button!"
     * Perform a right click action on the second web element labeled as "Right-Click on me""
     * Verify that  message appears next of the element stating "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled as "Double-Click on me"
     * Verify that  message appears next of the element stating "You double-clicked on a button!"
     */

    @Test(priority = 1, description = "Click first 3 boxes and validate they results")
    public void clickActions() {
        Assert.assertTrue(techGlobalActionsPage.clickButton.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.clickButton.getText(), "Click on me");

        Assert.assertTrue(techGlobalActionsPage.rightClick.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.rightClick.getText(), "Right-Click on me");

        Assert.assertTrue(techGlobalActionsPage.doubleClick.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.doubleClick.getText(), "Double-Click on me");

        actions.moveToElement(techGlobalActionsPage.clickButton).click().perform();
        Assert.assertTrue(techGlobalActionsPage.clickResult.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.clickResult.getText(), "You clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.rightClick).contextClick().perform();
        Assert.assertTrue(techGlobalActionsPage.rightClickResult.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.rightClickResult.getText(), "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.doubleClick).doubleClick().perform();
        Assert.assertTrue(techGlobalActionsPage.doubleClickResult.isDisplayed());
        Assert.assertEquals(techGlobalActionsPage.doubleClickResult.getText(), "You double-clicked on a button!");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating "An element dropped here!"
     */

//    @Test
//    public void validate() {
//
//        // actions.moveToElement(techGlobalActionsPage.dragMe).clickAndHold().moveToElement(techGlobalActionsPage.dropMe).release().perform();
//
//        actions.dragAndDrop(techGlobalActionsPage.dragMe, techGlobalActionsPage.dropMe).perform();
//
//        Waiter.waitForVisibilityOfElement(techGlobalActionsPage.dragMeResult, 10);
//        Assert.assertEquals(techGlobalActionsPage.dragMeResult.getText(), "An element dropped here!");
//    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “Hello” to search input box
     * Validate value attribute is “Hello”
     */

    @Test(priority = 3, description = "Keybord Actions")
    public void keyboardActions() {
        actions.keyDown(Keys.SHIFT).sendKeys(techGlobalActionsPage.textInput, "h")
                .keyUp(Keys.SHIFT)
                .sendKeys("ello")
                .perform();
        Assert.assertEquals(techGlobalActionsPage.textInput.getAttribute("value"), "Hello");
    }


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “techglobal” to input box with uppercases
     * Validate the value attribute for search input box is “TECHGLOBAL”
     * Then, copy the text and paste again
     * Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test
    public void keyboardActions2() {
        techGlobalActionsPage.textInput.clear();
        actions.keyDown(Keys.SHIFT).sendKeys(techGlobalActionsPage.textInput, "techglobal").keyUp(Keys.SHIFT)
                .perform();
        actions.keyDown(Keys.COMMAND).sendKeys(techGlobalActionsPage.textInput,"A").keyUp(Keys.COMMAND);
        Assert.assertEquals(techGlobalActionsPage.textInput.getAttribute("value"), "TECHGLOBAL");
        actions.keyDown(Keys.COMMAND).sendKeys(techGlobalActionsPage.textInput,"c").perform();
        actions.sendKeys(techGlobalActionsPage.textInput,"v").perform();
        Assert.assertEquals(techGlobalActionsPage.textInput.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
        Waiter.pause(3);
    }
}
