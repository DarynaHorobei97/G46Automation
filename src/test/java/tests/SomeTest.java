package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class SomeTest extends BaseTest {
    private LoginPage page;


    @Before
    public void setPage() {
        page = new LoginPage(driver);
    }

    @Test
    public void ourTest() {
        page.checkAuthFields();
    }




}
