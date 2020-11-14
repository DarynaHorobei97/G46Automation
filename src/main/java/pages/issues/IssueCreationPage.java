package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssueCreationPage extends BasePage {

    private final static String TITLE = "The page of tasks creation";
    private final By issueTitleField = By.id("issue_title");
    private final By issueBodyField = By.id("issue_body");
    private final By submitButton = By.xpath("//*[@id=\"new_issue\"]//button[@class='btn btn-primary']");


    public IssueCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssueInfoPage createNewIssue(String title, String body) {
        log.info("New issue creation started");
        Assert.assertTrue(driver.findElement(issueTitleField).isDisplayed());
        driver.findElement(issueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(issueBodyField).isDisplayed());
        driver.findElement(issueBodyField).sendKeys(body);
        Assert.assertTrue(driver.findElement(submitButton).isDisplayed());
        driver.findElement(submitButton).click();
        log.info("New issue is created successfully");
        return new IssueInfoPage(driver);
    }


}
