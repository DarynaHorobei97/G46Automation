package tests;

import org.junit.Before;
import org.junit.Test;
import pages.AbstractMainProjectPage;
import pages.LoginPageObject;
import pages.MainPage;
import pages.ProjectPage;

public class PrintNameTabsTest extends BaseTest {

    private ProjectPage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProjectpage();

    }

    @Test
    public void printTabsInDiffColors() {
        page.colorfulTabsNames();
    }

    @Test
    public void printTabsInDiffColors1() {
        page.colorfulTabNames1();

    }
}
