package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractMainProjectPage;
import pages.issues.IssuesPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProjectPage extends AbstractMainProjectPage {
    private final static String TITLE = "Project page";
    private final By avatar = By.xpath("//img[@class='avatar avatar-user']");
    private By issueTab = By.xpath("//span[@data-content='Issues']");
    private final By searchField = By.xpath("//input[@data-unscoped-placeholder = 'Search or jump to…']");
    private final By searchResults = By.xpath("//li[contains(@id, 'jump-to-suggestion-')]");
    protected WebDriverWait webDriverWait_10, webDriverWait_15, webDriverWait_20;
    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

        public ProjectPage searchProject (String projectName){
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        webDriverWait_10.until(elementToBeClickable(searchResults));
        driver.findElements(searchResults).get(1).click();
        return new ProjectPage(driver);
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




