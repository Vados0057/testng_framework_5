package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalIFramePage extends TechGlobalBasePage {

    public TechGlobalIFramePage() {
        super();
    }

    @FindBy(css = "#name_form>p")
    public WebElement testHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;

    @FindBy(css = "#first_name")
    public WebElement firstNameInput;

    @FindBy(css = "#result")
    public WebElement resultText;

    @FindBy(css = "#last_name")
    public WebElement lastNameInput;

    @FindBy(css = "#submit")
    public WebElement submitButton;


}
