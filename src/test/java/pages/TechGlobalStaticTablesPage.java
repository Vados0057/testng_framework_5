package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalStaticTablesPage extends TechGlobalBasePage {

    public TechGlobalStaticTablesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".header")
    public List<WebElement> tableHeader;

    @FindBy(xpath = "(//tbody//tr)[1]//td")
    public List<WebElement> firstRow;

}
