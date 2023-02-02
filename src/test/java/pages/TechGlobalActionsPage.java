package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalActionsPage extends  TechGlobalBasePage{
    public TechGlobalActionsPage(){
        super();
    }

    @FindBy (id = "click")
    public WebElement clickButton;

    @FindBy (id = "click_result")
    public WebElement clickResult;

    @FindBy(id = "right-click")
    public WebElement rightClick;

    @FindBy(id = "right_click_result")
    public WebElement rightClickResult;

    @FindBy(id = "double-click")
    public WebElement doubleClick;

    @FindBy(id = "double_click_result")
    public WebElement doubleClickResult;

    @FindBy(id = "drag_element")
    public WebElement dragMe;

    @FindBy(id = "drag_and_drop_result")
    public WebElement dragMeResult;

    @FindBy(id = "drop_element")
    public WebElement dropMe;

    @FindBy(id = "input_box")
    public WebElement textInput;
}
