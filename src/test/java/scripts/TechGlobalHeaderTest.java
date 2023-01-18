package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalHeaderTest extends TechGlobalBase{

    @Test(priority = 1)
    public void validateTechGlobalHeaderDropdown(){
        //Do your test here
        Assert.assertTrue(techGlobalBasePage.headerDropdown.isDisplayed());
        Assert.assertEquals(techGlobalBasePage.headerDropdown.getText(), "Practices");
    }

    @Test(priority = 2)
    public void validateTechGlobalHeaderDropdownOptions(){
        techGlobalBasePage.headerDropdown.click();

        String[] elementsNames = {"Frontend Testing","Backend Testing","Java Exercises"};

        for (int j = 0; j < techGlobalBasePage.headerDropdownOptions.size(); j++) {
            Assert.assertTrue(techGlobalBasePage.headerDropdownOptions.get(j).isDisplayed());
            Assert.assertTrue(techGlobalBasePage.headerDropdownOptions.get(j).isEnabled());
            Assert.assertEquals(techGlobalBasePage.headerDropdownOptions.get(j).getText(), elementsNames[j]);
        }

    }
}