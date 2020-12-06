package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

import java.util.NoSuchElementException;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPositiveTest extends BaseTest {
    private LoginPage page;
    @Before
    public void setPage(){
        printMessageInYellow("===Test started===");
        this.page=new LoginPage(driver);
    }

//    @Test
//    public void checkPositiveLogin(){
//        try {
//            page.checkAuthFields()
//                    .login(System.getProperty("login"), System.getProperty("password"))
//                    .validateLogin();
//        } catch (NoSuchElementException e) {
//            Assert.fail(e.getMessage());
//        }
//    }
    @After
    public void tearDown(){
        printMessageInYellow("===Test finished===");
        driver.quit();
    }
}
