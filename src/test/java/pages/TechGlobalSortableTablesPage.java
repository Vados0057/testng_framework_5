package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import scripts.TechGlobalBase;

public class TechGlobalSortableTablesPage extends TechGlobalBasePage {

    public TechGlobalSortableTablesPage(){
        super();
    }

    @FindBy(id ="quantitiy_asc")
    public WebElement ascByQuantity;

    @FindBy(id ="quantitiy_desc")
    public WebElement descByQuantity;

    @FindBy(id ="price_asc")
    public WebElement asdByPrice;

    @FindBy(id ="price_desc")
    public WebElement descByPrice;
}
