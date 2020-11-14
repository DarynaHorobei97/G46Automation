package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.issues.IssuesPage;

public class ProjectPage extends BasePage {
    private final static String TITLE = "Project page";
    private By issueTab = By.xpath("//span[@data-content='Issues']");

    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssuesPage openProjectIssues() {
        try {
            driver.findElement(issueTab).click();
        } catch (NoSuchElementException n) {
            Assert.fail(n.getMessage());
        }

        return new IssuesPage(driver);
    }
}
