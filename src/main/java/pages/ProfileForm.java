package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProfileForm extends AbstractMainProjectPage {

    private final static String TITLE = "Profile form";
    private final By viewProfileAndMoreButton = By.xpath("//details/summary[@aria-label='View profile and more']/span[@class='dropdown-caret']");
    private final By signOutButton = By.xpath("//button[contains(text(),'Sign out')]");
    private final By successIndicatorOfSigningOut = By.xpath("//h1[contains(text(),'Built')]");


    public ProfileForm(WebDriver driver) {
        super(driver, TITLE);
    }

    @Step("Go to profile")
    public ProfileForm goToProfileForm(String login, String password){
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        driver.get("https://github.com/DarynaHorobei97/G46Automation");
        driver.findElement(viewProfileAndMoreButton).click();
        return new ProfileForm(driver);
    }
    @Step("Sign out from GitHub")
        public LoginPage signOutFromGitHub() {
        driver.findElement(viewProfileAndMoreButton).click();
        Assert.assertTrue(driver.findElement(viewProfileAndMoreButton).isDisplayed());
        Assert.assertTrue(driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Built for developers", driver.findElement(successIndicatorOfSigningOut).getText());
        return new LoginPage(driver);
    }
    @Step("Sign out from GitHub")
    public LoginPage signOutFromGitHub(boolean isSignOutWithoutCheck) {
        driver.findElement(viewProfileAndMoreButton).click();
        Assert.assertTrue(driver.findElement(viewProfileAndMoreButton).isDisplayed());
        Assert.assertTrue(driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        return new LoginPage(driver);
    }


}
