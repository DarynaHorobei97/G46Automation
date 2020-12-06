package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PullRequests.PullRequestsPage;
import pages.actions.ActionsPage;
import pages.issues.IssueCreationPage;
import pages.issues.IssuesPage;
import pages.projects.ProjectsPage;

public abstract class TabsSwitcher extends BasePage {

    private By tabs = By.xpath("//span[@data-content]");


    public TabsSwitcher(WebDriver driver, String title) {
        super(driver, title);
    }

//    public void goToTab(String tabName) {
//        switch (tabName) {
//            case "Code":
//                driver.findElements(tabs).get(0).click();
//                break;
//            case "Issues":
//                driver.findElements(tabs).get(1).click();
//                break;
//            case "Pull requests":
//                driver.findElements(tabs).get(2).click();
//                break;
//            case "Actions":
//                driver.findElements(tabs).get(3).click();
//                break;
//            case "Projects":
//                driver.findElements(tabs).get(4).click();
//                break;
//            case "Wiki":
//                driver.findElements(tabs).get(5).click();
//                break;
//            case "Security":
//                driver.findElements(tabs).get(6).click();
//                break;
//            case "Insights":
//                driver.findElements(tabs).get(7).click();
//                break;
//        }
//    }

    public ProjectsPage goToCodeTab() {
        driver.findElements(tabs).get(0).click();
        return new ProjectsPage(driver);
    }

    public IssuesPage goToIssueTab() {
        driver.findElements(tabs).get(1).click();
        return new IssuesPage(driver);
    }

    public PullRequestsPage goToPullRequestsTab() {
        driver.findElements(tabs).get(2).click();
        return new PullRequestsPage(driver);
    }

    public ActionsPage goToActionsTab() {
        driver.findElements(tabs).get(3).click();
        return new ActionsPage(driver);
    }

    public ProjectsPage goToProjectsTab() {
        driver.findElements(tabs).get(4).click();
        return new ProjectsPage(driver);
    }

    public WikiPage goToWikiTab() {
        driver.findElements(tabs).get(5).click();
        return new WikiPage(driver);
    }

    public SecurityPage goToSecurityTab() {
        driver.findElements(tabs).get(6).click();
        return new SecurityPage(driver);
    }

    public InsightsPage goToInsightsTab() {
        driver.findElements(tabs).get(6).click();
        return new InsightsPage(driver);
    }


}
