package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.ProfileForm;
import pages.issues.IssuesPage;

import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readExcelFile;
import static helpers.FileHelper.readDataFromFile;


@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest{

    private IssuesPage page;
    private ProfileForm profileForm;
    private boolean systemProperties;

    private String title;
    private String body;
    private List<String> labels;

    public IssueCreationTest(String title,
                             String body,
                             List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static Collection<? extends Object> data(boolean systemProperties){
        if (systemProperties == true)
        {return  readExcelFile("C:\\Users\\Daryna_Horobei\\IdeaProjects\\G46Automation\\src\\main\\resources\\data\\ExcelFile.xlsx","Sheet1");}
        else
        return readDataFromFile("C:\\Users\\Daryna_Horobei\\IdeaProjects\\G46Automation\\src\\main\\resources\\data\\issues.txt");
    }

    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation")
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation(){
        page.pressToCreateNewIssue()
                .createNewIssue(this.title, this.body, this.labels)
                .validateCreatedIssue(this.title, this.body, this.labels);
    }

    @Test
    public void checkSignOutFromGitHub(){
        profileForm.signOutFromGitHub();
    }

}