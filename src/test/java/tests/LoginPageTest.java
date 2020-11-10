package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPageObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class LoginPageTest extends BaseTest {

    private LoginPageObject page;
    private String errorMessage;
    private String invalidMessage;

    @Before
    public void setPage() {
        this.page = new LoginPageObject(driver);
        this.errorMessage = "There have been several failed attempts to sign in from this account or IP address. " +
                "Please wait a while and try again later.";
        this.invalidMessage = "Incorrect username or password.";
    }

    @Test
    public void negativeAuthTest() {
        try {
            page.checkAuthFields()
                    .login("admin", "admin")
                    .validateErrorMessage(errorMessage)
                    .returnToLoginPage()
                    .login("login", "password")
                    .validateErrorMessage(invalidMessage, true);
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void loginTest() {
        page.login("daryna_horobei1@ukr.net", "xxxx");
    }


    @Test
    public void goToG46AutomRep() {
        page.login("daryna_horobei1@ukr.net", "xxxx");
        page.goToG46RepositoryThe1stVariant("https://github.com/DarynaHorobei97/G46Automation");

    }

    @Test
    public void goToSomeRepository(){
        page.login("daryna_horobei1@ukr.net", "xxxx");
        page.checkIfRepositoryIsPresentAndOpenIt("G46Automation");

    }

    @Test
    public void checkSeleniumVersion(){
        page.goToG46RepositoryThe1stVariant("https://github.com/DarynaHorobei97/G46Automation");
        page.findSeleniumVersion("3.141.59");

    }

    @Test
    public void checkOfSuccessfulSignOut(){
        page.login("daryna_horobei1@ukr.net", "xxxx");
        page.signOutFromGitHub();
    }
}
