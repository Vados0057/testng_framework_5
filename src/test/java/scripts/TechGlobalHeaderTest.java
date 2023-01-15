package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalHeaderTest extends TechGlobalBase{

    @Test(priority = 1)
    public void validateTechGlobalHeaderDropdown(){
        //Do your test here
        Assert.assertTrue(techGlobalBasePage.headerDropDown.isDisplayed());
        Assert.assertEquals(techGlobalBasePage.headerDropDown.getText(), "Practices");
    }

    @Test(priority = 2)
    public void validateTechGlobalHeaderDropdownOptions(){
        techGlobalBasePage.headerDropDown.click();

        String[] elementsNames = {"Frontend Testing","Backend Testing","Java Exercises"};

        for (int j = 0; j < techGlobalBasePage.headerDropDownOptions.size(); j++) {
            Assert.assertTrue(techGlobalBasePage.headerDropDownOptions.get(j).isDisplayed());
            Assert.assertTrue(techGlobalBasePage.headerDropDownOptions.get(j).isEnabled());
            Assert.assertEquals(techGlobalBasePage.headerDropDownOptions.get(j).getText(), elementsNames[j]);
        }

    }
}