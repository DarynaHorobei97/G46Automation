package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;

import java.util.NoSuchElementException;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPageTest extends BaseTest {

    private LoginPageObject page;
    private String errorMessage;
    private String invalidMessage;

    @Before
    public void setPage() {
        printMessageInYellow("===Test started===");
        this.page = new LoginPageObject(driver);
        this.errorMessage = "There have been several failed attempts to sign in from this account or IP address. " +
                "Please wait a while and try again later.";
        this.invalidMessage = "Incorrect username or password.";

    }

    @Test
    public void negativeAuthTest() {

            page.checkAuthFields()
                    .loginNegative("admin", "admin")
                    .validateErrorMessage(errorMessage)
                    .returnToLoginPage()
                    .loginNegative("login", "password")
                    .validateErrorMessage(invalidMessage, true);

    }

    @Test
    public void loginTest() {
        page.loginNegative("daryna_horobei1@ukr.net", "xxxx");
    }


    @Test
    public void goToG46AutomRep() {
        page.loginNegative("daryna_horobei1@ukr.net", "xxxx");
        page.goToG46RepositoryThe1stVariant("https://github.com/DarynaHorobei97/G46Automation");

    }

    @Test
    public void goToSomeRepository(){
        page.loginNegative("daryna_horobei1@ukr.net", "xxxx");
        page.checkIfRepositoryIsPresentAndOpenIt("G46Automation");

    }

    @Test
    public void checkSeleniumVersion(){
        page.goToG46RepositoryThe1stVariant("https://github.com/DarynaHorobei97/G46Automation");
        page.findSeleniumVersion("3.141.59");

    }

    @Test
    public void checkOfSuccessfulSignOut(){
        page.loginNegative("daryna_horobei1@ukr.net", "xxxx");
        page.signOutFromGitHub();
    }

    @Test
    public void shownSystemVars(){
        System.out.println(System.getProperty("login"));
        System.out.println(System.getProperty("password"));
    }


    @Test
    public void checkPositiveLogin(){
        try {
            page.checkAuthFields()
                    .login(System.getProperty("login"), System.getProperty("password"))
                    .validateLogin();
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }
    @After
    public void tearDown(){
        printMessageInYellow("===Test finished===");
        driver.quit();
    }
}
