package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalRadioButtonsPage extends TechGlobalBasePage{
    public TechGlobalRadioButtonsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "#radio-button-group_1 label")
    public List<WebElement> firstBlock;

    @FindBy(css = "#radio-button-group_1 input")
    public List<WebElement> firstBlockInput;

    @FindBy(id = "radio-button-group_2")
    public List<WebElement> secondBlock;

    @FindBy(css = "#radio-button-group_2 input")
    public List<WebElement> secondBlockInput;

}