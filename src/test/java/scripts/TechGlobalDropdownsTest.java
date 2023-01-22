package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }

    @Test(priority = 1, description = "Select delivery option")
    public void selectDeliveryOption() {


        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions, "Delivery");
        Waiter.pause(5);
    }

    /*
    Go to TechGlobal Training app
    Select Frontend Testing from Practices Dropdown
    Select Dropdowns card
    Select "iPhone 14 Pro Max" option from product dropdown
     */

    @Test(priority = 2, description = " Select \"iPhone 14 Pro Max\" option")
    public void selectProductOption() {
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.productDropdown, 1);
    }

    @Test(priority = 3, description = "Select Yellow option")
    public void selectColorOption() {
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.productDropdown, 1);
    }

    /*
            Go to TechGlobal Training app
        Select Frontend Testing from Practices Dropdown
        Select Dropdowns card
        Select "MacBook Pro 13" option from product dropdown
        Select "Silver" option from the color dropdown
        Select "Delivery" option from devivery dropdown
        Click on SUBMIT button
        Validate "Your Silver MacBook Pro 13 will be delivered to you." message
             */
    @Test(priority = 4,description = "Validate the selected item message")
    public void validateOrder(){
        String result = "Your Silver MacBook Pro 13 will be delivered to you.";
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.productDropdown, 3);
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 3);
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions, "Delivery");
        techGlobalDropdownsPage.submitButton.click();
        Assert.assertEquals(techGlobalDropdownsPage.resultMessage.getText(), result);
    }

}