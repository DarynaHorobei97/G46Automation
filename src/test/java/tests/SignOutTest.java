package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.ProfileForm;
import pages.ProjectPage;

public class SignOutTest extends BaseTest {
    private ProfileForm page;


    @Before
    public void signIn() {
        page = new LoginPageObject(driver).login(System.getProperty("login"), System.getProperty("password"))
                .openOurProjectpage().openProfileForm();

    }

    @Test
    public void isSignOutSuccessful(){
        page.signOutFromGitHub();
    }

    @Test
    public void isSignOut(){
        page.signOutFromGitHub(true);
    }

}
