package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProfileForm;

public class SignOutTest extends BaseTest {
    private ProfileForm page;


//    @Before
//    public void signIn() {
//        page = new LoginPage(driver)
//                .login(System.getProperty("login"), System.getProperty("password"))
//                .goToProfileForm();
//
//    }

    @Test
    public void isSignOutSuccessful(){
        page.signOutFromGitHub();
    }

    @Test
    public void isSignOut(){
        page.signOutFromGitHub(true);
    }

}
