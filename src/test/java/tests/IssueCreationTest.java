package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.issues.IssuesPage;

public class IssueCreationTest extends BaseTest {
    private IssuesPage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver).login(System.getProperty("login"), System.getProperty("password"))
                .openOurProjectpage()
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation() {
        page.pressToCreateNewIssue()
                .createNewIssue("Automated title", "Test body")
                .validateCreatedIssue("Automated title", "Test body");
    }
}
