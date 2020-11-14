package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssuesPage extends BasePage {

    private By newIssueButton = By.xpath("//a[@class='btn btn-primary']");
    private final static String TITLE = "The page containing tasks list";

    public IssuesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssueCreationPage pressToCreateNewIssue() {
        log.info("Click on \"New issue creation\"");
        Assert.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        driver.findElement(newIssueButton).click();
        log.info("Button is clicked");
        return new IssueCreationPage(driver);
    }
}
