package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalStaticTablesPage;
import utilities.TableData;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalStaticTablesTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalStaticTablesPage = new TechGlobalStaticTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Static Tables");
    }

    /**
     * Verify the headers of the table
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that the headers of the table are “Rank”, “Company”, “Employees”, and “Country”
     * Verify the rows of the table
     */

    @Test(priority = 1)
    public void validateHeader() {
        String[] headerText = {"Rank", "Company", "Employees", "Country"};
//        for (int i = 0; i < techGlobalStaticTablesPage.tableHeader.size(); i++) {
//            Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headerText[i]);
//        }
        IntStream.range(0, headerText.length).forEach(i -> {
            System.out.println(techGlobalStaticTablesPage.tableHeader.get(i).getText());
            Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headerText[i]);
        });
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that first row of the table has the values “1", “Amazon”, “1,523,000", and “USA”
     * Verify the columns of the table
     */

    @Test(priority = 2, description = "Validate first row of the table")
    public void validateRow() {
        String[] rowData = {"1", "Amazon", "1,523,000", "USA"};
        List<WebElement> tableRow = TableData.getTableRow(driver, 1);
        for (int i = 0; i < rowData.length; i++) {
            Assert.assertEquals(tableRow.get(i).getText(), rowData[i]);
        }
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that the “Country” column of the table has the values “USA”, “China”, “USA”, “USA”, “S. Korea”
     * Verify the entire table
     */

    @Test(priority = 3, description = "Validate column of the table")
    public void validateColumn() {
        String[] columnData = {"USA", "China", "USA", "USA", "S. Korea"};
        List<WebElement> tableColumn = TableData.getTableColumn(driver, 4);
        for (int i = 0; i < columnData.length; i++) {
            Assert.assertEquals(tableColumn.get(i).getText(), columnData[i]);
        }
    }
}