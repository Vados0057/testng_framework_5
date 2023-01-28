package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalFileUploadPage extends TechGlobalBasePage{
    public TechGlobalFileUploadPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "file_upload")
    public WebElement fileUploadButton;

    @FindBy(id = "file_submit")
    public WebElement uploadButton;
    @FindBy(id = "result")
    public WebElement result;
}
