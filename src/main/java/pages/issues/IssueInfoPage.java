package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static helpers.ColorPrinter.printColorMessage;

public class IssueInfoPage extends BasePage {
    private final static String TITLE = "The page containing infortmation about issue";
    private final By title = By.xpath("//span[@class='js-issue-title']");
    private final By statusImg = By.xpath("//div[contains(@class,'self-center')]/span");
    private final By description = By.xpath("//td[contains(@class,'js-comment-body')]");

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }


    public IssueInfoPage validateCreatedIssue(String titleText, String body) {
        printColorMessage("New issue creation checking", log, Level.INFO);
        try {
            Assert.assertEquals(titleText, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImg).isDisplayed());
            Assert.assertEquals(body, driver.findElement(description).getText());
        } catch (NoSuchElementException n) {
            Assert.fail("The issue was created invalid" + n.getMessage());

        }
        printColorMessage("Data validation passed. The issue was created successfully", log, Level.INFO);
        return this;
    }
}
