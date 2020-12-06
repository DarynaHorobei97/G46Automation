package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.code.ProjectPage;

public class PrintNameTabsTest extends BaseTest {

    private ProjectPage page;

//    @Before
//    public void signIn() {
//        page = new LoginPage(driver)
//                .login(System.getProperty("login"), System.getProperty("password"))
//                .openOurProjectpage();
//
//    }

    @Test
    public void printTabsInDiffColors() {
        page.colorfulTabsNames();
    }

    @Test
    public void printTabsInDiffColors1() {
        page.colorfulTabNames1();

    }
}
