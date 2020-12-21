package pages.projects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.issues.IssuesPage;
import pages.settings.SettingsPage;

public class ProjectsPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница проекта";

    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");
    private final By settingsTab = By.xpath("//span[@data-content = 'Settings']");
    private final By repoLink = By.xpath("//a[@data-pjax='#js-repo-pjax-container']");

    public ProjectsPage(WebDriver driver) {
        super(driver, TITLE);
    }
    @Step("Open project issue")
    public IssuesPage openProjectIssues(){
        try {
            driver.findElement(issuesTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new IssuesPage(driver);
    }

    public SettingsPage openSettingsPage(){
        try {
            driver.findElement(settingsTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new SettingsPage(driver);
    }

    public ProjectsPage validateRenaming(String expectedTitle){
        Assert.assertTrue(driver.findElement(repoLink).getText().endsWith(expectedTitle));
        return this;
    }
}